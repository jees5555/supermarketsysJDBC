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
 * Servlet implementation class UserAddOrSaveServlet
 */
@WebServlet("/view/UserAddOrSaveServlet")
public class UserAddOrSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddOrSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userIdOld=request.getParameter("userIdOld");
		String userIdNew=request.getParameter("userIdNew");
		String userName=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		String userSex=request.getParameter("userSex");
		String userAge=request.getParameter("userAge");
		String userTel=request.getParameter("userTel");
		String userAddress=request.getParameter("userAddress");
		String userRole=request.getParameter("userRole");
		User u =new User();
		u.setUserId(Integer.parseInt(userIdNew));
		u.setUserName(userName);
		u.setUserPassword(userPassword);
		u.setUserSex(Integer.parseInt(userSex));
		u.setUserAge(Integer.parseInt(userAge));
		u.setUserTel(Long.parseLong(userTel));
		u.setUserAddress(userAddress);
		u.setUserRole(Integer.parseInt(userRole));
		UserBiz ub = new UserBiz();
		if(userIdOld==null||userIdOld.equals("")){
			ub.addUser(u);
		}else{
			ub.updateUser(userIdOld,u);
		}
		HttpSession session =request.getSession();
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
