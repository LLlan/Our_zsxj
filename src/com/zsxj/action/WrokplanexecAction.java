package com.zsxj.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.model.Wrokplanexec; 
import com.zsxj.service.WrokplanexecService; 
 
public class WrokplanexecAction { 
	public int add(Wrokplanexec wrokplanexec) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new WrokplanexecService(trans).add(wrokplanexec); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Wrokplanexec wrokplanexec) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new WrokplanexecService(trans).edit(wrokplanexec); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int wPE_ID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new WrokplanexecService(trans).delete(wPE_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Wrokplanexec> findAll() { 
		List<Wrokplanexec> lists = new ArrayList<Wrokplanexec>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new WrokplanexecService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Wrokplanexec> findWhere(String where) { 
		List<Wrokplanexec> lists = new ArrayList<Wrokplanexec>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new WrokplanexecService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Wrokplanexec findById(int wPE_ID) { 
		Wrokplanexec wrokplanexec = new Wrokplanexec(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			wrokplanexec = new WrokplanexecService(trans).findById(wPE_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return wrokplanexec; 
	} 
	 
	public List<Wrokplanexec> findByRange(int start, int size) { 
		List<Wrokplanexec> lists = new ArrayList<Wrokplanexec>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new WrokplanexecService(trans).findByRange(start, size); 
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
			id = new WrokplanexecService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
