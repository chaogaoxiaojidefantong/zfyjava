package com.zfy.adminService.dao;

import com.zfy.common.pojo.Stu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface StuMapper extends Mapper<Stu> {
    public Integer updateStu(Stu stu);

    public List<Stu>selectByName(@Param("stuName") String stuName);
}
