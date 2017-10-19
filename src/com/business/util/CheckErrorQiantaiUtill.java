package com.business.util;

import java.util.Map;

import com.business.entitys.user.User;

public class CheckErrorQiantaiUtill {
	public static Boolean checkSession(Map<String, Object> session) {
		try {
			User buyuser = (User) session.get("buyuser");
			if (buyuser == null) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
