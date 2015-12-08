package com.zsxj.service; 
 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.common.service.BaseService; 
import com.zsxj.dao.BuildcheckDao; 
import com.zsxj.model.Buildcheck; 
 
public class BuildcheckService extends BaseService { 
	public BuildcheckService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public BuildcheckService() { 
		super(); 
	} 
 
	public int add(Buildcheck buildcheck) { 
		BuildcheckDao dao = new BuildcheckDao(getConnection()); 
		return dao.add(buildcheck); 
	} 
 
	public int edit(Buildcheck buildcheck) { 
		BuildcheckDao dao = new BuildcheckDao(getConnection()); 
		return dao.edit(buildcheck); 
	} 
 
	public int delete(int bC_ID) { 
		BuildcheckDao dao = new BuildcheckDao(getConnection()); 
		return dao.delete(bC_ID); 
	} 
 
	public List<Buildcheck> findAll() { 
		BuildcheckDao dao = new BuildcheckDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Buildcheck> findWhere(String where) { 
		BuildcheckDao dao = new BuildcheckDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Buildcheck findById(int bC_ID) { 
		BuildcheckDao dao = new BuildcheckDao(getConnection()); 
		return dao.findById(bC_ID); 
	} 
 
	public List<Buildcheck> findByRange(int start, int size) { 
		BuildcheckDao dao = new BuildcheckDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		BuildcheckDao dao = new BuildcheckDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
