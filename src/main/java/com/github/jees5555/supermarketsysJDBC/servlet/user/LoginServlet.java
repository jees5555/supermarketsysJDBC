package com.github.jees5555.supermarketsysJDBC.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.github.jees5555.supermarketsysJDBC.biz.UserBiz;
import com.github.jees5555.supermarketsysJDBC.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String userPassword=request.getParameter("passWord");
		UserBiz ub =new UserBiz();
		User user=ub.login(userName,userPassword);
		if(user==null){
			response.getWriter().print(false);
		}else{
		HttpSession session =request.getSession();
		session.setAttribute("userId", user.getUserId());
		session.setAttribute("userName",user.getUserName());
		session.setAttribute("userRole", user.getUserRole());
		response.sendRedirect("view/admin_index.jsp");
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
