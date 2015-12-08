package com.zsxj.service; 
 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.common.service.BaseService; 
import com.zsxj.dao.SupervisorcheckDao; 
import com.zsxj.model.Supervisorcheck; 
 
public class SupervisorcheckService extends BaseService { 
	public SupervisorcheckService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public SupervisorcheckService() { 
		super(); 
	} 
 
	public int add(Supervisorcheck supervisorcheck) { 
		SupervisorcheckDao dao = new SupervisorcheckDao(getConnection()); 
		return dao.add(supervisorcheck); 
	} 
 
	public int edit(Supervisorcheck supervisorcheck) { 
		SupervisorcheckDao dao = new SupervisorcheckDao(getConnection()); 
		return dao.edit(supervisorcheck); 
	} 
 
	public int delete(int sC_ID) { 
		SupervisorcheckDao dao = new SupervisorcheckDao(getConnection()); 
		return dao.delete(sC_ID); 
	} 
 
	public List<Supervisorcheck> findAll() { 
		SupervisorcheckDao dao = new SupervisorcheckDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Supervisorcheck> findWhere(String where) { 
		SupervisorcheckDao dao = new SupervisorcheckDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Supervisorcheck findById(int sC_ID) { 
		SupervisorcheckDao dao = new SupervisorcheckDao(getConnection()); 
		return dao.findById(sC_ID); 
	} 
 
	public List<Supervisorcheck> findByRange(int start, int size) { 
		SupervisorcheckDao dao = new SupervisorcheckDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		SupervisorcheckDao dao = new SupervisorcheckDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
