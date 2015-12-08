package com.zsxj.service;

import java.util.List;

import com.zsxj.common.database.DatabaseTransaction;
import com.zsxj.common.service.BaseService;
import com.zsxj.dao.ModuleDao;
import com.zsxj.model.Module;

public class ModuleService extends BaseService {
	public ModuleService(DatabaseTransaction trans) {
		super(trans);
	}

	public ModuleService() {
		super();
	}

	public int add(Module module) {
		ModuleDao dao = new ModuleDao(getConnection());
		return dao.add(module);
	}

	public int edit(Module module) {
		ModuleDao dao = new ModuleDao(getConnection());
		return dao.edit(module);
	}

	public int delete(int module_id) {
		ModuleDao dao = new ModuleDao(getConnection());
		return dao.delete(module_id);
	}

	public List<Module> findAll() {
		ModuleDao dao = new ModuleDao(getConnection());
		return dao.findAll();
	}

	public List<Module> findWhere(String where) {
		ModuleDao dao = new ModuleDao(getConnection());
		return dao.findWhere(where);
	}

	public Module findById(int module_id) {
		ModuleDao dao = new ModuleDao(getConnection());
		return dao.findById(module_id);
	}

	public List<Module> findByRange(int start, int size) {
		ModuleDao dao = new ModuleDao(getConnection());
		return dao.findByRange(start,size);
	}

	/**
	 * 查询总记录数
	 * 
	 * @return
	 */
	public Integer getCount() {
		ModuleDao dao = new ModuleDao(getConnection());
		return dao.getCount();
	}
}
