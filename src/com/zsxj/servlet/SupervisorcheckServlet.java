package com.zsxj.servlet;

import java.io.File;
import java.io.IOException;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import net.sf.json.JSONObject;

import com.zsxj.action.SupervisorcheckAction;
import com.zsxj.model.Buildcheck;
import com.zsxj.model.Supervisorcheck;
import com.zsxj.model.Message;

@WebServlet(name = "supervisorcheck", urlPatterns = "/supervisorcheck/supervisorcheck")
public class SupervisorcheckServlet extends BaseServlet {

	public SupervisorcheckServlet() {
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
		int sC_ID = request.getParameter("sC_ID") == null ? 0 : Integer
				.parseInt(request.getParameter("sC_ID"));
		String sC_Address = request.getParameter("sC_Address") == null ? ""
				: request.getParameter("sC_Address").trim();
		String sC_ProjectName = request.getParameter("sC_ProjectName") == null ? ""
				: request.getParameter("sC_ProjectName").trim();
		String sC_ProjectDesc = request.getParameter("sC_ProjectDesc") == null ? ""
				: request.getParameter("sC_ProjectDesc").trim();
		String users_ID = request.getParameter("users_ID") == null ? "" : request.getParameter("users_ID").trim();
		SupervisorcheckAction op = new SupervisorcheckAction();
		Supervisorcheck supervisorcheck = new Supervisorcheck();
		supervisorcheck.sc_ID = sC_ID;
		supervisorcheck.sc_Address = sC_Address;
		supervisorcheck.sc_ProjectName = sC_ProjectName;
		supervisorcheck.sc_ProjectDesc = sC_ProjectDesc;
		supervisorcheck.users_ID = users_ID;
		String page = "";
		String filename = "";

		if (action.equals("add")) {
			
			getUploadInfo(request, supervisorcheck, filename);
			
			int id = op.add(supervisorcheck);
			if (id > 0) {
				page = "list.jsp";
			} else {
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		} else if (action.equals("edit")) {
			Supervisorcheck model = new Supervisorcheck();
			if (sC_ID > 0) {
				model = op.findById(sC_ID);
				page = "edit.jsp?action=update";
			} else {
				page = "/error.jsp";
			}
			request.setAttribute("model", model);
			Dispatcher(request, response, page);
		} else if (action.equals("update")) {
			
			getUploadInfo(request, supervisorcheck, filename);
			
			int id = op.edit(supervisorcheck);
			if (id > 0) {
				page = "list.jsp";
			} else {
				page = "/error.jsp";
			}
			Dispatcher(request, response, page);
		} else if (action.equals("del")) {
			int id = op.delete(sC_ID);
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
			List<Supervisorcheck> lists = op.findByRange((pagenum - 1)
					* pageSize, pageSize);
			request.setAttribute("supervisorchecks", lists);
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

			List<Supervisorcheck> lists = op.findByRange((pagenum - 1)
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
	
	private void getUploadInfo(HttpServletRequest request,
			Supervisorcheck supervisorcheck, String filename) {
		//1.设置文件存放的路径
		//获取文件存放路径
		String path = getServletContext().getRealPath("/upload/sup");
		//创建相应路径的上传文件夹
		File file = new File(path);
		 //判断上传文件的保存目录是否存在,不存在则创建相应的目录
		if(!file.exists() && !file.isDirectory()){
			file.mkdir();
		}
		
		//2.获得ServletFileUpload 文件解析器
		
		//DiskFileItemFactory,用来获取磁盘的文件列表工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//设置储存室
		factory.setRepository(file);
		//设置缓存区的大小
		factory.setSizeThreshold(1024*1024);
		//ServletFileUpload 文件解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		//判断提交上来的数据是否是上传表单的数据
		if(!ServletFileUpload.isMultipartContent(request)){
			return;
		}
		
		//3.循环读取文件列表,并进行相应的读写
		
		try {
			//获得List<FileItem>集合
			List<FileItem> items = upload.parseRequest(request);
			//便利文件集合
			for (FileItem item : items) {
				//判断是普通输入项还是文件上传项
				if (item.isFormField()) {
					if(item.getFieldName().equals("sC_Address")){
						supervisorcheck.sc_Address = item.getString();
					}
					if(item.getFieldName().equals("sC_ProjectName")){
						supervisorcheck.sc_ProjectName = item.getString();
					}
					if(item.getFieldName().equals("sC_ProjectDes")){
						supervisorcheck.sc_ProjectDesc = item.getString();
					}
					if(item.getFieldName().equals("users_ID")){
						supervisorcheck.users_ID = item.getString();
					}
					
				}else{
					//获取文件名路径
					filename = item.getName();
				
					if(filename == null || filename.trim().equals("")){
						continue;
					}
					//获得文件名
					filename = filename.substring(filename.lastIndexOf("\\") + 1);
					
					//写入磁盘(简单易用)
					item.write(new File(path,filename));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		supervisorcheck.pic_Name = filename;
	}


}
