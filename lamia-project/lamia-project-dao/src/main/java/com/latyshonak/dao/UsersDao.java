package com.latyshonak.dao;

public interface UsersDao<T> {

	void insert(T ob);
	void update(T ob);
	void delete(T ob);
	T get(int id);
	
}