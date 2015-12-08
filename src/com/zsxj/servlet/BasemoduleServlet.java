package com.zsxj.servlet; 
 
import java.io.IOException; 
import java.util.List; 

import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

import net.sf.json.JSONObject; 

import com.zsxj.action.BasemoduleAction; 
import com.zsxj.action.ModuleAction;
import com.zsxj.model.Basemodule; 
import com.zsxj.model.Message; 
import com.zsxj.model.Module;
 
@WebServlet(name ="basemodule", urlPatterns = "/base/module/module") 
public class BasemoduleServlet extends BaseServlet { 
 
	public BasemoduleServlet() { 
		super(); 
	} 
 
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { 
 
		response.setContentType("text/html"); 
		request.setCharacterEncoding("utf-8"); 
		response.setCharacterEncoding("utf-8");
		doPost(request, response); 
 
	} 
 
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { 
 
		request.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html"); 
		response.setCharacterEncoding("utf-8");
 
		String action = request.getParameter("action") == null ? "" : request
				.getParameter("action");
		int module_id = request.getParameter("module_id") == null ? 0 : Integer
				.parseInt(request.getParameter("module_id"));
		int module_orderby = request.getParameter("module_orderby") == null ? 0
				: Integer.parseInt(request.getParameter("module_orderby"));
		String module_name = request.getParameter("module_name") == null ? ""
				: request.getParameter("module_name");
		String module_code = request.getParameter("module_code") == null ? ""
				: request.getParameter("module_code");
		ModuleAction op = new ModuleAction();
		Module module = new Module();
		module.module_ID = module_id;
		module.module_Name = module_name;
		module.module_Code = module_code;
		module.module_OrderBy = module_orderby;
		String page = "";

		if (action.equals("add")) {
			int id = op.add(module);
			if (id > 0) {
				page = "listnew.jsp";
			} else {
				page = "../../error.jsp";
			}
			Dispatcher(request, response, page);
		} else if (action.equals("edit")) {
			Module model = new Module();
			if (module_id > 0) {
				model = op.findById(module_id);
				page = "edit.jsp?action=update";
			} else {
				page = "../../error.jsp";
			}
			request.setAttribute("model", model);
			Dispatcher(request, response, page);
		} else if (action.equals("update")) {
			int id = op.edit(module);
			if (id > 0) {
				page = "listnew.jsp";
			} else {
				page = "../../error.jsp";
			}
			Dispatcher(request, response, page);
		} else if (action.equals("del")) {
			int id = op.delete(module_id);
			if (id > 0) {
				page = "listnew.jsp";
			} else {
				page = "../../error.jsp";
			}
			Dispatcher(request, response, page);
		} else if (action.equals("delall")) {
			String ids = request.getParameter("ids");

			if (ids != null && ids.length() > 0) {
				String[] ss = ids.split(",");
				for (String s : ss) {
					if (s != null && s.length() > 0) {
						op.delete(Integer.parseInt(s));
					}
				}
				JSONObject jsonObj = JSONObject.fromObject(new Message(1,
						"'成功','成功删除选择列!'", ""));
				response.getWriter().print(jsonObj.toString());
			} else {
				JSONObject jsonObj = JSONObject.fromObject(new Message(0,
						"'错误','删除出错!'", ""));
				response.getWriter().print(jsonObj.toString());
			}

		} else if (action.equals("list")) {

			int pagenum = request.getParameter("page") == null ? 1 : Integer
					.parseInt(request.getParameter("page"));
			page = "list.jsp?page=" + pagenum;
			List<Module> lists = op.findByRange((pagenum - 1) * pageSize,
					pageSize);
			request.setAttribute("modules", lists);
			request.setAttribute("pagenum", pagenum);
			request.setAttribute("maxpage",
					op.getCount() % pageSize == 0 ? op.getCount() / pageSize
							: op.getCount() / pageSize + 1);
			Dispatcher(request, response, page);
		} else if (action.equals("listjson")) {
			int totalCount = op.getCount();
			int pagenum = request.getParameter("page") == null ? 1 : Integer
					.parseInt(request.getParameter("page"));
			int pagesize = request.getParameter("rows") == null ? 1 : Integer
					.parseInt(request.getParameter("rows"));
			int totalpagenum = totalCount % pagesize == 0 ? totalCount
					/ pagesize : totalCount / pagesize + 1;

			List<Module> lists = op.findByRange((pagenum - 1) * pagesize,
					pagesize);
			JSONObject jsonObj = new JSONObject();

			jsonObj.put("records", totalCount);
			jsonObj.put("page", pagenum);
			jsonObj.put("total", totalpagenum);
			jsonObj.put("rows", lists);
			response.getWriter().print(jsonObj);
		} else {

			page = "../../error.jsp";
			Dispatcher(request, response, page);
		}

	}

 
} 
