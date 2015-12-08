package com.zsxj.service; 
 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.common.service.BaseService; 
import com.zsxj.dao.BaseusersbranchDao; 
import com.zsxj.model.Baseusersbranch; 
 
public class BaseusersbranchService extends BaseService { 
	public BaseusersbranchService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public BaseusersbranchService() { 
		super(); 
	} 
 
	public int add(Baseusersbranch baseusersbranch) { 
		BaseusersbranchDao dao = new BaseusersbranchDao(getConnection()); 
		return dao.add(baseusersbranch); 
	} 
 
	public int edit(Baseusersbranch baseusersbranch) { 
		BaseusersbranchDao dao = new BaseusersbranchDao(getConnection()); 
		return dao.edit(baseusersbranch); 
	} 
 
	public int delete(int branch_ID) { 
		BaseusersbranchDao dao = new BaseusersbranchDao(getConnection()); 
		return dao.delete(branch_ID); 
	} 
 
	public List<Baseusersbranch> findAll() { 
		BaseusersbranchDao dao = new BaseusersbranchDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Baseusersbranch> findWhere(String where) { 
		BaseusersbranchDao dao = new BaseusersbranchDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Baseusersbranch findById(int branch_ID) { 
		BaseusersbranchDao dao = new BaseusersbranchDao(getConnection()); 
		return dao.findById(branch_ID); 
	} 
 
	public List<Baseusersbranch> findByRange(int start, int size) { 
		BaseusersbranchDao dao = new BaseusersbranchDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		BaseusersbranchDao dao = new BaseusersbranchDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
