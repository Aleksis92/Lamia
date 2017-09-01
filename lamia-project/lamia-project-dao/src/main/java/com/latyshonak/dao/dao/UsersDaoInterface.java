package com.latyshonak.dao.dao;

public interface UsersDaoInterface<T> {

	void insert(T ob);
	void update(T ob);
	void delete(T ob);
	T get(int id);
	
}