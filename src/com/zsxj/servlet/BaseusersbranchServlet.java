package com.zsxj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.zsxj.action.BaseusersbranchAction;
import com.zsxj.model.Baseusersbranch;
import com.zsxj.model.Message;

@WebServlet(name = "baseusersbranch", urlPatterns = "/base/usersbranch/usersbranch")
public class BaseusersbranchServlet extends BaseServlet {
	StringBuilder sBuilder;
	public BaseusersbranchServlet() {
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
				.getParameter("action").trim();
		
		int branch_ID = request.getParameter("branch_ID") == null ? 0 : Integer
				.parseInt(request.getParameter("branch_ID"));
		String branch_Name = request.getParameter("branch_Name") == null ? ""
				: request.getParameter("branch_Name").trim();
		int branch_PID = request.getParameter("branch_PID") == null ? 0
				: Integer.parseInt(request.getParameter("branch_PID"));
		String branch_Code = request.getParameter("branch_Code") == null ? ""
				: request.getParameter("branch_Code").trim();
		int branch_OrderBy = request.getParameter("branch_OrderBy") == null ? 0
				: Integer.parseInt(request.getParameter("branch_OrderBy"));
		BaseusersbranchAction op = new BaseusersbranchAction();
		Baseusersbranch baseusersbranch = new Baseusersbranch();
		baseusersbranch.branch_ID = branch_ID;
		baseusersbranch.branch_Name = branch_Name;
		baseusersbranch.branch_PID = branch_PID;
		baseusersbranch.branch_Code = branch_Code;
		baseusersbranch.branch_OrderBy = branch_OrderBy;
		String page = "";

		if (action.equals("add")) {
			int id = op.add(baseusersbranch);
			if (id > 0) {
				page = "list.jsp";
			} else {
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		}
		else if(action.equals("beforeadd")){
			List<Baseusersbranch> branchs = op.findAll();
			request.setAttribute("branchs",branchs);
			page = "add.jsp";
			Dispatcher(request, response, page);
		} else if (action.equals("edit")) {
			Baseusersbranch model = new Baseusersbranch();
			if (branch_ID > 0) {
				model = op.findById(branch_ID);
				page = "edit.jsp?action=update";
			} else {
				page = "/error.jsp";
			}
			/*request.setAttribute("model",sBuilder, model);
			List<Baseusersbranch> branchs = op.findAll();
			request.setAttribute("branchs",branchs);
			Dispatcher(request, response, page);*/
			
//			builderTreeMenus(0);
			request.setAttribute("menuTree",sBuilder.toString());
			page = "add.jsp";
			Dispatcher(request, response, page);
		} else if (action.equals("update")) {
			int id = op.edit(baseusersbranch);
			if (id > 0) {
				page = "list.jsp";
			} else {
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		}else if (action.equals("tree")) {
			List<Baseusersbranch> branchs = op.findAll();
			JSONArray jsonArray = JSONArray.fromObject(branchs);
			
			response.getWriter().print(jsonArray);

		} else if (action.equals("del")) {
			int id = op.delete(branch_ID);
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
			List<Baseusersbranch> lists = op.findByRange((pagenum - 1)
					* pageSize, pageSize);
			request.setAttribute("baseusersbranchs", lists);
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

			List<Baseusersbranch> lists = op.findByRange((pagenum - 1)
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
