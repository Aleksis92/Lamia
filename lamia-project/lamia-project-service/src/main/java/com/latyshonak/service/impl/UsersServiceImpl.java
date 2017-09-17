package com.latyshonak.service.impl;


import com.latyshonak.dao.UsersDao;
import com.latyshonak.entity.Users;
import com.latyshonak.service.EntityBeanConverter;
import com.latyshonak.service.UsersService;
import com.latyshonak.service.beans.UsersBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private EntityBeanConverter converter;

    @Override
    public List<UsersBean> getAllUsers() {
        return null;
    }

    @Override
    public UsersBean getUserById(Integer userId) {
        return converter.convertToBean(usersDao.findOne(userId), UsersBean.class);
    }

    @Override
    public UsersBean getUserByUserName(String userName) {
        return converter.convertToBean(usersDao.findByLogin(userName), UsersBean.class);
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    @Override
    public void insertUser(String login, String password, String Email) {

        usersDao.save(new Users(login, password, Email));
    }

    @Override
    public Integer saveUser(UsersBean user) {
        return null;
    }

    @Override
    public boolean checkUserByLogin(String login) {
        return false;
    }
}
