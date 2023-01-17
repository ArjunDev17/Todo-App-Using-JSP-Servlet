package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.TodoDAO;
import com.db.DBConnect;

@WebServlet("/add_todo")
public class AddServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//doGet(request, response);
		String username = req.getParameter("username");
		String todo = req.getParameter("todo");
		String status = req.getParameter("status");
		
		TodoDAO dao=new TodoDAO(DBConnect.getCon());
		boolean f=dao.addTodo(username,todo,status);
		HttpSession session=req.getSession();
		if(f) {
			session.setAttribute("sucMsg","Todo added Succesfully");
			res.sendRedirect("index.jsp");
		}else {
			session.setAttribute("FaildMsg","Todo added Succesfully");
			System.out.println("index.jsp");
		}
		//System.out.println(name + " " + todo + " " + status);
	
	}

}
