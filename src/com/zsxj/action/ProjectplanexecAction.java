package com.zsxj.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.model.Projectplanexec; 
import com.zsxj.service.ProjectplanexecService; 
 
public class ProjectplanexecAction { 
	public int add(Projectplanexec projectplanexec) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new ProjectplanexecService(trans).add(projectplanexec); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Projectplanexec projectplanexec) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new ProjectplanexecService(trans).edit(projectplanexec); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int pPE_ID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new ProjectplanexecService(trans).delete(pPE_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Projectplanexec> findAll() { 
		List<Projectplanexec> lists = new ArrayList<Projectplanexec>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new ProjectplanexecService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Projectplanexec> findWhere(String where) { 
		List<Projectplanexec> lists = new ArrayList<Projectplanexec>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new ProjectplanexecService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Projectplanexec findById(int pPE_ID) { 
		Projectplanexec projectplanexec = new Projectplanexec(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			projectplanexec = new ProjectplanexecService(trans).findById(pPE_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return projectplanexec; 
	} 
	 
	public List<Projectplanexec> findByRange(int start, int size) { 
		List<Projectplanexec> lists = new ArrayList<Projectplanexec>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new ProjectplanexecService(trans).findByRange(start, size); 
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
			id = new ProjectplanexecService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
