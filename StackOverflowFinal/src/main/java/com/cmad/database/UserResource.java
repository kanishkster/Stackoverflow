package com.cmad.database;

import java.util.List;

import java.sql.Date;
import java.sql.Timestamp;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cmad.database.User;
import com.cmad.database.HibernateUtil;

@Path("/users")

public class UserResource {
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<User> getUser(@QueryParam("UserID") Integer UserID) {
	Session ses = HibernateUtil.currentSession();
	ses.flush();
	List<User> user = null;
	if(UserID != null)
	{
		user =  ses.createQuery("select u from User u where u.id="+UserID).list();
	}
	else
	{
		user =  ses.createQuery("select u from User u").list();
	}
//	ses.refresh(user);
	HibernateUtil.closeSession();
	return user;
	}
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateVotes (User u) {
	Session ses = HibernateUtil.currentSession();
	Transaction tx = null;
	try{
		tx =ses.beginTransaction();
		User u2 = new User();
		u2 = (User)ses.get(User.class, u.getId());
		u2.setId(u.getId());
		if(u.getFullname()!=null)
		{	
			u2.setFullname(u.getFullname());
		}
		if(u.getPassword()!=null)
		{	
			u2.setPassword(u.getPassword());
		}
		ses.update(u2);
//		ses.refresh(u2);
		tx.commit();	
	}catch (HibernateException e) {
	    if (tx!=null) tx.rollback();
	    e.printStackTrace();
	 }finally {
		 HibernateUtil.closeSession(); 
	 }
	}

}