package com.zfy.adminService.dao;

import com.zfy.common.pojo.StuType;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

@Repository
public interface StuTypeMapper extends Mapper<StuType> {
    public List<HashMap> selectManyAndStu();
}
