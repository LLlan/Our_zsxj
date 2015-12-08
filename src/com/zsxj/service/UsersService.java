package com.zsxj.service;

import com.zsxj.common.database.DatabaseTransaction;
import com.zsxj.common.service.BaseService;
import com.zsxj.dao.UsersDao;
import com.zsxj.model.Users;

public class UsersService extends BaseService {

	public UsersService(DatabaseTransaction trans) {
		super(trans);
	}

	public UsersService() {
		super();
	}

	public boolean UserValidator(Users user) {
		UsersDao dao = new UsersDao(getConnection());
		Long result = dao.UserValidator(user);
		return result > 0 ? true : false;
	}
}
