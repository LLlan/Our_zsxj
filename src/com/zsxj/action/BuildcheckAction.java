package com.zsxj.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.model.Buildcheck; 
import com.zsxj.service.BuildcheckService; 
 
public class BuildcheckAction { 
	public int add(Buildcheck buildcheck) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BuildcheckService(trans).add(buildcheck); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Buildcheck buildcheck) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BuildcheckService(trans).edit(buildcheck); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int bC_ID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new BuildcheckService(trans).delete(bC_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Buildcheck> findAll() { 
		List<Buildcheck> lists = new ArrayList<Buildcheck>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BuildcheckService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Buildcheck> findWhere(String where) { 
		List<Buildcheck> lists = new ArrayList<Buildcheck>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BuildcheckService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Buildcheck findById(int bC_ID) { 
		Buildcheck buildcheck = new Buildcheck(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			buildcheck = new BuildcheckService(trans).findById(bC_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return buildcheck; 
	} 
	 
	public List<Buildcheck> findByRange(int start, int size) { 
		List<Buildcheck> lists = new ArrayList<Buildcheck>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new BuildcheckService(trans).findByRange(start, size); 
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
			id = new BuildcheckService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
