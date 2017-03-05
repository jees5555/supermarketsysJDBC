package com.github.jees5555.supermarketsysJDBC.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.github.jees5555.supermarketsysJDBC.biz.UserBiz;

/**
 * Servlet implementation class UserPasswordUpdateServlet
 */
@WebServlet("/view/UserPasswordUpdateServlet")
public class UserPasswordUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPasswordUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		String userPassword=request.getParameter("userPasswordNew");
		UserBiz ub = new UserBiz();
		ub.updateUserPassword(Integer.parseInt(userId),userPassword);
	    HttpSession session = request.getSession();
	    if(session.getAttribute("userRole").equals(0)){
	    	response.sendRedirect("admin_welcome.jsp");
	    }else{
		response.sendRedirect("UserMgrServlet");
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
