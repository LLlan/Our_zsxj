package com.zsxj.convert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.zsxj.common.database.convert.ResultConverter;
import com.zsxj.model.Users;

public class UsersConvert implements ResultConverter<Users>{

	@Override
	public Users convert(ResultSet rs) throws SQLException {
		Users users = new Users(rs.getInt(1));
		users.users_UserName = rs.getString(2);
		users.users_Password= rs.getString(3);
		users.users_Mobile= rs.getString(4);
		users.users_Phone= rs.getString(5);
		users.users_Email= rs.getString(6);
		users.users_TrueName= rs.getString(7);
		users.users_IsLock= rs.getInt(8);
		users.users_LastLoginTime= new Date(rs.getDate(9).getTime());
		users.users_LastLoginIP= rs.getString(10);
		users.branch_ID= rs.getInt(11);
		users.role_ID= rs.getInt(12);
		return  users;
	}

}
