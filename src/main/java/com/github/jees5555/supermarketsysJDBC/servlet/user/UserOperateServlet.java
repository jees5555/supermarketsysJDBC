package com.github.jees5555.supermarketsysJDBC.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.jees5555.supermarketsysJDBC.biz.UserBiz;
import com.github.jees5555.supermarketsysJDBC.entity.User;

/**
 * Servlet implementation class UserOperateServlet
 */
@WebServlet("/view/UserOperateServlet")
public class UserOperateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserOperateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		UserBiz ub =new UserBiz();
		if(userId==null){
			request.setAttribute("userId", "");
			request.setAttribute("userName", "");
			request.setAttribute("userSex", "");
			request.setAttribute("userAge", "");
			request.setAttribute("userTel", "");
			request.setAttribute("userAddress", "");
			request.setAttribute("userRole", "0");
		}else{
			User u =ub.getUser(userId);
			request.setAttribute("userId", u.getUserId());
			request.setAttribute("userName", u.getUserName());
			request.setAttribute("userSex", u.getUserSex()+"");
			request.setAttribute("userAge", u.getUserAge()+"");
			request.setAttribute("userTel", u.getUserTel()+"");
			request.setAttribute("userAddress", u.getUserAddress());
			request.setAttribute("userRole", u.getUserRole()+"");
		}
		request.getRequestDispatcher("userAdd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
