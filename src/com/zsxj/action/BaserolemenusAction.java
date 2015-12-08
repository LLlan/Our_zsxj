package com.zsxj.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.model.Baserolemenus; 
import com.zsxj.service.BaserolemenusService; 
 
public class BaserolemenusAction { 
	public int add(Baserolemenus baserolemenus) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BaserolemenusService(trans).add(baserolemenus); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Baserolemenus baserolemenus) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BaserolemenusService(trans).edit(baserolemenus); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int rM_ID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BaserolemenusService(trans).delete(rM_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Baserolemenus> findAll() { 
		List<Baserolemenus> lists = new ArrayList<Baserolemenus>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BaserolemenusService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Baserolemenus> findWhere(String where) { 
		List<Baserolemenus> lists = new ArrayList<Baserolemenus>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BaserolemenusService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Baserolemenus findById(int rM_ID) { 
		Baserolemenus baserolemenus = new Baserolemenus(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			baserolemenus = new BaserolemenusService(trans).findById(rM_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return baserolemenus; 
	} 
	 
	public List<Baserolemenus> findByRange(int start, int size) { 
		List<Baserolemenus> lists = new ArrayList<Baserolemenus>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BaserolemenusService(trans).findByRange(start, size); 
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
			id = new BaserolemenusService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
