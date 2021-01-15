package com.persistenthuang.lan108admin.service;

import com.persistenthuang.lan108admin.mapper.UserMapper;
import com.persistenthuang.lan108admin.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public boolean isExistByName(String username) {
        User user = new User();
        user.setUserName(username);
        User userBack = userMapper.selectOne(user);
        return null!=userBack;
    }

    @Override
    public boolean isExistByEmail(String email) {
        User user = new User();
        user.setUserEmail(email);
        User userBack = userMapper.selectOne(user);
        return userBack!=null;
    }

    @Override
    public boolean isExistByID(int id) {
        User user = new User();
        user.setId(id);
        User userBack = userMapper.selectOne(user);
        return userBack!=null;
    }

    @Override
    public boolean isAuthor(int id) {
        User user = new User();
        user.setId(id);
        User userBack = userMapper.selectOne(user);
        return userBack.getUserAuthorId() != 0;
    }

    @Override
    public int getAuthorID(int id) {
        User user = new User();
        user.setId(id);
        User userBack = userMapper.selectOne(user);
        return userBack.getUserAuthorId();
    }

    @Override
    public User getByName(String username) {
        User user = new User();
        user.setUserName(username);
        return userMapper.selectOne(user);
    }


    @Override
    public User getUserById(int id) {
        User user = new User();
        user.setId(id);
        return userMapper.selectOne(user);
    }

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateAuthor(User user) {
        this.userMapper.update(user);
    }
}
