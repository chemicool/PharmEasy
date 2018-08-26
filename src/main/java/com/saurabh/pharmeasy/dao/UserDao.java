package com.saurabh.pharmeasy.dao;

import com.saurabh.pharmeasy.cache.UserCache;
import com.saurabh.pharmeasy.model.User;

public class UserDao {
	public static void setUser(User user){
		UserCache.putUser(user.getId(), user);
	}
}
