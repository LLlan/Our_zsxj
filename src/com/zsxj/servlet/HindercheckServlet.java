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
import com.zsxj.action.HindercheckAction; 
import com.zsxj.model.Baseusers;
import com.zsxj.model.Hindercheck; 
import com.zsxj.model.Message; 
 


@WebServlet(name = "hindercheck", urlPatterns = "/hindercheck/hindercheck") 
public class HindercheckServlet extends BaseServlet { 
 
	public HindercheckServlet() { 
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
		int hC_ID = request.getParameter("hC_ID") == null ? 0 : Integer.parseInt(request.getParameter("hC_ID")); 
		String hC_Address = request.getParameter("hC_Address") == null ? "" : request.getParameter("hC_Address").trim();
		String hC_Desc = request.getParameter("hC_Desc") == null ? "" : request.getParameter("hC_Desc").trim();
		String hC_Process = request.getParameter("hC_Process") == null ? "" : request.getParameter("hC_Process").trim();
		String hC_ProcessUserID = request.getParameter("hC_ProcessUserID") == null ? "" : request.getParameter("hC_ProcessUserID").trim(); 
		//int users_ID = request.getParameter("users_ID") == null ? 0 : Integer.parseInt(request.getParameter("users_ID")); 
		HindercheckAction op = new HindercheckAction(); 
		Hindercheck hindercheck = new Hindercheck(); 
		hindercheck.hc_ID = hC_ID; 
		hindercheck.hc_Address = hC_Address; 
		hindercheck.hc_Desc = hC_Desc; 
		hindercheck.hc_Process = hC_Process; 
		hindercheck.hc_ProcessUserID = hC_ProcessUserID; 
		//hindercheck.users_ID = users_ID; 
		String page = ""; 
 
		if (action.equals("add")) { 
			int id = op.add(hindercheck); 
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
			Hindercheck model = new Hindercheck(); 
			if (hC_ID > 0) { 
				model = op.findById(hC_ID); 
				page = "edit.jsp?action=update"; 
			} else { 
				page = "/error.jsp"; 
			} 
			BaseusersAction bAction = new BaseusersAction();
			List<Baseusers> users = bAction.findAll();
			
			request.setAttribute("users",users);
			request.setAttribute("model", model); 
Dispatcher(request, response, page);		} else if (action.equals("update")) { 
			int id = op.edit(hindercheck); 
			if (id > 0) { 
				page = "list.jsp"; 
			} else { 
				page = "/error.jsp"; 
			} 
Dispatcher(request, response, page);		} else if (action.equals("del")) { 
			int id = op.delete(hC_ID); 
			if (id > 0) { 
				page = "list.jsp"; 
			} else { 
				page = "/error.jsp"; 
			} 
Dispatcher(request, response, page);		} else if (action.equals("list")) { 
 
			int pagenum = request.getParameter("page") == null ? 1 : Integer 
					.parseInt(request.getParameter("page")); 
			page = "list.jsp?page=" + pagenum; 
			List<Hindercheck> lists = op.findByRange((pagenum - 1) * pageSize, 
					pageSize); 
			request.setAttribute("hinderchecks", lists); 
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
 
			List<Hindercheck> lists = op.findByRange((pagenum - 1) * pagesize, 
					pagesize); 
			JSONObject jsonObj = new JSONObject(); 
			
 
			jsonObj.put("records", totalCount); 
			jsonObj.put("page", pagenum); 
			jsonObj.put("total", totalpagenum); 
			jsonObj.put("rows", lists); 
			response.setContentType("text/javascript");
			response.getWriter().print(jsonObj); 
		} else { 
			page = "/error.jsp"; 
Dispatcher(request, response, page);		} 
	} 
 
} 
