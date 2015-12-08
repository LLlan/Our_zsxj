package com.zsxj.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 文件上传处理
 */
@WebServlet("/uploadservlet")
public class Uploadservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.设置文件存放的路径
		//获取文件存放路径
		String path = getServletContext().getRealPath("/upload");
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
				
				}else{
					//获取文件名路径
					String filename = item.getName();
				
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
		
		
		
		
	}

}
