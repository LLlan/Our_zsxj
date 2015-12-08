package com.zsxj.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.model.Basemenus; 
import com.zsxj.service.BasemenusService; 
 
public class BasemenusAction { 
	public int add(Basemenus basemenus) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BasemenusService(trans).add(basemenus); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Basemenus basemenus) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BasemenusService(trans).edit(basemenus); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int menus_ID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BasemenusService(trans).delete(menus_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Basemenus> findAll() { 
		List<Basemenus> lists = new ArrayList<Basemenus>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BasemenusService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Basemenus> findWhere(String where) { 
		List<Basemenus> lists = new ArrayList<Basemenus>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BasemenusService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Basemenus findById(int menus_ID) { 
		Basemenus basemenus = new Basemenus(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			basemenus = new BasemenusService(trans).findById(menus_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return basemenus; 
	} 
	 
	public List<Basemenus> findByRange(int start, int size) { 
		List<Basemenus> lists = new ArrayList<Basemenus>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BasemenusService(trans).findByRange(start, size); 
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
			id = new BasemenusService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
