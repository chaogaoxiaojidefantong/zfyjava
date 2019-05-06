package com.zfy.adminService.service;

import com.zfy.adminService.dao.StuMapper;
import com.zfy.adminService.dao.StuTypeMapper;
import com.zfy.common.pojo.Stu;
import com.zfy.common.pojo.StuType;
import com.zfy.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StuTypeService {

    @Autowired
    StuTypeMapper stuTypeMapper;

    @Autowired
    StuMapper stuMapper;

    public BiliResult selectOne(StuType stuType){
        StuType stuType1=stuTypeMapper.selectOne(stuType);
        if(stuType1==null){
            return BiliResult.build(201,"没有这个类型");
        }
        return BiliResult.oK(stuType1);
    }

    public BiliResult selectMany(StuType stuType){
        List<StuType> list=stuTypeMapper.select(stuType);
        if(list.size()==0){
            return BiliResult.build(201,"没有数据");
        }
        return BiliResult.oK(list);
    }

    /**
     * 查询所有类型以及所有类型下的资源
     */
    public BiliResult selectManyAndStu(){
    //List list=stuTypeMapper.selectManyAndStu();
        List<StuType> list=stuTypeMapper.select(null);
        List<Map>result=new ArrayList();
        for(StuType stuType:list){
            Map map=new HashMap();
            Integer typeId=stuType.getTypeId();
            Stu stu=new Stu();
            stu.setTypeId(typeId);
            List<Stu> l1=stuMapper.select(stu);
            map.put("stuTypeId",stuType.getTypeId());
            map.put("typeName",stuType.getTypeName());
            map.put("stuList",l1);
            result.add(map);
        }
    return BiliResult.oK(result);
    }
}
