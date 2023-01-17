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

/**
 * Servlet implementation class DeleteServ
 */
@WebServlet("/delete")
public class DeleteServ extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		TodoDAO dao=new TodoDAO(DBConnect.getCon());
		boolean f=dao.delTodo(id);
		HttpSession session=req.getSession();
		if(f) {
			session.setAttribute("sucMsg","Todo Delete Succesfully");
			response.sendRedirect("index.jsp");
		}else {
			session.setAttribute("FaildMsg","Something Wrong");
			response.sendRedirect("index.jsp");
		}
	}

	

}
