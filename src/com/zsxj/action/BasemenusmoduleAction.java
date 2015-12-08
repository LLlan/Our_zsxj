package com.zsxj.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.model.Basemenusmodule; 
import com.zsxj.service.BasemenusmoduleService; 
 
public class BasemenusmoduleAction { 
	public int add(Basemenusmodule basemenusmodule) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BasemenusmoduleService(trans).add(basemenusmodule); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Basemenusmodule basemenusmodule) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BasemenusmoduleService(trans).edit(basemenusmodule); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int memusModule_ID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BasemenusmoduleService(trans).delete(memusModule_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Basemenusmodule> findAll() { 
		List<Basemenusmodule> lists = new ArrayList<Basemenusmodule>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BasemenusmoduleService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Basemenusmodule> findWhere(String where) { 
		List<Basemenusmodule> lists = new ArrayList<Basemenusmodule>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BasemenusmoduleService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Basemenusmodule findById(int memusModule_ID) { 
		Basemenusmodule basemenusmodule = new Basemenusmodule(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			basemenusmodule = new BasemenusmoduleService(trans).findById(memusModule_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return basemenusmodule; 
	} 
	 
	public List<Basemenusmodule> findByRange(int start, int size) { 
		List<Basemenusmodule> lists = new ArrayList<Basemenusmodule>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BasemenusmoduleService(trans).findByRange(start, size); 
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
			id = new BasemenusmoduleService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
