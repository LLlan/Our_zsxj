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
import com.zsxj.action.BaseusersAction;
import com.zsxj.action.BaseuserslogAction;
import com.zsxj.model.Basemenus;
import com.zsxj.model.Baseusers;
import com.zsxj.model.Baseuserslog;
import com.zsxj.model.Message;

@WebServlet(name = "baseuserslog", urlPatterns = "/base/userslog/userslog")
public class BaseuserslogServlet extends BaseServlet {


	public BaseuserslogServlet() {
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
		int log_ID = request.getParameter("log_ID") == null ? 0 : Integer
				.parseInt(request.getParameter("log_ID"));
		String log_Url = request.getParameter("log_Url") == null ? "" : request
				.getParameter("log_Url").trim();
		String log_Date = request.getParameter("log_Date") == null ? ""
				: request.getParameter("log_Date").trim();
		String log_IP = request.getParameter("log_IP") == null ? "" : request
				.getParameter("log_IP").trim();
		int users_ID = request.getParameter("users_ID") == null ? 0 : Integer
				.parseInt(request.getParameter("users_ID"));
		String log_Type = request.getParameter("log_Type") == null ? ""
				: request.getParameter("log_Type").trim();
		String log_Desc = request.getParameter("log_Desc") == null ? ""
				: request.getParameter("log_Desc").trim();
		BaseuserslogAction op = new BaseuserslogAction();
		Baseuserslog baseuserslog = new Baseuserslog();
		baseuserslog.log_ID = log_ID;
		baseuserslog.log_Url = log_Url;
		baseuserslog.log_Date = log_Date;
		baseuserslog.log_IP = log_IP;
		baseuserslog.users_ID = users_ID;
		baseuserslog.log_Type = log_Type;
		baseuserslog.log_Desc = log_Desc;
		String page = "";

		if (action.equals("add")) {
			int id = op.add(baseuserslog);
			if (id > 0) {
				page = "list.jsp";
			} else {
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		}else if (action.equals("beforeadd")) {
			BaseusersAction bAction = new BaseusersAction();
			List<Baseusers> users = bAction.findAll();
			request.setAttribute("users",users);
			page = "add.jsp";
			Dispatcher(request, response, page);
		} else if (action.equals("edit")) {
			Baseuserslog model = new Baseuserslog();
			if (log_ID > 0) {
				model = op.findById(log_ID);
				page = "edit.jsp?action=update";
			} else {
				page = "/error.jsp";
			}
			BaseusersAction bAction = new BaseusersAction();
			List<Baseusers> users = bAction.findAll();
			request.setAttribute("users",users);
			request.setAttribute("model", model);
			Dispatcher(request, response, page);
		} else if (action.equals("update")) {
			int id = op.edit(baseuserslog);
			if (id > 0) {
				page = "list.jsp";
			} else {
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		} else if (action.equals("del")) {
			int id = op.delete(log_ID);
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
			List<Baseuserslog> lists = op.findByRange((pagenum - 1) * pageSize,
					pageSize);
			request.setAttribute("baseuserslogs", lists);
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

			List<Baseuserslog> lists = op.findByRange((pagenum - 1) * pagesize,
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
