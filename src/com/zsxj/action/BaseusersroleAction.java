package com.zsxj.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.model.Baseusersrole; 
import com.zsxj.service.BaseusersroleService; 
 
public class BaseusersroleAction { 
	public int add(Baseusersrole baseusersrole) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BaseusersroleService(trans).add(baseusersrole); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Baseusersrole baseusersrole) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BaseusersroleService(trans).edit(baseusersrole); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int role_ID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BaseusersroleService(trans).delete(role_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Baseusersrole> findAll() { 
		List<Baseusersrole> lists = new ArrayList<Baseusersrole>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BaseusersroleService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Baseusersrole> findWhere(String where) { 
		List<Baseusersrole> lists = new ArrayList<Baseusersrole>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BaseusersroleService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Baseusersrole findById(int role_ID) { 
		Baseusersrole baseusersrole = new Baseusersrole(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			baseusersrole = new BaseusersroleService(trans).findById(role_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return baseusersrole; 
	} 
	 
	public List<Baseusersrole> findByRange(int start, int size) { 
		List<Baseusersrole> lists = new ArrayList<Baseusersrole>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BaseusersroleService(trans).findByRange(start, size); 
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
			id = new BaseusersroleService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
