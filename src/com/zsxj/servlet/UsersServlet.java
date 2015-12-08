package com.zsxj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zsxj.action.UsersAction;
import com.zsxj.model.Users;

/**
 * 用户登录验证servlet；
 * @author Administrator
 */
@WebServlet("/UsersValidator")
public class UsersServlet extends HttpServlet
{
	private static final long serialVersionUID = -6212407690363772289L;

	// 构造方法；
	public UsersServlet() 
	{
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html");
		
		String username = request.getParameter("username").trim();
		String userpwd = request.getParameter("userpwd").trim();
		
		Users users = new Users();
		users.users_UserName = username;
		users.users_Password = userpwd;
		
		UsersAction action = new UsersAction();
		String result = "index.jsp";
		boolean validateResult = action.UserValidator(users);
		if(validateResult)
		{
			HttpSession session = request.getSession();
			session.setAttribute("users", users);
		}
		else
		{
			result = "error.jsp";
		}
		
		response.sendRedirect(result);
	}
}
