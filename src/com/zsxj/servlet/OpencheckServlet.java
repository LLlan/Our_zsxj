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
import com.zsxj.action.OpencheckAction;
import com.zsxj.model.Baseusers;
import com.zsxj.model.Opencheck;
import com.zsxj.model.Message;

@WebServlet(name = "opencheck", urlPatterns = "/opencheck/opencheck")
public class OpencheckServlet extends BaseServlet {

	public OpencheckServlet() {
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
		int oC_ID = request.getParameter("oC_ID") == null ? 0 : Integer
				.parseInt(request.getParameter("oC_ID"));
		String oC_ProjectNO = request.getParameter("oC_ProjectNO") == null ? ""
				: request.getParameter("oC_ProjectNO").trim();
		String oC_ENO = request.getParameter("oC_ENO") == null ? "" : request
				.getParameter("oC_ENO").trim();
		String oC_BusinessType = request.getParameter("oC_BusinessType") == null ? ""
				: request.getParameter("oC_BusinessType").trim();
		String oC_CustInfo = request.getParameter("oC_CustInfo") == null ? ""
				: request.getParameter("oC_CustInfo").trim();
		String users_ID = request.getParameter("users_ID") == null ? "" :request.getParameter("users_ID").trim();
		OpencheckAction op = new OpencheckAction();
		Opencheck opencheck = new Opencheck();
		opencheck.oc_ID = oC_ID;
		opencheck.oc_ProjectNO = oC_ProjectNO;
		opencheck.oc_ENO = oC_ENO;
		opencheck.oc_BusinessType = oC_BusinessType;
		opencheck.oc_CustInfo = oC_CustInfo;
		opencheck.users_ID = users_ID;
		String page = "";

		if (action.equals("add")) {
			int id = op.add(opencheck);
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
			Opencheck model = new Opencheck();
			if (oC_ID > 0) {
				model = op.findById(oC_ID);
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
			int id = op.edit(opencheck);
			if (id > 0) {
				page = "list.jsp";
			} else {
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		} else if (action.equals("del")) {
			int id = op.delete(oC_ID);
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
			List<Opencheck> lists = op.findByRange((pagenum - 1) * pageSize,
					pageSize);
			request.setAttribute("openchecks", lists);
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

			List<Opencheck> lists = op.findByRange((pagenum - 1) * pagesize,
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
