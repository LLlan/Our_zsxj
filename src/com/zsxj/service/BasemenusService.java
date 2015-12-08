package com.zsxj.service; 
 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.common.service.BaseService; 
import com.zsxj.dao.BasemenusDao; 
import com.zsxj.model.Basemenus; 
 
public class BasemenusService extends BaseService { 
	public BasemenusService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public BasemenusService() { 
		super(); 
	} 
 
	public int add(Basemenus basemenus) { 
		BasemenusDao dao = new BasemenusDao(getConnection()); 
		return dao.add(basemenus); 
	} 
 
	public int edit(Basemenus basemenus) { 
		BasemenusDao dao = new BasemenusDao(getConnection()); 
		return dao.edit(basemenus); 
	} 
 
	public int delete(int menus_ID) { 
		BasemenusDao dao = new BasemenusDao(getConnection()); 
		return dao.delete(menus_ID); 
	} 
 
	public List<Basemenus> findAll() { 
		BasemenusDao dao = new BasemenusDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Basemenus> findWhere(String where) { 
		BasemenusDao dao = new BasemenusDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Basemenus findById(int menus_ID) { 
		BasemenusDao dao = new BasemenusDao(getConnection()); 
		return dao.findById(menus_ID); 
	} 
 
	public List<Basemenus> findByRange(int start, int size) { 
		BasemenusDao dao = new BasemenusDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		BasemenusDao dao = new BasemenusDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
