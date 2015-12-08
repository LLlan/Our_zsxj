package com.zsxj.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.model.Opencheck; 
import com.zsxj.service.OpencheckService; 
 
public class OpencheckAction { 
	public int add(Opencheck opencheck) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new OpencheckService(trans).add(opencheck); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Opencheck opencheck) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new OpencheckService(trans).edit(opencheck); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int oC_ID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new OpencheckService(trans).delete(oC_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Opencheck> findAll() { 
		List<Opencheck> lists = new ArrayList<Opencheck>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new OpencheckService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Opencheck> findWhere(String where) { 
		List<Opencheck> lists = new ArrayList<Opencheck>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new OpencheckService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Opencheck findById(int oC_ID) { 
		Opencheck opencheck = new Opencheck(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			opencheck = new OpencheckService(trans).findById(oC_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return opencheck; 
	} 
	 
	public List<Opencheck> findByRange(int start, int size) { 
		List<Opencheck> lists = new ArrayList<Opencheck>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new OpencheckService(trans).findByRange(start, size); 
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
			id = new OpencheckService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
