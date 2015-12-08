package com.zsxj.servlet;

import java.io.IOException;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

import com.zsxj.action.BasemenusAction;
import com.zsxj.action.BasemenusmoduleAction;
import com.zsxj.action.BasemoduleAction;
import com.zsxj.model.Basemenus;
import com.zsxj.model.Basemenusmodule;
import com.zsxj.model.Basemodule;
import com.zsxj.model.Message;

@WebServlet(name = "basemenusmodule", urlPatterns = "/base/menusmodule/menusmodule")
public class BasemenusmoduleServlet extends BaseServlet {

	public BasemenusmoduleServlet() {
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
		response.setContentType("text/html;charset=utf-8");

		String action = request.getParameter("action") == null ? "" : request
				.getParameter("action");
		int memusModule_ID = request.getParameter("memusModule_ID") == null ? 0
				: Integer.parseInt(request.getParameter("memusModule_ID"));
		int menus_ID = request.getParameter("menus_ID") == null ? 0 : Integer
				.parseInt(request.getParameter("menus_ID"));
		int module_ID = request.getParameter("module_ID") == null ? 0 : Integer
				.parseInt(request.getParameter("module_ID"));
		BasemenusmoduleAction op = new BasemenusmoduleAction();
		Basemenusmodule basemenusmodule = new Basemenusmodule();
		basemenusmodule.memusModule_ID = memusModule_ID;
		basemenusmodule.menus_ID = menus_ID;
		basemenusmodule.module_ID = module_ID;
		String page = "";

		if (action.equals("add")) {
			int id = op.add(basemenusmodule);
			if (id > 0) {
				page = "list.jsp";
			} else {
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		}else if (action.equals("beforeadd")) {
			//1.获得所有的菜单和模块
			BasemenusAction mAction = new BasemenusAction();
			List<Basemenus> menus = mAction.findAll();
			BasemoduleAction bAction = new BasemoduleAction();
			List<Basemodule> modules = bAction.findAll();
		
			request.setAttribute("menus", menus);
			request.setAttribute("modules",modules);
			page = "add.jsp";
			Dispatcher(request, response, page);
			
		} else if (action.equals("edit")) {
			Basemenusmodule model = new Basemenusmodule();
			if (memusModule_ID > 0) {
				model = op.findById(memusModule_ID);
				page = "edit.jsp?action=update";
			} else {
				page = "/error.jsp";
			}
			//1.获得所有的菜单和模块
			BasemenusAction mAction = new BasemenusAction();
			List<Basemenus> menus = mAction.findAll();
			BasemoduleAction bAction = new BasemoduleAction();
			List<Basemodule> modules = bAction.findAll();
			
			request.setAttribute("menus", menus);
			request.setAttribute("modules",modules);
			request.setAttribute("model", model);
			Dispatcher(request, response, page);
		} else if (action.equals("update")) {
			int id = op.edit(basemenusmodule);
			if (id > 0) {
				page = "list.jsp";
			} else {
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		} else if (action.equals("del")) {
			int id = op.delete(memusModule_ID);
			if (id > 0) {
				page = "list.jsp";
			} else {
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		} else if (action.equals("list")) {

			int pagenum = request.getParameter("page") == null ? 1 : Integer
					.parseInt(request.getParameter("page"));
			page = "list.jsp?page=" + pagenum;
			List<Basemenusmodule> lists = op.findByRange((pagenum - 1)
					* pageSize, pageSize);
			request.setAttribute("basemenusmodules", lists);
			request.setAttribute("pagenum", pagenum);
			request.setAttribute("maxpage",
					op.getCount() % pageSize == 0 ? op.getCount() / pageSize
							: op.getCount() / pageSize + 1);
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
						"成功删除选择列!", ""));
				response.getWriter().print(jsonObj.toString());
			} else {
				JSONObject jsonObj = JSONObject.fromObject(new Message(0,
						"删除出错!", ""));
				response.getWriter().print(jsonObj.toString());
			}

		} else if (action.equals("listjson")) {
			int totalCount = op.getCount();
			int pagenum = request.getParameter("page") == null ? 1 : Integer
					.parseInt(request.getParameter("page"));
			int pagesize = request.getParameter("rows") == null ? 1 : Integer
					.parseInt(request.getParameter("rows"));
			int totalpagenum = totalCount % pagesize == 0 ? totalCount
					/ pagesize : totalCount / pagesize + 1;

			List<Basemenusmodule> lists = op.findByRange((pagenum - 1)
					* pagesize, pagesize);
			JSONObject jsonObj = new JSONObject();

			jsonObj.put("records", totalCount);
			jsonObj.put("page", pagenum);
			jsonObj.put("total", totalpagenum);
			jsonObj.put("rows", lists);
			response.getWriter().print(jsonObj);
		} else {
			page = "/error.jsp";
			Dispatcher(request, response, page);
		}
	}

}
