package com.kin.maven.springboot.dao;

import com.kin.maven.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    Long addUser(User user);

    User getUserByName(@Param("userName") String userName);

    List<User> getUserFotList();

    Long deleteById(@Param("userId")Long userId);
}
