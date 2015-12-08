package com.zsxj.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.model.Workplan; 
import com.zsxj.service.WorkplanService; 
 
public class WorkplanAction { 
	public int add(Workplan workplan) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new WorkplanService(trans).add(workplan); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Workplan workplan) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new WorkplanService(trans).edit(workplan); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int wP_ID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new WorkplanService(trans).delete(wP_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Workplan> findAll() { 
		List<Workplan> lists = new ArrayList<Workplan>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new WorkplanService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Workplan> findWhere(String where) { 
		List<Workplan> lists = new ArrayList<Workplan>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new WorkplanService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Workplan findById(int wP_ID) { 
		Workplan workplan = new Workplan(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			workplan = new WorkplanService(trans).findById(wP_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return workplan; 
	} 
	 
	public List<Workplan> findByRange(int start, int size) { 
		List<Workplan> lists = new ArrayList<Workplan>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new WorkplanService(trans).findByRange(start, size); 
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
			id = new WorkplanService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
