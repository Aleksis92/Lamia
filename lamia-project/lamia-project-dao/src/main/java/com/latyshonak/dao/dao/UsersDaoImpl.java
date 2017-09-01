package com.latyshonak.dao.dao;


import com.latyshonak.dao.hibernate.HibernateUtil;
import com.latyshonak.entity.Users;
import org.hibernate.Session;

public class UsersDaoImpl implements UsersDaoInterface<Users> {

	@Override
	public void insert(Users ob) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(ob);
		session.getTransaction().commit();
		if(session.isOpen() && session != null){
        	session.close();
		}
	}

	@Override
	public void update(Users ob) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(ob);
		session.getTransaction().commit();
		if(session.isOpen() && session != null){
        	session.close();
		}
	}

	@Override
	public void delete(Users ob) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(ob);
		session.getTransaction().commit();
		if(session.isOpen() && session != null){
			session.close();
		}
	}


	@Override
	public Users get(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Users user = (Users) session.get(Users.class, id);
		return user;
	}


}
