package com.zsxj.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.model.Designcheck; 
import com.zsxj.service.DesigncheckService; 
 
public class DesigncheckAction { 
	public int add(Designcheck designcheck) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new DesigncheckService(trans).add(designcheck); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Designcheck designcheck) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new DesigncheckService(trans).edit(designcheck); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int dC_id) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new DesigncheckService(trans).delete(dC_id); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Designcheck> findAll() { 
		List<Designcheck> lists = new ArrayList<Designcheck>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new DesigncheckService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Designcheck> findWhere(String where) { 
		List<Designcheck> lists = new ArrayList<Designcheck>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new DesigncheckService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Designcheck findById(int dC_id) { 
		Designcheck designcheck = new Designcheck(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			designcheck = new DesigncheckService(trans).findById(dC_id); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return designcheck; 
	} 
	 
	public List<Designcheck> findByRange(int start, int size) { 
		List<Designcheck> lists = new ArrayList<Designcheck>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new DesigncheckService(trans).findByRange(start, size); 
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
			id = new DesigncheckService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
