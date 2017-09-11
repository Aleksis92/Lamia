package com.latyshonak.dao;

import com.latyshonak.entity.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsersDao extends PagingAndSortingRepository<Users, Integer>{

    Users findByLogin (String login);

}