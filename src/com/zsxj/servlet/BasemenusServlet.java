package com.zsxj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.zsxj.action.BasemenusAction;
import com.zsxj.model.Basemenus;
import com.zsxj.model.Message;

@WebServlet(name = "basemenus", urlPatterns = "/base/menus/menus")
public class BasemenusServlet extends BaseServlet 
{
	StringBuilder sBuilder;

	public BasemenusServlet()
	{
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String action = request.getParameter("action") == null ? "" : request.getParameter("action");
		int menus_ID = (request.getParameter("menus_ID") == null || request.getParameter("menus_ID") .equals("")  )?
				0 : Integer.parseInt(request.getParameter("menus_ID"));
		String menus_Title = request.getParameter("menus_Title") == null ? ""
				: request.getParameter("menus_Title").trim();
		String menus_Url = request.getParameter("menus_Url") == null ? ""
				: request.getParameter("menus_Url").trim();
		int menus_PID = request.getParameter("menus_PID") == null ? 0 : Integer
				.parseInt(request.getParameter("menus_PID"));
		String menus_Code = request.getParameter("menus_Code") == null ? ""
				: request.getParameter("menus_Code").trim();
		String menus_Icon = request.getParameter("menus_Icon") == null ? ""
				: request.getParameter("menus_Icon").trim();
		int menus_OrderBy = request.getParameter("menus_OrderBy") == null ? 0
				: Integer.parseInt(request.getParameter("menus_OrderBy"));
		BasemenusAction op = new BasemenusAction();
		Basemenus basemenus = new Basemenus();
		basemenus.menus_ID = menus_ID;
		basemenus.menus_Title = menus_Title;
		basemenus.menus_Url = menus_Url;
		basemenus.menus_PID = menus_PID;
		basemenus.menus_Code = menus_Code;
		basemenus.menus_Icon = menus_Icon;
		basemenus.menus_OrderBy = menus_OrderBy;
		String page = "";

		if (action.equals("add")) 
		{
			int id = op.add(basemenus);
			if (id > 0)
			{
				page = "list.jsp";
			} else
			{
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		}
		else if (action.equals("beforeadd"))
		{
			//1.获得所有的菜单
			//List<Basemenus> menus = op.findAll();
			// 2.保持数据
			//request.setAttribute("menus", menus);
			builderTreeMenus(0);
			request.setAttribute("menuTree",sBuilder.toString());
			page = "add.jsp";
			Dispatcher(request, response, page);
		}
		else if (action.equals("edit"))
		{
			Basemenus model = new Basemenus();
			if (menus_ID > 0)
			{
				model = op.findById(menus_ID);
				page = "edit.jsp?action=update";
			}
			else
			{
				page = "/error.jsp";
			}
			
			//1.获得所有的菜单
			//List<Basemenus> menus = op.findAll();
			// 2.保持数据
			//request.setAttribute("menus", menus);
			builderTreeMenus(model.getMenus_PID());
			request.setAttribute("menuTree",sBuilder.toString());
			request.setAttribute("model", model);
			Dispatcher(request, response, page);
		} 
		else if (action.equals("update")) 
		{
			int id = op.edit(basemenus);
			if (id > 0)
			{
				page = "list.jsp";
			} else 
			{
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		} 
		else if (action.equals("del"))
		{
			int id = op.delete(menus_ID);
			if (id > 0)
			{
				page = "list.jsp";
			} 
			else
			{
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		}
		else if (action.equals("list")) {

			int pagenum = request.getParameter("page") == null ? 1 : Integer
					.parseInt(request.getParameter("page"));
			page = "list.jsp?page=" + pagenum;
			List<Basemenus> lists = op.findByRange((pagenum - 1) * pageSize,
					pageSize);
			request.setAttribute("basemenuss", lists);
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

		}else if (action.equals("ztree")) {
			//1.获取所有菜单
			List<Basemenus> menus = op.findAll();
			//2.转化成json数组
			JSONArray jsonArray = JSONArray.fromObject(menus);
			//3.返回json数组
			response.setContentType("text/javascript");
			response.getWriter().print(jsonArray);
			
		} else if (action.equals("listjson")) {
			int totalCount = op.getCount();
			int pagenum = request.getParameter("page") == null ? 1 : Integer
					.parseInt(request.getParameter("page"));
			int pagesize = request.getParameter("rows") == null ? 1 : Integer
					.parseInt(request.getParameter("rows"));
			int totalpagenum = totalCount % pagesize == 0 ? totalCount
					/ pagesize : totalCount / pagesize + 1;

			List<Basemenus> lists = op.findByRange((pagenum - 1) * pagesize,
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
	
	private void builderTreeMenus(int selectPID){
		sBuilder = new StringBuilder();
		sBuilder.append("<option value = '0'>请选择菜单....</option>");
		constructTree(selectPID,null,0);
	}
	/**
	 * 递归方法构造树形菜单(重点)
	 * @param parentMenu
	 * @param rootlevel
	 */
	private void constructTree(int selectPID, Basemenus parentMenu,int rootlevel){
		
		BasemenusAction bAction = new BasemenusAction();
		int pid = 0;
		
		//获取根节点
		if(parentMenu !=null){
			pid = parentMenu.getMenus_ID();
		}
		//获取子节点
		List<Basemenus> chiList = bAction.findWhere(" and Menus_PID=" + pid);
		rootlevel = rootlevel + 1;
		//遍历所有的子节点
		for (Basemenus basemenus : chiList) {
			
			if(basemenus.getMenus_ID() == selectPID){
				sBuilder.append("<option value = '"+ basemenus.getMenus_ID() +"' selected='selected'>");
			}else{
				sBuilder.append("<option value = '"+ basemenus.getMenus_ID() +"'>");
			}
			
			for (int i = 0; i < rootlevel; i++) {
				sBuilder.append("----");
			}
			
			sBuilder.append(basemenus.getMenus_Title());
			sBuilder.append("</option>");
			//进行递归调用
			constructTree(selectPID,basemenus,rootlevel);
		}
	}


}
