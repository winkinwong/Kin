package com.kin.test.springboot.dao;



import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kin.test.springboot.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User>{

    @Select("select user_id as userId,user_name as userName,user_password as userPassword,user_address as userAddress,user_phone as userPhone,create_time as createTime,update_time as updateTime,version from user where user_name=#{userName} and user_password = #{userPassword}")
    User login(@Param("userName")String userName,@Param("userPassword")String userPassword);
}
