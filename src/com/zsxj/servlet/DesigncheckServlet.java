package com.zsxj.servlet; 
 
import java.io.IOException; 
 
import java.util.List; 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import net.sf.json.JSONObject; 
 
import com.zsxj.action.DesigncheckAction; 
import com.zsxj.model.Designcheck; 
import com.zsxj.model.Message; 
 
@WebServlet(name = "designcheck", urlPatterns = "/designcheck/designcheck") 
public class DesigncheckServlet extends BaseServlet { 
 
	public DesigncheckServlet() { 
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
		int dC_id = request.getParameter("dC_id") == null ? 0 : Integer.parseInt(request.getParameter("dC_id")); 
		String dC_Date = request.getParameter("dC_Date") == null ? "" : request.getParameter("dC_Date").trim();
		String dC_Project = request.getParameter("dC_Project") == null ? "" : request.getParameter("dC_Project").trim();
		String dC_Content = request.getParameter("dC_Content") == null ? "" : request.getParameter("dC_Content").trim();
		String users_ID = request.getParameter("users_ID") == null ? "" : request.getParameter("users_ID").trim(); 
		DesigncheckAction op = new DesigncheckAction(); 
		Designcheck designcheck = new Designcheck(); 
		designcheck.dc_id = dC_id; 
		designcheck.dc_Date = dC_Date; 
		designcheck.dc_Project = dC_Project; 
		designcheck.dc_Content = dC_Content; 
		designcheck.users_ID = users_ID; 
		String page = ""; 
 
		if (action.equals("add")) { 
			int id = op.add(designcheck); 
			if (id > 0) { 
				page = "list.jsp"; 
			} else { 
				page = "/error.jsp"; 
			} 
Dispatcher(request, response, page); 
		} else if (action.equals("edit")) { 
			Designcheck model = new Designcheck(); 
			if (dC_id > 0) { 
				model = op.findById(dC_id); 
				page = "edit.jsp?action=update"; 
			} else { 
				page = "/error.jsp"; 
			} 
			request.setAttribute("model", model); 
Dispatcher(request, response, page);		} else if (action.equals("update")) { 
			int id = op.edit(designcheck); 
			if (id > 0) { 
				page = "list.jsp"; 
			} else { 
				page = "/error.jsp"; 
			} 
Dispatcher(request, response, page);		} else if (action.equals("del")) { 
			int id = op.delete(dC_id); 
			if (id > 0) { 
				page = "list.jsp"; 
			} else { 
				page = "/error.jsp"; 
			} 
Dispatcher(request, response, page);		} else if (action.equals("list")) { 
 
			int pagenum = request.getParameter("page") == null ? 1 : Integer 
					.parseInt(request.getParameter("page")); 
			page = "list.jsp?page=" + pagenum; 
			List<Designcheck> lists = op.findByRange((pagenum - 1) * pageSize, 
					pageSize); 
			request.setAttribute("designchecks", lists); 
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
 
			List<Designcheck> lists = op.findByRange((pagenum - 1) * pagesize, 
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
