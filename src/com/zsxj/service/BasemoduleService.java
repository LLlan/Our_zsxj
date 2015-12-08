package com.zsxj.service; 
 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.common.service.BaseService; 
import com.zsxj.dao.BasemoduleDao; 
import com.zsxj.model.Basemodule; 
 
public class BasemoduleService extends BaseService { 
	public BasemoduleService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public BasemoduleService() { 
		super(); 
	} 
 
	public int add(Basemodule basemodule) { 
		BasemoduleDao dao = new BasemoduleDao(getConnection()); 
		return dao.add(basemodule); 
	} 
 
	public int edit(Basemodule basemodule) { 
		BasemoduleDao dao = new BasemoduleDao(getConnection()); 
		return dao.edit(basemodule); 
	} 
 
	public int delete(int module_ID) { 
		BasemoduleDao dao = new BasemoduleDao(getConnection()); 
		return dao.delete(module_ID); 
	} 
 
	public List<Basemodule> findAll() { 
		BasemoduleDao dao = new BasemoduleDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Basemodule> findWhere(String where) { 
		BasemoduleDao dao = new BasemoduleDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Basemodule findById(int module_ID) { 
		BasemoduleDao dao = new BasemoduleDao(getConnection()); 
		return dao.findById(module_ID); 
	} 
 
	public List<Basemodule> findByRange(int start, int size) { 
		BasemoduleDao dao = new BasemoduleDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		BasemoduleDao dao = new BasemoduleDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
