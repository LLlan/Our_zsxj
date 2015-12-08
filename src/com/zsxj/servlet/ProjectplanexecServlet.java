package com.zsxj.servlet; 
 
import java.io.IOException; 
 
import java.util.List; 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import net.sf.json.JSONObject; 
 
import com.zsxj.action.ProjectplanexecAction; 
import com.zsxj.model.Projectplanexec; 
import com.zsxj.model.Message; 
 
@WebServlet(name = "projectplanexec", urlPatterns = "/projectplanexec/projectplanexec") 
public class ProjectplanexecServlet extends BaseServlet { 
 
	public ProjectplanexecServlet() { 
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
		int pPE_ID = request.getParameter("pPE_ID") == null ? 0 : Integer.parseInt(request.getParameter("pPE_ID")); 
		String pPE_Date = request.getParameter("pPE_Date") == null ? "" : request.getParameter("pPE_Date").trim();
		String pPE_RealAddress = request.getParameter("pPE_RealAddress") == null ? "" : request.getParameter("pPE_RealAddress").trim();
		String pPE_RealContent = request.getParameter("pPE_RealContent") == null ? "" : request.getParameter("pPE_RealContent").trim();
		int pP_ID = request.getParameter("pP_ID") == null ? 0 : Integer.parseInt(request.getParameter("pP_ID")); 
		int users_ID = request.getParameter("users_ID") == null ? 0 : Integer.parseInt(request.getParameter("users_ID")); 
		ProjectplanexecAction op = new ProjectplanexecAction(); 
		Projectplanexec projectplanexec = new Projectplanexec(); 
		projectplanexec.ppe_ID = pPE_ID; 
		projectplanexec.ppe_Date = pPE_Date; 
		projectplanexec.ppe_RealAddress = pPE_RealAddress; 
		projectplanexec.ppe_RealContent = pPE_RealContent; 
		projectplanexec.pp_ID = pP_ID; 
		projectplanexec.users_ID = users_ID; 
		String page = ""; 
 
		if (action.equals("add")) { 
			int id = op.add(projectplanexec); 
			if (id > 0) { 
				page = "list.jsp"; 
			} else { 
				page = "/error.jsp"; 
			} 
Dispatcher(request, response, page); 
		} else if (action.equals("edit")) { 
			Projectplanexec model = new Projectplanexec(); 
			if (pPE_ID > 0) { 
				model = op.findById(pPE_ID); 
				page = "edit.jsp?action=update"; 
			} else { 
				page = "/error.jsp"; 
			} 
			request.setAttribute("model", model); 
Dispatcher(request, response, page);		} else if (action.equals("update")) { 
			int id = op.edit(projectplanexec); 
			if (id > 0) { 
				page = "list.jsp"; 
			} else { 
				page = "/error.jsp"; 
			} 
Dispatcher(request, response, page);		} else if (action.equals("del")) { 
			int id = op.delete(pPE_ID); 
			if (id > 0) { 
				page = "list.jsp"; 
			} else { 
				page = "/error.jsp"; 
			} 
Dispatcher(request, response, page);		} else if (action.equals("list")) { 
 
			int pagenum = request.getParameter("page") == null ? 1 : Integer 
					.parseInt(request.getParameter("page")); 
			page = "list.jsp?page=" + pagenum; 
			List<Projectplanexec> lists = op.findByRange((pagenum - 1) * pageSize, 
					pageSize); 
			request.setAttribute("projectplanexecs", lists); 
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
 
			List<Projectplanexec> lists = op.findByRange((pagenum - 1) * pagesize, 
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
