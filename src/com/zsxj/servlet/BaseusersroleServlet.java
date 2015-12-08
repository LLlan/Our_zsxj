package com.zsxj.servlet; 
 
import java.io.IOException; 
 
import java.util.List; 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import net.sf.json.JSONObject; 
 
import com.zsxj.action.BaseusersroleAction; 
import com.zsxj.model.Baseusersrole; 
import com.zsxj.model.Message; 
 
@WebServlet(name = "baseusersrole", urlPatterns = "/base/usersrole/usersrole") 
public class BaseusersroleServlet extends BaseServlet { 
 
	public BaseusersroleServlet() { 
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
		int role_ID = request.getParameter("role_ID") == null ? 0 : Integer.parseInt(request.getParameter("role_ID")); 
		String role_Name = request.getParameter("role_Name") == null ? "" : request.getParameter("role_Name").trim();
		int role_OrderBy = request.getParameter("role_OrderBy") == null ? 0 : Integer.parseInt(request.getParameter("role_OrderBy")); 
		BaseusersroleAction op = new BaseusersroleAction(); 
		Baseusersrole baseusersrole = new Baseusersrole(); 
		baseusersrole.role_ID = role_ID; 
		baseusersrole.role_Name = role_Name; 
		baseusersrole.role_OrderBy = role_OrderBy; 
		String page = ""; 
 
		if (action.equals("add")) { 
			int id = op.add(baseusersrole); 
			if (id > 0) { 
				page = "list.jsp"; 
			} else { 
				page = "/error.jsp"; 
			} 
Dispatcher(request, response, page); 
		} else if (action.equals("edit")) { 
			Baseusersrole model = new Baseusersrole(); 
			if (role_ID > 0) { 
				model = op.findById(role_ID); 
				page = "edit.jsp?action=update"; 
			} else { 
				page = "/error.jsp"; 
			} 
			request.setAttribute("model", model); 
Dispatcher(request, response, page);		} else if (action.equals("update")) { 
			int id = op.edit(baseusersrole); 
			if (id > 0) { 
				page = "list.jsp"; 
			} else { 
				page = "/error.jsp"; 
			} 
Dispatcher(request, response, page);		} else if (action.equals("del")) { 
			int id = op.delete(role_ID); 
			if (id > 0) { 
				page = "list.jsp"; 
			} else { 
				page = "/error.jsp"; 
			} 
Dispatcher(request, response, page);		} else if (action.equals("list")) { 
 
			int pagenum = request.getParameter("page") == null ? 1 : Integer 
					.parseInt(request.getParameter("page")); 
			page = "list.jsp?page=" + pagenum; 
			List<Baseusersrole> lists = op.findByRange((pagenum - 1) * pageSize, 
					pageSize); 
			request.setAttribute("baseusersroles", lists); 
			request.setAttribute("pagenum", pagenum); 
			request.setAttribute("maxpage", 
					op.getCount() % pageSize == 0 ? op.getCount() / pageSize 
							: op.getCount() / pageSize + 1); 
Dispatcher(request, response, page);		} else if (action.equals("delall")) { 
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
 
			List<Baseusersrole> lists = op.findByRange((pagenum - 1) * pagesize, 
					pagesize); 
			JSONObject jsonObj = new JSONObject(); 
 
			jsonObj.put("records", totalCount); 
			jsonObj.put("page", pagenum); 
			jsonObj.put("total", totalpagenum); 
			jsonObj.put("rows", lists); 
			response.getWriter().print(jsonObj); 
		} else { 
			page = "/error.jsp"; 
Dispatcher(request, response, page);		} 
	} 
 
} 
