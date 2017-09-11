package com.latyshonak.service;


import com.latyshonak.entity.Users;

import java.util.List;

public interface UsersService {

    List<Users> getAllUsers();

    Users getUserById(Integer userId);

    Users getUserByUserName(String userName);

    Integer saveUser(Users user);

    boolean checkUserByLogin(String login);

    void deleteUser(Integer userId);

    void insertUser( String login, String password, String Email);

}
