package com.latyshonak.service;


import com.latyshonak.entity.Users;
import com.latyshonak.service.beans.UsersBean;

import java.util.List;

public interface UsersService {

    List<UsersBean> getAllUsers();

    UsersBean getUserById(Integer userId);

    UsersBean getUserByUserName(String userName);

    Integer saveUser(UsersBean user);

    boolean checkUserByLogin(String login);

    void deleteUser(Integer userId);

    void insertUser( String login, String password, String Email);

}
