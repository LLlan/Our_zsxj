package com.zsxj.service; 
 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.common.service.BaseService; 
import com.zsxj.dao.WrokplanexecDao; 
import com.zsxj.model.Wrokplanexec; 
 
public class WrokplanexecService extends BaseService { 
	public WrokplanexecService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public WrokplanexecService() { 
		super(); 
	} 
 
	public int add(Wrokplanexec wrokplanexec) { 
		WrokplanexecDao dao = new WrokplanexecDao(getConnection()); 
		return dao.add(wrokplanexec); 
	} 
 
	public int edit(Wrokplanexec wrokplanexec) { 
		WrokplanexecDao dao = new WrokplanexecDao(getConnection()); 
		return dao.edit(wrokplanexec); 
	} 
 
	public int delete(int wPE_ID) { 
		WrokplanexecDao dao = new WrokplanexecDao(getConnection()); 
		return dao.delete(wPE_ID); 
	} 
 
	public List<Wrokplanexec> findAll() { 
		WrokplanexecDao dao = new WrokplanexecDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Wrokplanexec> findWhere(String where) { 
		WrokplanexecDao dao = new WrokplanexecDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Wrokplanexec findById(int wPE_ID) { 
		WrokplanexecDao dao = new WrokplanexecDao(getConnection()); 
		return dao.findById(wPE_ID); 
	} 
 
	public List<Wrokplanexec> findByRange(int start, int size) { 
		WrokplanexecDao dao = new WrokplanexecDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		WrokplanexecDao dao = new WrokplanexecDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
