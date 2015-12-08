package com.zsxj.dao;

import java.sql.Connection;
import java.util.List;

import com.zsxj.common.database.access.DataAccess;
import com.zsxj.common.database.convert.IntegerConverter;
import com.zsxj.convert.ModuleConvert;
import com.zsxj.model.Module;

public class ModuleDao extends DataAccess {

	public ModuleDao(Connection conn) {
		super(conn);
	}

	public int add(Module module) {
		String sql = "INSERT INTO base_module (Module_Name,Module_Code,Module_OrderBy) VALUES (?,?,?)";
		return super.insert(sql, new IntegerConverter(), module.module_Name,
				module.module_Code, module.module_OrderBy);
	}

	public int edit(Module module) {
		String sql = "UPDATE base_module SET Module_Name=?,Module_Code=?,Module_OrderBy=? WHERE Module_ID=?";
		return super.update(sql, module.module_Name, module.module_Code,
				module.module_OrderBy, module.module_ID);
	}

	public int delete(int module_id) {
		String sql = "DELETE FROM base_module WHERE Module_ID=?";
		return super.update(sql, module_id);
	}

	public List<Module> findAll() {
		String sql = "SELECT * FROM base_module";
		return super.queryForList(sql, new ModuleConvert());
	}

	public List<Module> findWhere(String where) {
		String sql = "SELECT * FROM base_module WHERE 1=1 " + where;
		return super.queryForList(sql, new ModuleConvert());
	}

	public Module findById(int module_id) {
		String sql = "SELECT * FROM base_module WHERE Module_ID=?";
		return super.queryForObject(sql, new ModuleConvert(), module_id);
	}

	/**
	 * @
	 * @param start
	 * @param size
	 * @return
	 */
	public List<Module> findByRange(int start, int size) {
		return super.queryForList("SELECT * FROM base_module limit ?,?",
				new ModuleConvert(), start, size);
	}

	/**
	 * 查询总记录数
	 * 
	 * @return
	 */
	public Integer getCount() {
		return super.queryForObject("SELECT COUNT(*) FROM base_module",
				new IntegerConverter());
	}

}
