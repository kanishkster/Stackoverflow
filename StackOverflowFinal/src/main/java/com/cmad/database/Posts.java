package com.cmad.database;
import java.sql.Timestamp;

public class Posts {
	
	private int PostID;
	private String PostTitle;
	private Timestamp PostDate;
	private int OwnerID;
	private int PostVote;
		
	public Posts(){
		
	}
	
	public Posts(int PostID, String PostTitle, Timestamp PostDate,int OwnerID, int PostVote) {
		this.PostID = PostID;
		this.PostTitle = PostTitle;
		this.PostDate = PostDate;
		this.OwnerID = OwnerID;
		this.PostVote = PostVote;
	}
	
	public int getPostID() {
		return PostID;
	}
	public void setPostID(int PostID) {
		this.PostID = PostID;
	}
	public String getPostTitle() {
		return PostTitle;
	}
	public void setPostTitle(String PostTitle) {
		this.PostTitle = PostTitle;
	}
	public Timestamp getPostDate() {
		return PostDate;
	}
	public void setPostDate(Timestamp PostDate) {
		this.PostDate = PostDate;
	}
	public int getOwnerID() {
		return OwnerID;
	}
	public void setOwnerID(int OwnerID) {
		this.OwnerID = OwnerID;
	}
	public int getPostVote() {
		return PostVote;
	}
	public void setPostVote(int PostVote) {
		this.PostVote = PostVote;
	}
	
	@Override
	public String toString() {
		return "PostID [id=" + PostID + ", PostTitle=" + PostTitle + ", PostDate=" + PostDate
				+ ", OwnerID=" + OwnerID + ", PostVote=" + PostVote + "]";
	}	
	
}
