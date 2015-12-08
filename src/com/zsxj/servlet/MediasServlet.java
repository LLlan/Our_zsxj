package com.zsxj.servlet; 
 
import java.io.IOException; 
 
import java.util.List; 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import net.sf.json.JSONObject; 
 
import com.zsxj.action.MediasAction; 
import com.zsxj.model.Medias; 
import com.zsxj.model.Message; 
 
@WebServlet(name = "medias", urlPatterns = "/medias/medias") 
public class MediasServlet extends BaseServlet { 
 
	public MediasServlet() { 
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
		int medias_ID = request.getParameter("medias_ID") == null ? 0 : Integer.parseInt(request.getParameter("medias_ID")); 
		int medias_Type = request.getParameter("medias_Type") == null ? 0 : Integer.parseInt(request.getParameter("medias_Type")); 
		String medias_Title = request.getParameter("medias_Title") == null ? "" : request.getParameter("medias_Title").trim();
		String medias_AddTime = request.getParameter("medias_AddTime") == null ? "" : request.getParameter("medias_AddTime").trim();
		String medias_Url = request.getParameter("medias_Url") == null ? "" : request.getParameter("medias_Url").trim();
		String medias_BelongtoTable = request.getParameter("medias_BelongtoTable") == null ? "" : request.getParameter("medias_BelongtoTable").trim();
		int medias_BelongtoID = request.getParameter("medias_BelongtoID") == null ? 0 : Integer.parseInt(request.getParameter("medias_BelongtoID")); 
		MediasAction op = new MediasAction(); 
		Medias medias = new Medias(); 
		medias.medias_ID = medias_ID; 
		medias.medias_Type = medias_Type; 
		medias.medias_Title = medias_Title; 
		medias.medias_AddTime = medias_AddTime; 
		medias.medias_Url = medias_Url; 
		medias.medias_BelongtoTable = medias_BelongtoTable; 
		medias.medias_BelongtoID = medias_BelongtoID; 
		String page = ""; 
 
		if (action.equals("add")) { 
			int id = op.add(medias); 
			if (id > 0) { 
				page = "list.jsp"; 
			} else { 
				page = "/error.jsp"; 
			} 
Dispatcher(request, response, page); 
		} else if (action.equals("edit")) { 
			Medias model = new Medias(); 
			if (medias_ID > 0) { 
				model = op.findById(medias_ID); 
				page = "edit.jsp?action=update"; 
			} else { 
				page = "/error.jsp"; 
			} 
			request.setAttribute("model", model); 
Dispatcher(request, response, page);		} else if (action.equals("update")) { 
			int id = op.edit(medias); 
			if (id > 0) { 
				page = "list.jsp"; 
			} else { 
				page = "/error.jsp"; 
			} 
Dispatcher(request, response, page);		} else if (action.equals("del")) { 
			int id = op.delete(medias_ID); 
			if (id > 0) { 
				page = "list.jsp"; 
			} else { 
				page = "/error.jsp"; 
			} 
Dispatcher(request, response, page);		} else if (action.equals("list")) { 
 
			int pagenum = request.getParameter("page") == null ? 1 : Integer 
					.parseInt(request.getParameter("page")); 
			page = "list.jsp?page=" + pagenum; 
			List<Medias> lists = op.findByRange((pagenum - 1) * pageSize, 
					pageSize); 
			request.setAttribute("mediass", lists); 
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
 
			List<Medias> lists = op.findByRange((pagenum - 1) * pagesize, 
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
