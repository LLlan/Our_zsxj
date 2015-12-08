package com.zsxj.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.model.Macroomcheck; 
import com.zsxj.service.MacroomcheckService; 
 
public class MacroomcheckAction { 
	public int add(Macroomcheck macroomcheck) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new MacroomcheckService(trans).add(macroomcheck); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Macroomcheck macroomcheck) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new MacroomcheckService(trans).edit(macroomcheck); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int mRC_ID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new MacroomcheckService(trans).delete(mRC_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Macroomcheck> findAll() { 
		List<Macroomcheck> lists = new ArrayList<Macroomcheck>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new MacroomcheckService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Macroomcheck> findWhere(String where) { 
		List<Macroomcheck> lists = new ArrayList<Macroomcheck>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new MacroomcheckService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Macroomcheck findById(int mRC_ID) { 
		Macroomcheck macroomcheck = new Macroomcheck(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			macroomcheck = new MacroomcheckService(trans).findById(mRC_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return macroomcheck; 
	} 
	 
	public List<Macroomcheck> findByRange(int start, int size) { 
		List<Macroomcheck> lists = new ArrayList<Macroomcheck>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new MacroomcheckService(trans).findByRange(start, size); 
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
			id = new MacroomcheckService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
