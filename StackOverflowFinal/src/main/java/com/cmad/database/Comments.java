package com.cmad.database;
import java.sql.Timestamp;

public class Comments {
	
	private int postID;
	private int commentID;
	private String comment;
	private int commenterID;
	private Timestamp commentDate;
	private int commentVote;
			
	public Comments(){
		
	}
	
	public Comments(int postID, int commentID, String comment, int commenterID, Timestamp commentDate,int commentVote) {
		this.postID = postID;
		this.commentID = commentID;
		this.comment = comment;
		this.commenterID = commenterID;
		this.commentDate = commentDate;
		this.commentVote = commentVote;
	}
	
	public int getPostID() {
		return postID;
	}	
	
	public void setPostID(int PostID) {
		this.postID = PostID;
	}
	public int getcommentID() {
		return commentID;
	}
	public void setcommentID(int commentID) {
		this.commentID = commentID;
	}
	public String getcomment() {
		return comment;
	}
	public void setcomment(String comment) {
		this.comment = comment;
	}

	public int getcommenterID() {
		return commenterID;
	}
	public void setcommenterID(int commenterID) {
		this.commenterID = commenterID;
	}
	
	public Timestamp getcommentDate() {
		return commentDate;
	}
	public void setcommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}	
	public int getcommentVote() {
		return commentVote;
	}
	public void setcommentVote(int commentVote) {
		this.commentVote = commentVote;
	}
	
	@Override
	public String toString() {
		return "commentID [id=" + commentID + ", postID=" + postID + ", comment=" + comment + ", commenterID=" + commenterID
				+ ", commentDate=" + commentDate + ", commentVote=" + commentVote + "]";
	}	
	
}
