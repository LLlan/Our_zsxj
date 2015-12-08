package com.zsxj.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.model.Projectplan; 
import com.zsxj.service.ProjectplanService; 
 
public class ProjectplanAction { 
	public int add(Projectplan projectplan) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new ProjectplanService(trans).add(projectplan); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Projectplan projectplan) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new ProjectplanService(trans).edit(projectplan); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int pP_ID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new ProjectplanService(trans).delete(pP_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Projectplan> findAll() { 
		List<Projectplan> lists = new ArrayList<Projectplan>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new ProjectplanService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Projectplan> findWhere(String where) { 
		List<Projectplan> lists = new ArrayList<Projectplan>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new ProjectplanService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Projectplan findById(int pP_ID) { 
		Projectplan projectplan = new Projectplan(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			projectplan = new ProjectplanService(trans).findById(pP_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return projectplan; 
	} 
	 
	public List<Projectplan> findByRange(int start, int size) { 
		List<Projectplan> lists = new ArrayList<Projectplan>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new ProjectplanService(trans).findByRange(start, size); 
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
			id = new ProjectplanService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
