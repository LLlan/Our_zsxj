package com.zsxj.service; 
 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.common.service.BaseService; 
import com.zsxj.dao.AdormcheckDao; 
import com.zsxj.model.Adormcheck; 
 
public class AdormcheckService extends BaseService { 
	public AdormcheckService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public AdormcheckService() { 
		super(); 
	} 
 
	public int add(Adormcheck adormcheck) { 
		AdormcheckDao dao = new AdormcheckDao(getConnection()); 
		return dao.add(adormcheck); 
	} 
 
	public int edit(Adormcheck adormcheck) { 
		AdormcheckDao dao = new AdormcheckDao(getConnection()); 
		return dao.edit(adormcheck); 
	} 
 
	public int delete(int aC_ID) { 
		AdormcheckDao dao = new AdormcheckDao(getConnection()); 
		return dao.delete(aC_ID); 
	} 
 
	public List<Adormcheck> findAll() { 
		AdormcheckDao dao = new AdormcheckDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Adormcheck> findWhere(String where) { 
		AdormcheckDao dao = new AdormcheckDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Adormcheck findById(int aC_ID) { 
		AdormcheckDao dao = new AdormcheckDao(getConnection()); 
		return dao.findById(aC_ID); 
	} 
 
	public List<Adormcheck> findByRange(int start, int size) { 
		AdormcheckDao dao = new AdormcheckDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		AdormcheckDao dao = new AdormcheckDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
