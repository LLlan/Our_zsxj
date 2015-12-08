package com.zsxj.dao;

import java.sql.Connection;

import com.zsxj.common.database.access.DataAccess;
import com.zsxj.common.database.convert.LongConverter;
import com.zsxj.model.Users;

public class UsersDao extends DataAccess{
	public UsersDao(Connection conn) {
		super(conn);
	}
	
	public Long UserValidator(Users user) {
		String sql ="select count(*) as result from base_users where Users_UserName = ? and Users_Password = ?";
		Long id = super.queryForObject(sql, new LongConverter(), user.users_UserName, user.users_Password);
		return id;
	}
	
	

}
