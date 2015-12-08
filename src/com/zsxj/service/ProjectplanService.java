package com.zsxj.service; 
 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.common.service.BaseService; 
import com.zsxj.dao.ProjectplanDao; 
import com.zsxj.model.Projectplan; 
 
public class ProjectplanService extends BaseService { 
	public ProjectplanService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public ProjectplanService() { 
		super(); 
	} 
 
	public int add(Projectplan projectplan) { 
		ProjectplanDao dao = new ProjectplanDao(getConnection()); 
		return dao.add(projectplan); 
	} 
 
	public int edit(Projectplan projectplan) { 
		ProjectplanDao dao = new ProjectplanDao(getConnection()); 
		return dao.edit(projectplan); 
	} 
 
	public int delete(int pP_ID) { 
		ProjectplanDao dao = new ProjectplanDao(getConnection()); 
		return dao.delete(pP_ID); 
	} 
 
	public List<Projectplan> findAll() { 
		ProjectplanDao dao = new ProjectplanDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Projectplan> findWhere(String where) { 
		ProjectplanDao dao = new ProjectplanDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Projectplan findById(int pP_ID) { 
		ProjectplanDao dao = new ProjectplanDao(getConnection()); 
		return dao.findById(pP_ID); 
	} 
 
	public List<Projectplan> findByRange(int start, int size) { 
		ProjectplanDao dao = new ProjectplanDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		ProjectplanDao dao = new ProjectplanDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
