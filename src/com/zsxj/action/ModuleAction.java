package com.zsxj.action;

import java.util.ArrayList;
import java.util.List;

import com.zsxj.common.database.DatabaseTransaction;
import com.zsxj.model.Module;
import com.zsxj.service.ModuleService;

public class ModuleAction {
	public int add(Module module) {
		int id = 0;
		DatabaseTransaction trans = new DatabaseTransaction(true);
		try {
			id = new ModuleService(trans).add(module);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			trans.close();
		}
		return id;
	}
	
	public int edit(Module module) {
		int id = 0;
		DatabaseTransaction trans = new DatabaseTransaction(true);
		try {
			id = new ModuleService(trans).edit(module);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			trans.close();
		}
		return id;
	}
	
	public int delete(int module_id) {
		int id = 0;
		DatabaseTransaction trans = new DatabaseTransaction(true);
		try {
			id = new ModuleService(trans).delete(module_id);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			trans.close();
		}
		return id;
	}
	
	public List<Module> findAll() {
		List<Module> lists = new ArrayList<Module>();
		DatabaseTransaction trans = new DatabaseTransaction(true);
		try {
			lists = new ModuleService(trans).findAll();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			trans.close();
		}
		return lists;
	}
	
	public List<Module> findWhere(String where) {
		List<Module> lists = new ArrayList<Module>();
		DatabaseTransaction trans = new DatabaseTransaction(true);
		try {
			lists = new ModuleService(trans).findWhere(where);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			trans.close();
		}
		return lists;
	}
	
	public Module findById(int module_id) {
		Module module = new Module();
		DatabaseTransaction trans = new DatabaseTransaction(true);
		try {
			module = new ModuleService(trans).findById(module_id);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			trans.close();
		}
		return module;
	}
	
	public List<Module> findByRange(int start, int size) {
		List<Module> lists = new ArrayList<Module>();
		DatabaseTransaction trans = new DatabaseTransaction(true);
		try {
			lists = new ModuleService(trans).findByRange(start, size);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			trans.close();
		}
		return lists;
	}
	
	public Integer getCount() {
		int id = 0;
		DatabaseTransaction trans = new DatabaseTransaction(true);
		try {
			id = new ModuleService(trans).getCount();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			trans.close();
		}
		return id;
	}
}
