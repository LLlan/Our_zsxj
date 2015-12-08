package com.zsxj.servlet;

import java.io.IOException;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

import com.zsxj.action.BaseusersAction;
import com.zsxj.action.BaseusersbranchAction;
import com.zsxj.action.BaseusersroleAction;
import com.zsxj.model.Baseusers;
import com.zsxj.model.Baseusersbranch;
import com.zsxj.model.Baseusersrole;
import com.zsxj.model.Message;

@WebServlet(name = "baseusers", urlPatterns = "/base/users/users")
public class BaseusersServlet extends BaseServlet {

	public BaseusersServlet() {
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
		int users_ID = request.getParameter("users_ID") == null ? 0 : Integer
				.parseInt(request.getParameter("users_ID"));
		String users_UserName = request.getParameter("users_UserName") == null ? ""
				: request.getParameter("users_UserName").trim();
		String users_Password = request.getParameter("users_Password") == null ? ""
				: request.getParameter("users_Password").trim();
		String users_Mobile = request.getParameter("users_Mobile") == null ? ""
				: request.getParameter("users_Mobile").trim();
		String users_Phone = request.getParameter("users_Phone") == null ? ""
				: request.getParameter("users_Phone").trim();
		String users_Email = request.getParameter("users_Email") == null ? ""
				: request.getParameter("users_Email").trim();
		String users_TrueName = request.getParameter("users_TrueName") == null ? ""
				: request.getParameter("users_TrueName").trim();
		int users_IsLock = request.getParameter("users_IsLock") == null ? 0
				: Integer.parseInt(request.getParameter("users_IsLock"));
		String users_LastLoginTime = request
				.getParameter("users_LastLoginTime") == null ? "" : request
				.getParameter("users_LastLoginTime").trim();
		String users_LastLoginIP = request.getParameter("users_LastLoginIP") == null ? ""
				: request.getParameter("users_LastLoginIP").trim();
		int branch_ID = request.getParameter("branch_ID") == null ? 0 : Integer
				.parseInt(request.getParameter("branch_ID"));
		int role_ID = request.getParameter("role_ID") == null ? 0 : Integer
				.parseInt(request.getParameter("role_ID"));
		BaseusersAction op = new BaseusersAction();
		Baseusers baseusers = new Baseusers();
		baseusers.users_ID = users_ID;
		baseusers.users_UserName = users_UserName;
		baseusers.users_Password = users_Password;
		baseusers.users_Mobile = users_Mobile;
		baseusers.users_Phone = users_Phone;
		baseusers.users_Email = users_Email;
		baseusers.users_TrueName = users_TrueName;
		baseusers.users_IsLock = users_IsLock;
		baseusers.users_LastLoginTime = users_LastLoginTime;
		baseusers.users_LastLoginIP = users_LastLoginIP;
		baseusers.branch_ID = branch_ID;
		baseusers.role_ID = role_ID;
		String page = "";

		if (action.equals("add")) {
			int id = op.add(baseusers);
			if (id > 0) {
				page = "list.jsp";
			} else {
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		}else if (action.equals("beforeadd")) {
			System.out.println("beforeadd");
			BaseusersbranchAction baction = new BaseusersbranchAction();
			List<Baseusersbranch> branchs = baction.findAll();
			BaseusersroleAction rAction = new BaseusersroleAction();
			List<Baseusersrole> roles = rAction.findAll();
		
			request.setAttribute("branchs",branchs);
			request.setAttribute("roles",roles);
			
			page = "add.jsp";
			Dispatcher(request, response, page);
		}
		else if (action.equals("edit")) {
			Baseusers model = new Baseusers();
			if (users_ID > 0) {
				model = op.findById(users_ID);
				page = "edit.jsp?action=update";
			} else {
				page = "/error.jsp";
			}
			BaseusersbranchAction baction = new BaseusersbranchAction();
			List<Baseusersbranch> branchs = baction.findAll();
			BaseusersroleAction rAction = new BaseusersroleAction();
			List<Baseusersrole> roles = rAction.findAll();
		
			request.setAttribute("branchs",branchs);
			request.setAttribute("roles",roles);
			request.setAttribute("model", model);
			Dispatcher(request, response, page);
		} else if (action.equals("update")) {
			int id = op.edit(baseusers);
			if (id > 0) {
				page = "list.jsp";
			} else {
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		} else if (action.equals("del")) {
			int id = op.delete(users_ID);
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
			List<Baseusers> lists = op.findByRange((pagenum - 1) * pageSize,
					pageSize);
			request.setAttribute("baseuserss", lists);
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

			List<Baseusers> lists = op.findByRange((pagenum - 1) * pagesize,
					pagesize);
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
