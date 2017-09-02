package com.latyshonak.service.Impl;


import com.latyshonak.dao.UsersDao;
import com.latyshonak.entity.Users;
import com.latyshonak.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersDao userDao;

    @Override
    public List<Users> getAllUsers() {
        return null;
    }

    @Override
    public Users getUserById(Integer userId) {
        return (Users)userDao.get(userId);
    }

    @Override
    public Users getUserByUserName(String userName) {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    @Override
    public void insertUser(String login, String password, String Email) {
        Users user = new Users(login, password, Email);
        userDao.insert(user);
    }

    @Override
    public Integer saveUser(Users user) {
        return null;
    }
}
