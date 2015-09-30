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
import com.cmad.database.Posts;
import com.cmad.database.Comments;
import com.cmad.database.HibernateUtil;

@Path("/posts")
public class PostResource {

@GET
@Produces({ MediaType.APPLICATION_JSON })
public List<Posts> getUserPosts(@QueryParam("OwnerID") Integer OwnerID,
		@QueryParam("postID") Integer postID,
		@QueryParam("UA") Integer UA){
Session ses = HibernateUtil.currentSession();
//ses.flush();
List<Posts> posts = null;
try{
	if(OwnerID != null) 
	{
		posts =  ses.createQuery("select p from Posts p where p.OwnerID="+OwnerID+" order by p.PostDate desc").list();
	}
	else if (postID !=null)
	{
		posts =  ses.createQuery("select p from Posts p where p.PostID="+postID).list();
	}
	else if (UA !=null)
	{
		posts =  ses.createQuery("select p from Posts p where p.PostID not in (select c.postID from Comments c)").list();
	}		
	else
	{
		posts =  ses.createQuery("select p from Posts p order by PostDate desc").list();
	}
//	ses.refresh(posts);
}catch (HibernateException e) {
    e.printStackTrace(); 
 }finally {
	 HibernateUtil.closeSession(); 
 }
return posts;
}

@POST
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public Posts createPost (Posts p) {
Session ses = HibernateUtil.currentSession();
ses.flush();
Transaction tx = null;
try{
	tx =ses.beginTransaction();
	java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
	p.setPostDate(date);
	ses.save(p);
//	ses.refresh(p);
	tx.commit();
}catch (HibernateException e) {
    if (tx!=null) tx.rollback();
    e.printStackTrace(); 
 }finally {
	 HibernateUtil.closeSession(); 
 }
return p;
}

@PUT
@Consumes({ MediaType.APPLICATION_JSON })
public void updateVotes (Posts p) {
Session ses = HibernateUtil.currentSession();
Transaction tx = null;
try{
	tx =ses.beginTransaction();
	Posts p2 = new Posts();
	p2 = (Posts)ses.get(Posts.class, p.getPostID());
	p2.setPostID(p.getPostID());
	p2.setPostVote(p.getPostVote());
	p2.setOwnerID(p.getOwnerID());
//	ses.createQuery("UPDATE Posts SET PostVote="+p.getPostVote() +" WHERE PostID="+p.getPostID()+" AND OwnerID="+p.getOwnerID());
	ses.update(p2);
//	ses.refresh(p2);
	tx.commit();	
}catch (HibernateException e) {
    if (tx!=null) tx.rollback();
    e.printStackTrace();
 }finally {
	 HibernateUtil.closeSession(); 
 }
}

}