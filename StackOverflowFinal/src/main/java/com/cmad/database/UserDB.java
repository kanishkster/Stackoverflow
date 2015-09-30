package com.cmad.database;

import com.cmad.database.User;

public interface UserDB {
	
	public User getUserByEmail(String email);
	public User ValidatePassword(String email,String password);
	public int createOrUpdateUser(User u);
	
}
