package com.latyshonak.service;

import com.latyshonak.dao.entity.Users;

import java.util.List;

public interface UsersService {

    List<Users> getAllUsers();

    Users getUserById(Integer userId);

    Users getUserByUserName(String userName);

    Integer saveUser(Users user);

    void deleteUser(Integer userId);

}
