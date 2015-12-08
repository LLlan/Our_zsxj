package com.zsxj.service; 
 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.common.service.BaseService; 
import com.zsxj.dao.BasemenusmoduleDao; 
import com.zsxj.model.Basemenusmodule; 
 
public class BasemenusmoduleService extends BaseService { 
	public BasemenusmoduleService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public BasemenusmoduleService() { 
		super(); 
	} 
 
	public int add(Basemenusmodule basemenusmodule) { 
		BasemenusmoduleDao dao = new BasemenusmoduleDao(getConnection()); 
		return dao.add(basemenusmodule); 
	} 
 
	public int edit(Basemenusmodule basemenusmodule) { 
		BasemenusmoduleDao dao = new BasemenusmoduleDao(getConnection()); 
		return dao.edit(basemenusmodule); 
	} 
 
	public int delete(int memusModule_ID) { 
		BasemenusmoduleDao dao = new BasemenusmoduleDao(getConnection()); 
		return dao.delete(memusModule_ID); 
	} 
 
	public List<Basemenusmodule> findAll() { 
		BasemenusmoduleDao dao = new BasemenusmoduleDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Basemenusmodule> findWhere(String where) { 
		BasemenusmoduleDao dao = new BasemenusmoduleDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Basemenusmodule findById(int memusModule_ID) { 
		BasemenusmoduleDao dao = new BasemenusmoduleDao(getConnection()); 
		return dao.findById(memusModule_ID); 
	} 
 
	public List<Basemenusmodule> findByRange(int start, int size) { 
		BasemenusmoduleDao dao = new BasemenusmoduleDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		BasemenusmoduleDao dao = new BasemenusmoduleDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
