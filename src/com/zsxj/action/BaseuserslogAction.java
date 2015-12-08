package com.zsxj.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.model.Baseuserslog; 
import com.zsxj.service.BaseuserslogService; 
 
public class BaseuserslogAction { 
	public int add(Baseuserslog baseuserslog) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BaseuserslogService(trans).add(baseuserslog); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Baseuserslog baseuserslog) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BaseuserslogService(trans).edit(baseuserslog); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int log_ID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BaseuserslogService(trans).delete(log_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Baseuserslog> findAll() { 
		List<Baseuserslog> lists = new ArrayList<Baseuserslog>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BaseuserslogService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Baseuserslog> findWhere(String where) { 
		List<Baseuserslog> lists = new ArrayList<Baseuserslog>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BaseuserslogService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Baseuserslog findById(int log_ID) { 
		Baseuserslog baseuserslog = new Baseuserslog(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			baseuserslog = new BaseuserslogService(trans).findById(log_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return baseuserslog; 
	} 
	 
	public List<Baseuserslog> findByRange(int start, int size) { 
		List<Baseuserslog> lists = new ArrayList<Baseuserslog>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BaseuserslogService(trans).findByRange(start, size); 
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
			id = new BaseuserslogService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
