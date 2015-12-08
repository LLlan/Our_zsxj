package com.zsxj.servlet;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

import com.google.gson.Gson;
import com.zsxj.action.BaseusersAction;
import com.zsxj.action.BaseusersbranchAction;
import com.zsxj.action.ProjectplanAction;
import com.zsxj.model.Baseusers;
import com.zsxj.model.Baseusersbranch;
import com.zsxj.model.Projectplan;
import com.zsxj.model.Message;


@WebServlet(name = "projectplan", urlPatterns = "/projectplan/projectplan")
public class ProjectplanServlet extends BaseServlet {

	public ProjectplanServlet() {
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
		int pP_ID = request.getParameter("pP_ID") == null ? 0 : Integer
				.parseInt(request.getParameter("pP_ID"));
		String pP_ProjectName = request.getParameter("pP_ProjectName") == null ? ""
				: request.getParameter("pP_ProjectName").trim();
		String pP_ProjectNo = request.getParameter("pP_ProjectNo") == null ? ""
				: request.getParameter("pP_ProjectNo").trim();
		String pP_ExecComName = request.getParameter("pP_ExecComName") == null ? ""
				: request.getParameter("pP_ExecComName").trim();
		String pP_Content = request.getParameter("pP_Content") == null ? ""
				: request.getParameter("pP_Content").trim();
		String pP_BOMList = request.getParameter("pP_BOMList") == null ? ""
				: request.getParameter("pP_BOMList").trim();
		String pP_StartDate = request.getParameter("pP_StartDate") == null ? ""
				: request.getParameter("pP_StartDate").trim();
		String pP_EndDate = request.getParameter("pP_EndDate") == null ? ""
				: request.getParameter("pP_EndDate").trim();
		int users_ID = request.getParameter("users_ID") == null ? 0 : Integer
				.parseInt(request.getParameter("users_ID"));
		ProjectplanAction op = new ProjectplanAction();
		Projectplan projectplan = new Projectplan();
		projectplan.pp_ID = pP_ID;
		projectplan.pp_ProjectName = pP_ProjectName;
		projectplan.pp_ProjectNo = pP_ProjectNo;
		projectplan.pp_ExecComName = pP_ExecComName;
		projectplan.pp_Content = pP_Content;
		projectplan.pp_BOMList = pP_BOMList;
		projectplan.pp_StartDate = pP_StartDate;
		projectplan.pp_EndDate = pP_EndDate;
		projectplan.users_ID = users_ID;
		String page = "";

		if (action.equals("add")) {
			int id = op.add(projectplan);
			if (id > 0) {
				page = "list.jsp";
			} else {
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		} else if (action.equals("beforeadd")) {
			BaseusersbranchAction bAction = new BaseusersbranchAction();
			List<Baseusersbranch> branchs = bAction.findAll();
			request.setAttribute("branchs", branchs);
			page = "add.jsp";
			Dispatcher(request, response, page);
		} else if (action.equals("edit")) {
			Projectplan model = new Projectplan();
			if (pP_ID > 0) {
				model = op.findById(pP_ID);
				page = "edit.jsp?action=update";
			} else {
				page = "/error.jsp";
			}
			//获取获取部门信息和员工信息
			BaseusersbranchAction bAction = new BaseusersbranchAction();
			List<Baseusersbranch> branchs = bAction.findAll();
			BaseusersAction uAction = new BaseusersAction();
			List<Baseusers> users = null;
			for (Baseusersbranch branch : branchs) {
				if (branch.getBranch_Name().equals(model.getPp_ExecComName())) {
					users = uAction.findWhere(" and Branch_ID = " + branch.getBranch_ID());
				}
			}
			request.setAttribute("model", model);
			request.setAttribute("branchs",branchs);
			request.setAttribute("users",users);
			Dispatcher(request, response, page);
		} else if (action.equals("update")) {
			int id = op.edit(projectplan);
			if (id > 0) {
				page = "list.jsp";
			} else {
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		} else if (action.equals("del")) {
			int id = op.delete(pP_ID);
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
			List<Projectplan> lists = op.findByRange((pagenum - 1) * pageSize,
					pageSize);
			request.setAttribute("projectplans", lists);
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

		}else if (action.equals("queryUser")) {
			//1.获得发送过来的请求
			String StrId = request.getParameter("brandId");
			int brandId = Integer.parseInt(StrId);
			BaseusersAction bAction = new BaseusersAction();
			//2.进行相应的查询
			List<Baseusers> users = bAction.findWhere(" and Branch_ID = " + brandId);
			//3.封装json数据
			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			Gson gson = new Gson();
			
			for (Baseusers user : users) {
				
				Map<String, Object> result = new HashMap<String, Object>();
				result.put("users_Name",user.getUsers_TrueName());
				result.put("users_ID",user.getUsers_ID());
				list.add(result);
			}
			String strJson = gson.toJson(list);
			//4.返回数据
			response.setCharacterEncoding("gbk");
			response.setContentType("text/javascript");
			response.getWriter().print(strJson);
		} else if (action.equals("listjson")) {
			int totalCount = op.getCount();
			int pagenum = request.getParameter("page") == null ? 1 : Integer
					.parseInt(request.getParameter("page"));
			int pagesize = request.getParameter("rows") == null ? 1 : Integer
					.parseInt(request.getParameter("rows"));
			int totalpagenum = totalCount % pagesize == 0 ? totalCount
					/ pagesize : totalCount / pagesize + 1;

			List<Projectplan> lists = op.findByRange((pagenum - 1) * pagesize,
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
