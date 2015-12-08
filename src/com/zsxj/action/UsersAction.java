package com.zsxj.action;

import com.zsxj.common.database.DatabaseTransaction;
import com.zsxj.model.Users;
import com.zsxj.service.UsersService;

public class UsersAction 
{
	public boolean UserValidator(Users user) 
	{
		boolean flag = false;
		DatabaseTransaction trans = new DatabaseTransaction(true);
		try 
		{
			if(new UsersService(trans).UserValidator(user))
			{
				flag = true;
			}
			trans.commit();
		}
		catch (Exception e) {
			trans.rollback();
		} 
		finally
		{
			trans.close();
		}
		return flag;
	}
}
