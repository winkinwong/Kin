package cn.bd.test.springmvc.dao;

import cn.bd.test.springmvc.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserMapper")
public interface UserMapper {
    User getUserByUserName(@Param("userName")String userName);
    Integer register(User user);
    User login(@Param("userName") String userName,@Param("userPassword") String userPassword);
    Integer updatePassword(@Param("userPassword")String userPassword,@Param("userName")String userName);
    List<User> selectUserByConditions(@Param("lowerLimit") Long lowerLimit,@Param("upperLimit") Long upperLimit);
}
