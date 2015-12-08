package com.zsxj.service; 
 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.common.service.BaseService; 
import com.zsxj.dao.WorklistDao; 
import com.zsxj.model.Worklist; 
 
public class WorklistService extends BaseService { 
	public WorklistService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public WorklistService() { 
		super(); 
	} 
 
	public int add(Worklist worklist) { 
		WorklistDao dao = new WorklistDao(getConnection()); 
		return dao.add(worklist); 
	} 
 
	public int edit(Worklist worklist) { 
		WorklistDao dao = new WorklistDao(getConnection()); 
		return dao.edit(worklist); 
	} 
 
	public int delete(int wL_ID) { 
		WorklistDao dao = new WorklistDao(getConnection()); 
		return dao.delete(wL_ID); 
	} 
 
	public List<Worklist> findAll() { 
		WorklistDao dao = new WorklistDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Worklist> findWhere(String where) { 
		WorklistDao dao = new WorklistDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Worklist findById(int wL_ID) { 
		WorklistDao dao = new WorklistDao(getConnection()); 
		return dao.findById(wL_ID); 
	} 
 
	public List<Worklist> findByRange(int start, int size) { 
		WorklistDao dao = new WorklistDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		WorklistDao dao = new WorklistDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
