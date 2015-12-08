package com.zsxj.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.model.Basemodule; 
import com.zsxj.service.BasemoduleService; 
 
public class BasemoduleAction { 
	public int add(Basemodule basemodule) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BasemoduleService(trans).add(basemodule); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Basemodule basemodule) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BasemoduleService(trans).edit(basemodule); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int module_ID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BasemoduleService(trans).delete(module_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Basemodule> findAll() { 
		List<Basemodule> lists = new ArrayList<Basemodule>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BasemoduleService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Basemodule> findWhere(String where) { 
		List<Basemodule> lists = new ArrayList<Basemodule>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BasemoduleService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Basemodule findById(int module_ID) { 
		Basemodule basemodule = new Basemodule(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			basemodule = new BasemoduleService(trans).findById(module_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return basemodule; 
	} 
	 
	public List<Basemodule> findByRange(int start, int size) { 
		List<Basemodule> lists = new ArrayList<Basemodule>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BasemoduleService(trans).findByRange(start, size); 
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
			id = new BasemoduleService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
