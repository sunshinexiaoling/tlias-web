package com.tliasweb.mapper;

import com.tliasweb.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
//    @Select("select count(*) from emp")
//    public Long count();
//
//    @Select("select * from emp limit #{start},#{pageSize}")
//    public List<Emp> page(Integer start,Integer pageSize);

    public List<Emp> list(String name, Short gender,
                          LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void add(Emp emp);

    @Select("select * from emp where id=#{id}")
    Emp selectById(Integer id);

    void set(Emp emp);

    @Select("select * from emp where username=#{username} and password=#{password}")
    Emp selectByUsernameAndPassword(Emp emp);

    @Delete("delete from emp where dept_id=#{deptId}")
    void deleteById(Integer deptId);
}
