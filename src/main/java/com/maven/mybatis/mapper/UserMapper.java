package com.maven.mybatis.mapper;

import com.maven.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Mapper//指定这是一个操作数据库的mapper（二选其一）
public interface UserMapper {

    int insertUser(User user);

    int deleteUser(User user);

    int updateUser(User user);

    User getUser(Integer userId);

    List<User> getUserList(@Param("userCondition") User userCondition, @Param("roeIndex") int row, @Param("pageSize") int pageSize);

    int getUserCount(@Param("userCondition") User userCondition);
}
