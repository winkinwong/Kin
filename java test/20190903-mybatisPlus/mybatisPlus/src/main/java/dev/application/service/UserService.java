package dev.application.service;

import dev.application.dao.UserCardMapper;
import dev.application.dao.UserMapper;
import dev.application.exception.ErrorCode;
import dev.application.exception.UserException;
import dev.application.model.User;
import dev.application.model.UserCard;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    UserMapper userMapper;
    @Resource
    UserCardMapper userCardMapper;

    public User getUserInfo(Long id) {
        User user = getUserOrFail(id);
        UserCard userCard = getUserCard(user.getId());

        user.setCard(userCard);
        return user;
    }

    public User getUser(Long id) {
        return userMapper.selectById(id);
    }

    public User getUserOrFail(Long id) {
        User user = getUser(id);

        if (user == null) {
            throw new UserException(ErrorCode.USER_NOT_FOUND);
        }

        return user;
    }

    public UserCard getUserCard(Long userId) {
        return userCardMapper.selectById(userId);
    }

    public UserCard getUserCardOrFail(Long userId) {
        UserCard userCard = getUserCard(userId);

        if (userCard == null) {
            throw new UserException(ErrorCode.USER_CARD_NOT_FOUND);
        }

        return userCard;
    }

}
