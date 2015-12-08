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
import com.zsxj.action.WorkplanAction;
import com.zsxj.model.Baseusers;
import com.zsxj.model.Workplan;
import com.zsxj.model.Message;

@WebServlet(name = "workplan", urlPatterns = "/workplan/workplan")
public class WorkplanServlet extends BaseServlet {

	public WorkplanServlet() {
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
		int wP_ID = request.getParameter("wP_ID") == null ? 0 : Integer
				.parseInt(request.getParameter("wP_ID"));
		int wP_IsTemp = request.getParameter("wP_IsTemp") == null ? 0 : Integer
				.parseInt(request.getParameter("wP_IsTemp"));
		String wP_Date = request.getParameter("wP_Date") == null ? "" : request
				.getParameter("wP_Date").trim();
		String wP_Address = request.getParameter("wP_Address") == null ? ""
				: request.getParameter("wP_Address").trim();
		String wP_Content = request.getParameter("wP_Content") == null ? ""
				: request.getParameter("wP_Content").trim();
		int users_ID = request.getParameter("users_ID") == null ? 0 : Integer
				.parseInt(request.getParameter("users_ID"));
		WorkplanAction op = new WorkplanAction();
		Workplan workplan = new Workplan();
		workplan.wp_ID = wP_ID;
		workplan.wp_IsTemp = wP_IsTemp;
		workplan.wp_Date = wP_Date;
		workplan.wp_Address = wP_Address;
		workplan.wp_Content = wP_Content;
		workplan.users_ID = users_ID;
		String page = "";

		if (action.equals("add")) {
			int id = op.add(workplan);
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
			Workplan model = new Workplan();
			if (wP_ID > 0) {
				model = op.findById(wP_ID);
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
			int id = op.edit(workplan);
			if (id > 0) {
				page = "list.jsp";
			} else {
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		} else if (action.equals("del")) {
			int id = op.delete(wP_ID);
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
			List<Workplan> lists = op.findByRange((pagenum - 1) * pageSize,
					pageSize);
			request.setAttribute("workplans", lists);
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

			List<Workplan> lists = op.findByRange((pagenum - 1) * pagesize,
					pagesize);
			JSONObject jsonObj = new JSONObject();;
			System.out.println(jsonObj);
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
