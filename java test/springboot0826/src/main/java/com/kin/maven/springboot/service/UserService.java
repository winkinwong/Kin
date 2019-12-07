package com.kin.maven.springboot.service;

import com.kin.maven.springboot.model.User;

public interface UserService {
     Long addUser(User user);

    User getUserByName(String userName);
}
