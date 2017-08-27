package com.lamia.dao;

import org.hibernate.Session;

import com.lamia.entity.Users;
import com.lamia.hibernate.HibernateUtil;

public class DaoUsers implements DaoInterface<Users>{

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
