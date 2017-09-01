package com.latyshonak.service;


import com.latyshonak.entity.Users;

import java.util.List;

public interface UsersServiceInterface {

    List<Users> getAllUsers();

    Users getUserById(Integer userId);

    Users getUserByUserName(String userName);

    Integer saveUser(Users user);

    void deleteUser(Integer userId);

}
