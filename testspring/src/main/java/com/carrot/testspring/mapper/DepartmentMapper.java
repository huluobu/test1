package com.carrot.testspring.mapper;


//import com.carrot.testspring.entities.Department;
import org.apache.ibatis.annotations.*;
import com.carrot.testspring.bean.Department;

/**
 * @author carrot
 */

public interface DepartmentMapper {

    @Select("Select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete * from department where id=#(id)")
    public int deleteDeptById(Integer id);


    @Options(useGeneratedKeys = true,keyProperty ="id" )
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDepd(Department department);


    @Update("update department set departmentName=#{departmentName}")
    public int update(Department department);
}
