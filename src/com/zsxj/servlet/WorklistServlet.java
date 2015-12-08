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
import com.zsxj.action.WorklistAction;
import com.zsxj.model.Baseusers;
import com.zsxj.model.Worklist;
import com.zsxj.model.Message;

@WebServlet(name = "worklist", urlPatterns = "/worklist/worklist")
public class WorklistServlet extends BaseServlet {

	public WorklistServlet() {
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
		int wL_ID = request.getParameter("wL_ID") == null ? 0 : Integer
				.parseInt(request.getParameter("wL_ID"));
		String wL_NO = request.getParameter("wL_NO") == null ? "" : request
				.getParameter("wL_NO").trim();
		String wL_Title = request.getParameter("wL_Title") == null ? ""
				: request.getParameter("wL_Title").trim();
		String wL_Content = request.getParameter("wL_Content") == null ? ""
				: request.getParameter("wL_Content").trim();
		String wL_UsersIDs = request.getParameter("wL_UsersIDs") == null ? ""
				: request.getParameter("wL_UsersIDs").trim();
		String wL_StartTime = request.getParameter("wL_StartTime") == null ? ""
				: request.getParameter("wL_StartTime").trim();
		String wL_EndTime = request.getParameter("wL_EndTime") == null ? ""
				: request.getParameter("wL_EndTime").trim();
		int users_ID = request.getParameter("users_ID") == null ? 0 : Integer
				.parseInt(request.getParameter("users_ID"));
		WorklistAction op = new WorklistAction();
		Worklist worklist = new Worklist();
		worklist.wl_ID = wL_ID;
		worklist.wl_NO = wL_NO;
		worklist.wl_Title = wL_Title;
		worklist.wl_Content = wL_Content;
		worklist.wl_UsersIDs = wL_UsersIDs;
		worklist.wl_StartTime = wL_StartTime;
		worklist.wl_EndTime = wL_EndTime;
		worklist.users_ID = users_ID;
		String page = "";

		if (action.equals("add")) {
			int id = op.add(worklist);
			if (id > 0) {
				page = "list.jsp";
			} else {
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		} else if (action.equals("beforeadd")) {
			BaseusersAction buAction = new BaseusersAction();
			List<Baseusers> users = buAction.findAll();
	
			request.setAttribute("users", users);
			page = "add.jsp";
			Dispatcher(request, response, page);
		} else if (action.equals("edit")) {
			Worklist model = new Worklist();
			BaseusersAction buAction = new BaseusersAction();
			List<Baseusers> users = buAction.findAll();
			request.setAttribute("users", users);
			
			if (wL_ID > 0) {
				model = op.findById(wL_ID);
				page = "edit.jsp?action=update";
			} else {
				page = "/error.jsp";
			}
			request.setAttribute("model", model);
			Dispatcher(request, response, page);
		} else if (action.equals("update")) {
			int id = op.edit(worklist);
			if (id > 0) {
				page = "list.jsp";
			} else {
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		} else if (action.equals("del")) {
			int id = op.delete(wL_ID);
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
			List<Worklist> lists = op.findByRange((pagenum - 1) * pageSize,
					pageSize);
			request.setAttribute("worklists", lists);
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

			List<Worklist> lists = op.findByRange((pagenum - 1) * pagesize,
					pagesize);
			JSONObject jsonObj = new JSONObject();

			jsonObj.put("records", totalCount);
			jsonObj.put("page", pagenum);
			jsonObj.put("total", totalpagenum);
			jsonObj.put("rows", lists);
			System.out.println(jsonObj);
			response.getWriter().print(jsonObj);
		} else {
			page = "/error.jsp";
			Dispatcher(request, response, page);
		}
	}

}
