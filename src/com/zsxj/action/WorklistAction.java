package com.zsxj.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.model.Worklist; 
import com.zsxj.service.WorklistService; 
 
public class WorklistAction { 
	public int add(Worklist worklist) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new WorklistService(trans).add(worklist); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Worklist worklist) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new WorklistService(trans).edit(worklist); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int wL_ID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new WorklistService(trans).delete(wL_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Worklist> findAll() { 
		List<Worklist> lists = new ArrayList<Worklist>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new WorklistService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Worklist> findWhere(String where) { 
		List<Worklist> lists = new ArrayList<Worklist>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new WorklistService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Worklist findById(int wL_ID) { 
		Worklist worklist = new Worklist(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			worklist = new WorklistService(trans).findById(wL_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return worklist; 
	} 
	 
	public List<Worklist> findByRange(int start, int size) { 
		List<Worklist> lists = new ArrayList<Worklist>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new WorklistService(trans).findByRange(start, size); 
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
			id = new WorklistService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
