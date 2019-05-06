package com.zfy.adminService.service;

import com.zfy.adminService.dao.StuMapper;
import com.zfy.common.pojo.Stu;
import com.zfy.common.util.FileUtil;
import com.zfy.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
public class StuService {
    @Value("${file.dir}")
    private String fileDir;

    @Value("${file.url}")
    private String fileUrl;

    @Autowired
    StuMapper stuMapper;
    /**
     * 资源上传
     * @return
     */
    public BiliResult stuUpload(MultipartFile multipartFile, Stu stu){
        stuMapper.insert(stu);
        Stu stu1=stuMapper.selectOne(stu);
        String url=FileUtil.uploadFile(multipartFile,fileDir,fileUrl,stu1.getTypeId()+"/"+stu1.getStuId());
        stu1.setStuUrl(url);
        Date date=new Date();
        stu1.setCreatedTime(date);
        stuMapper.updateStu(stu1);
        if(url==null){
            return BiliResult.build(201,"上传失败");
        }
        return BiliResult.oK(url);
    }

    /**
     * 模糊查询
     * @param name
     * @return
     */
    public  BiliResult selectByName(String name){
        List<Stu>list=stuMapper.selectByName("%"+name+"%");
        return BiliResult.oK(list);
    }

    /**
     * 条件查询
     * @param stu
     * @return
     */
    public BiliResult selectMany(Stu stu){
        List<Stu>list=stuMapper.select(stu);
        return BiliResult.oK(list);
    }

    /**
     * 查询某个资源
     * @param stu
     * @return
     */
    public BiliResult selectOne(Stu stu){
        Stu stu1=stuMapper.selectOne(stu);
        return BiliResult.oK(stu1);
    }

}
