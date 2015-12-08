package com.zsxj.servlet; 
 
import java.io.IOException; 
 
import java.util.List; 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import net.sf.json.JSONObject; 
 
import com.zsxj.action.WrokplanexecAction; 
import com.zsxj.model.Wrokplanexec; 
import com.zsxj.model.Message; 
 
@WebServlet(name = "wrokplanexec", urlPatterns = "/wrokplanexec/wrokplanexec") 
public class WrokplanexecServlet extends BaseServlet { 
 
	public WrokplanexecServlet() { 
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
		int wPE_ID = request.getParameter("wPE_ID") == null ? 0 : Integer.parseInt(request.getParameter("wPE_ID")); 
		String wPE_Date = request.getParameter("wPE_Date") == null ? "" : request.getParameter("wPE_Date").trim();
		String wPE_RealAddress = request.getParameter("wPE_RealAddress") == null ? "" : request.getParameter("wPE_RealAddress").trim();
		String wPE_RealContent = request.getParameter("wPE_RealContent") == null ? "" : request.getParameter("wPE_RealContent").trim();
		int users_ID = request.getParameter("users_ID") == null ? 0 : Integer.parseInt(request.getParameter("users_ID")); 
		int wP_ID = request.getParameter("wP_ID") == null ? 0 : Integer.parseInt(request.getParameter("wP_ID")); 
		WrokplanexecAction op = new WrokplanexecAction(); 
		Wrokplanexec wrokplanexec = new Wrokplanexec(); 
		wrokplanexec.wpe_ID = wPE_ID; 
		wrokplanexec.wpe_Date = wPE_Date; 
		wrokplanexec.wpe_RealAddress = wPE_RealAddress; 
		wrokplanexec.wpe_RealContent = wPE_RealContent; 
		wrokplanexec.users_ID = users_ID; 
		wrokplanexec.wp_ID = wP_ID; 
		String page = ""; 
 
		if (action.equals("add")) { 
			int id = op.add(wrokplanexec); 
			if (id > 0) { 
				page = "list.jsp"; 
			} else { 
				page = "/error.jsp"; 
			} 
Dispatcher(request, response, page); 
		} else if (action.equals("edit")) { 
			Wrokplanexec model = new Wrokplanexec(); 
			if (wPE_ID > 0) { 
				model = op.findById(wPE_ID); 
				page = "edit.jsp?action=update"; 
			} else { 
				page = "/error.jsp"; 
			} 
			request.setAttribute("model", model); 
Dispatcher(request, response, page);		} else if (action.equals("update")) { 
			int id = op.edit(wrokplanexec); 
			if (id > 0) { 
				page = "list.jsp"; 
			} else { 
				page = "/error.jsp"; 
			} 
Dispatcher(request, response, page);		} else if (action.equals("del")) { 
			int id = op.delete(wPE_ID); 
			if (id > 0) { 
				page = "list.jsp"; 
			} else { 
				page = "/error.jsp"; 
			} 
Dispatcher(request, response, page);		} else if (action.equals("list")) { 
 
			int pagenum = request.getParameter("page") == null ? 1 : Integer 
					.parseInt(request.getParameter("page")); 
			page = "list.jsp?page=" + pagenum; 
			List<Wrokplanexec> lists = op.findByRange((pagenum - 1) * pageSize, 
					pageSize); 
			request.setAttribute("wrokplanexecs", lists); 
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
 
			List<Wrokplanexec> lists = op.findByRange((pagenum - 1) * pagesize, 
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
