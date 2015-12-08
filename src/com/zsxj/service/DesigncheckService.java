package com.zsxj.service; 
 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.common.service.BaseService; 
import com.zsxj.dao.DesigncheckDao; 
import com.zsxj.model.Designcheck; 
 
public class DesigncheckService extends BaseService { 
	public DesigncheckService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public DesigncheckService() { 
		super(); 
	} 
 
	public int add(Designcheck designcheck) { 
		DesigncheckDao dao = new DesigncheckDao(getConnection()); 
		return dao.add(designcheck); 
	} 
 
	public int edit(Designcheck designcheck) { 
		DesigncheckDao dao = new DesigncheckDao(getConnection()); 
		return dao.edit(designcheck); 
	} 
 
	public int delete(int dC_id) { 
		DesigncheckDao dao = new DesigncheckDao(getConnection()); 
		return dao.delete(dC_id); 
	} 
 
	public List<Designcheck> findAll() { 
		DesigncheckDao dao = new DesigncheckDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Designcheck> findWhere(String where) { 
		DesigncheckDao dao = new DesigncheckDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Designcheck findById(int dC_id) { 
		DesigncheckDao dao = new DesigncheckDao(getConnection()); 
		return dao.findById(dC_id); 
	} 
 
	public List<Designcheck> findByRange(int start, int size) { 
		DesigncheckDao dao = new DesigncheckDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		DesigncheckDao dao = new DesigncheckDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
