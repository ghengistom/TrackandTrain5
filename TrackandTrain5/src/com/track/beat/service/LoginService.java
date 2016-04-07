package com.track.beat.service;

public class LoginService 
{
	public boolean authenticate(String userId, String password)
	{
		if (password == null || password.trim() == "")
		{
			return false;
		}
		return true;
	}
}
