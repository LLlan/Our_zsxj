package com.zsxj.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.model.Baseusers; 
import com.zsxj.service.BaseusersService; 
 
public class BaseusersAction { 
	public int add(Baseusers baseusers) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BaseusersService(trans).add(baseusers); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Baseusers baseusers) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BaseusersService(trans).edit(baseusers); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int users_ID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BaseusersService(trans).delete(users_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Baseusers> findAll() { 
		List<Baseusers> lists = new ArrayList<Baseusers>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BaseusersService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Baseusers> findWhere(String where) { 
		List<Baseusers> lists = new ArrayList<Baseusers>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BaseusersService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Baseusers findById(int users_ID) { 
		Baseusers baseusers = new Baseusers(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			baseusers = new BaseusersService(trans).findById(users_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return baseusers; 
	} 
	 
	public List<Baseusers> findByRange(int start, int size) { 
		List<Baseusers> lists = new ArrayList<Baseusers>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BaseusersService(trans).findByRange(start, size); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Integer getCount() { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BaseusersService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
