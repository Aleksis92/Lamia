package com.latyshonak.service.Impl;


import com.latyshonak.dao.UsersDao;
import com.latyshonak.entity.Users;
import com.latyshonak.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public List<Users> getAllUsers() {
        return null;
    }

    @Override
    public Users getUserById(Integer userId) {
        return (Users)usersDao.findOne(userId);
    }

    @Override
    public Users getUserByUserName(String userName) {
        return usersDao.findByLogin(userName);
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    @Override
    public void insertUser(String login, String password, String Email) {

        usersDao.save(new Users(login, password, Email));
    }

    @Override
    public Integer saveUser(Users user) {
        return null;
    }

    @Override
    public boolean checkUserByLogin(String login) {
        return false;
    }
}
