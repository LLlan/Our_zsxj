package com.zsxj.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.model.Hindercheck; 
import com.zsxj.service.HindercheckService; 
 
public class HindercheckAction { 
	public int add(Hindercheck hindercheck) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new HindercheckService(trans).add(hindercheck); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Hindercheck hindercheck) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new HindercheckService(trans).edit(hindercheck); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int hC_ID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new HindercheckService(trans).delete(hC_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Hindercheck> findAll() { 
		List<Hindercheck> lists = new ArrayList<Hindercheck>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new HindercheckService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Hindercheck> findWhere(String where) { 
		List<Hindercheck> lists = new ArrayList<Hindercheck>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new HindercheckService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Hindercheck findById(int hC_ID) { 
		Hindercheck hindercheck = new Hindercheck(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			hindercheck = new HindercheckService(trans).findById(hC_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return hindercheck; 
	} 
	 
	public List<Hindercheck> findByRange(int start, int size) { 
		List<Hindercheck> lists = new ArrayList<Hindercheck>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new HindercheckService(trans).findByRange(start, size); 
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
			id = new HindercheckService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
