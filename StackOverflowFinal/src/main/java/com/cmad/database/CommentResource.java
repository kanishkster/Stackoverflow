package com.cmad.database;

import java.util.List;
import java.sql.Date;
import java.sql.Timestamp;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

@Path("/comments")

public class CommentResource {
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Comments> getUserComments(@QueryParam("postID") Integer postID,
			@QueryParam("commenterID") Integer commenterID,
			@QueryParam("commentID") Integer commentID) {
	Session ses = HibernateUtil.currentSession();
//	ses.flush();
	List<Comments> comments = null;
	if(postID != null)
	{
		comments =  ses.createQuery("select c from Comments c where c.postID="+postID+" order by c.commentDate").list();
	}
	else if(commenterID !=null)
	{
		comments =  ses.createQuery("select c from Comments c where c.commenterID="+commenterID).list();
	}
	else if(commentID != null)
	{
		comments =  ses.createQuery("select c from Comments c where c.commentID="+commentID).list();
	}
//	ses.refresh(comments);
	HibernateUtil.closeSession();
	return comments;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Comments createComment (Comments c) {
	Session ses = HibernateUtil.currentSession();
	ses.flush();
	Transaction tx = null;
	try{
		tx =ses.beginTransaction();
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		c.setcommentDate(date);
		ses.save(c);
//		ses.refresh(c);
		tx.commit();	
	}catch (HibernateException e) {
	    if (tx!=null) tx.rollback();
	    e.printStackTrace(); 
	 }finally {
		 HibernateUtil.closeSession(); 
	 }
	return c;
	}
	

@DELETE
@Path("/{id}")
public void deleteUser(@PathParam("id") Integer id) {
	Session ses = HibernateUtil.currentSession();
	ses.delete(id);
}

}