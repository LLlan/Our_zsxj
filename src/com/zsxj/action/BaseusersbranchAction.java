package com.zsxj.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.model.Baseusersbranch; 
import com.zsxj.service.BaseusersbranchService; 
 
public class BaseusersbranchAction { 
	public int add(Baseusersbranch baseusersbranch) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BaseusersbranchService(trans).add(baseusersbranch); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Baseusersbranch baseusersbranch) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BaseusersbranchService(trans).edit(baseusersbranch); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int branch_ID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BaseusersbranchService(trans).delete(branch_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Baseusersbranch> findAll() { 
		List<Baseusersbranch> lists = new ArrayList<Baseusersbranch>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BaseusersbranchService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Baseusersbranch> findWhere(String where) { 
		List<Baseusersbranch> lists = new ArrayList<Baseusersbranch>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BaseusersbranchService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Baseusersbranch findById(int branch_ID) { 
		Baseusersbranch baseusersbranch = new Baseusersbranch(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			baseusersbranch = new BaseusersbranchService(trans).findById(branch_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return baseusersbranch; 
	} 
	 
	public List<Baseusersbranch> findByRange(int start, int size) { 
		List<Baseusersbranch> lists = new ArrayList<Baseusersbranch>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BaseusersbranchService(trans).findByRange(start, size); 
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
			id = new BaseusersbranchService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
