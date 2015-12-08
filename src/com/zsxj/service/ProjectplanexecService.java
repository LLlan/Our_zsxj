package com.zsxj.service; 
 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.common.service.BaseService; 
import com.zsxj.dao.ProjectplanexecDao; 
import com.zsxj.model.Projectplanexec; 
 
public class ProjectplanexecService extends BaseService { 
	public ProjectplanexecService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public ProjectplanexecService() { 
		super(); 
	} 
 
	public int add(Projectplanexec projectplanexec) { 
		ProjectplanexecDao dao = new ProjectplanexecDao(getConnection()); 
		return dao.add(projectplanexec); 
	} 
 
	public int edit(Projectplanexec projectplanexec) { 
		ProjectplanexecDao dao = new ProjectplanexecDao(getConnection()); 
		return dao.edit(projectplanexec); 
	} 
 
	public int delete(int pPE_ID) { 
		ProjectplanexecDao dao = new ProjectplanexecDao(getConnection()); 
		return dao.delete(pPE_ID); 
	} 
 
	public List<Projectplanexec> findAll() { 
		ProjectplanexecDao dao = new ProjectplanexecDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Projectplanexec> findWhere(String where) { 
		ProjectplanexecDao dao = new ProjectplanexecDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Projectplanexec findById(int pPE_ID) { 
		ProjectplanexecDao dao = new ProjectplanexecDao(getConnection()); 
		return dao.findById(pPE_ID); 
	} 
 
	public List<Projectplanexec> findByRange(int start, int size) { 
		ProjectplanexecDao dao = new ProjectplanexecDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		ProjectplanexecDao dao = new ProjectplanexecDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
