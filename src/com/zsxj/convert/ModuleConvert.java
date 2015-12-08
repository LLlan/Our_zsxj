package com.zsxj.convert;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.zsxj.common.database.convert.ResultConverter;
import com.zsxj.model.Module;

public class ModuleConvert implements ResultConverter<Module>{

	@Override
	public Module convert(ResultSet rs) throws SQLException {
		Module module = new Module(rs.getInt(1));
		module.module_Name = rs.getString(2);
		module.module_Code = rs.getString(3);
		module.module_OrderBy = rs.getInt(4);
		
		return module;
	}

}
