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
import com.zsxj.action.BasemoduleAction;
import com.zsxj.action.BaserolemenusAction;
import com.zsxj.action.BaseusersroleAction;
import com.zsxj.model.Basemenus;
import com.zsxj.model.Basemodule;
import com.zsxj.model.Baserolemenus;
import com.zsxj.model.Baseusersrole;
import com.zsxj.model.Message;

@WebServlet(name = "baserolemenus", urlPatterns = "/base/rolemenus/rolemenus")
public class BaserolemenusServlet extends BaseServlet {

	public BaserolemenusServlet() {
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
		int rM_ID = request.getParameter("rM_ID") == null ? 0 : Integer
				.parseInt(request.getParameter("rM_ID"));
		int role_ID = request.getParameter("role_ID") == null ? 0 : Integer
				.parseInt(request.getParameter("role_ID"));
		int menus_ID = request.getParameter("menus_ID") == null ? 0 : Integer
				.parseInt(request.getParameter("menus_ID"));
		int module_ID = request.getParameter("module_ID") == null ? 0 : Integer
				.parseInt(request.getParameter("module_ID"));
		BaserolemenusAction op = new BaserolemenusAction();
		Baserolemenus baserolemenus = new Baserolemenus();
		baserolemenus.rm_ID = rM_ID;
		baserolemenus.role_ID = role_ID;
		baserolemenus.menus_ID = menus_ID;
		baserolemenus.module_ID = module_ID;
		String page = "";

		if (action.equals("add")) {
			int id = op.add(baserolemenus);
			if (id > 0) {
				page = "list.jsp";
			} else {
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		}else if (action.equals("beforeadd")) {
			//1.获得所有的菜单和模块以及角色
			BasemenusAction mAction = new BasemenusAction();
			List<Basemenus> menus = mAction.findAll();
			BasemoduleAction bAction = new BasemoduleAction();
			List<Basemodule> modules = bAction.findAll();
			BaseusersroleAction rAction = new BaseusersroleAction();
			List<Baseusersrole> roles = rAction.findAll();
		
			request.setAttribute("roles",roles);
			request.setAttribute("menus", menus);
			request.setAttribute("modules",modules);
			page = "add.jsp";
			Dispatcher(request, response, page);
		} else if (action.equals("edit")) {
			Baserolemenus model = new Baserolemenus();
			if (rM_ID > 0) {
				model = op.findById(rM_ID);
				page = "edit.jsp?action=update";
			} else {
				page = "/error.jsp";
			}
			BasemenusAction mAction = new BasemenusAction();
			List<Basemenus> menus = mAction.findAll();
			BasemoduleAction bAction = new BasemoduleAction();
			List<Basemodule> modules = bAction.findAll();
			BaseusersroleAction rAction = new BaseusersroleAction();
			List<Baseusersrole> roles = rAction.findAll();
		
			request.setAttribute("roles",roles);
			request.setAttribute("menus", menus);
			request.setAttribute("modules",modules);
			request.setAttribute("model", model);
			Dispatcher(request, response, page);
		} else if (action.equals("update")) {
			int id = op.edit(baserolemenus);
			if (id > 0) {
				page = "list.jsp";
			} else {
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		} else if (action.equals("del")) {
			int id = op.delete(rM_ID);
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
			List<Baserolemenus> lists = op.findByRange(
					(pagenum - 1) * pageSize, pageSize);
			request.setAttribute("baserolemenuss", lists);
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

			List<Baserolemenus> lists = op.findByRange(
					(pagenum - 1) * pagesize, pagesize);
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
