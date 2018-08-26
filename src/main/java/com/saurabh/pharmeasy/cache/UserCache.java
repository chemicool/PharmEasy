package com.saurabh.pharmeasy.cache;

import java.util.HashMap;
import java.util.Map;

import com.saurabh.pharmeasy.model.User;

public class UserCache {
	private static Map<Integer, User> userMap;
	public static void loadCache(){
		userMap = new HashMap<Integer,User>();
	}
	public static User getUser(Integer userId){
		return userMap.get(userId);
	}
	public static void putUser(Integer userId, User user){
		if(userMap==null) loadCache();
		userMap.put(userId, user);
	}
}
