package com.cmad.database;

import java.util.List; 
import java.util.Iterator; 

import com.cmad.database.User;
import com.cmad.database.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction;

public class UserDBImpl implements UserDB{

	@Override
	public User getUserByEmail(String email) {
		Session ses = HibernateUtil.currentSession();
	     Transaction tx = null;
		User user = new User();
		try {
			tx = ses.beginTransaction();
			String hql = "SELECT U FROM User U WHERE U.email = :email";
			List <User> users = ses.createQuery(hql)
								.setString("email", email)
								.list();
			
			Iterator <User> itr = users.iterator();
			while (itr.hasNext())
			{
				User U = itr.next();
				System.out.println(U.getEmail());	
				user.setEmail(U.getEmail());	
			}
			tx.commit();	
		} catch (HibernateException e) {
			 if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
		} finally
		{
			HibernateUtil.closeSession();
		}
		return user;
	}
	
	
	@Override
	public User ValidatePassword(String email, String password) {
		Session ses = HibernateUtil.currentSession();
	     Transaction tx = null;
		User user = new User();
		try {
			tx = ses.beginTransaction();
			String hql = "SELECT U FROM User U WHERE U.email = :email AND U.password = :password";
			List <User> users = ses.createQuery(hql)
								.setString("email", email)
								.setString("password",password)
								.list();
			
			Iterator <User> itr = users.iterator();
			while (itr.hasNext())
			{
				User U = itr.next();
				user.setEmail(U.getEmail());
				user.setId(U.getId());
				user.setFullname(U.getFullname());
				user.setEmail(U.getEmail());
				user.setGender(U.getGender());
				user.setBirthdate(U.getBirthdate());				
			}
		tx.commit();	
		} catch (HibernateException e) {
			 if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
		} finally
		{
			HibernateUtil.closeSession();
		}
		return user;
	}

	@Override
	public int createOrUpdateUser(User u) {
		int result = 0;
	     Session session = HibernateUtil.currentSession();
	     Transaction tx = null;	
	     User user = new User();
		try {
			tx = session.beginTransaction();
			user.setFullname(u.getFullname());
			user.setEmail(u.getEmail());
			user.setPassword(u.getPassword());
			user.setGender(u.getGender());
			user.setBirthdate(u.getBirthdate());
			session.save(user);
			tx.commit();
			result = 1;
		} catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	    	  HibernateUtil.closeSession(); 
	      }
		return result;
	}
}
