package com.zsxj.service; 
 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.common.service.BaseService; 
import com.zsxj.dao.HindercheckDao; 
import com.zsxj.model.Hindercheck; 
 
public class HindercheckService extends BaseService { 
	public HindercheckService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public HindercheckService() { 
		super(); 
	} 
 
	public int add(Hindercheck hindercheck) { 
		HindercheckDao dao = new HindercheckDao(getConnection()); 
		return dao.add(hindercheck); 
	} 
 
	public int edit(Hindercheck hindercheck) { 
		HindercheckDao dao = new HindercheckDao(getConnection()); 
		return dao.edit(hindercheck); 
	} 
 
	public int delete(int hC_ID) { 
		HindercheckDao dao = new HindercheckDao(getConnection()); 
		return dao.delete(hC_ID); 
	} 
 
	public List<Hindercheck> findAll() { 
		HindercheckDao dao = new HindercheckDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Hindercheck> findWhere(String where) { 
		HindercheckDao dao = new HindercheckDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Hindercheck findById(int hC_ID) { 
		HindercheckDao dao = new HindercheckDao(getConnection()); 
		return dao.findById(hC_ID); 
	} 
 
	public List<Hindercheck> findByRange(int start, int size) { 
		HindercheckDao dao = new HindercheckDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		HindercheckDao dao = new HindercheckDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
