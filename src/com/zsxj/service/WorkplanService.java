package com.zsxj.service; 
 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.common.service.BaseService; 
import com.zsxj.dao.WorkplanDao; 
import com.zsxj.model.Workplan; 
 
public class WorkplanService extends BaseService { 
	public WorkplanService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public WorkplanService() { 
		super(); 
	} 
 
	public int add(Workplan workplan) { 
		WorkplanDao dao = new WorkplanDao(getConnection()); 
		return dao.add(workplan); 
	} 
 
	public int edit(Workplan workplan) { 
		WorkplanDao dao = new WorkplanDao(getConnection()); 
		return dao.edit(workplan); 
	} 
 
	public int delete(int wP_ID) { 
		WorkplanDao dao = new WorkplanDao(getConnection()); 
		return dao.delete(wP_ID); 
	} 
 
	public List<Workplan> findAll() { 
		WorkplanDao dao = new WorkplanDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Workplan> findWhere(String where) { 
		WorkplanDao dao = new WorkplanDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Workplan findById(int wP_ID) { 
		WorkplanDao dao = new WorkplanDao(getConnection()); 
		return dao.findById(wP_ID); 
	} 
 
	public List<Workplan> findByRange(int start, int size) { 
		WorkplanDao dao = new WorkplanDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		WorkplanDao dao = new WorkplanDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
