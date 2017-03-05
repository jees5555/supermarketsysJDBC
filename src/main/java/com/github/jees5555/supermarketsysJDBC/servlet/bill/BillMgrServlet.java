package com.github.jees5555.supermarketsysJDBC.servlet.bill;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.jees5555.supermarketsysJDBC.biz.BillBiz;
import com.github.jees5555.supermarketsysJDBC.entity.Bill;

/**
 * Servlet implementation class BillMgrServlet
 */
@WebServlet("/view/BillMgrServlet")
public class BillMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillMgrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName=request.getParameter("productName");
		String payStatusStr=request.getParameter("payStatus");
		if(productName==null){
			productName="";
		}
		if(payStatusStr==null){
			payStatusStr="";
		}
		BillBiz bb =new BillBiz();
		List <Bill>list=bb.getBillList(productName,payStatusStr);
		request.setAttribute("productName", productName);
		request.setAttribute("payStatus", payStatusStr);
		request.setAttribute("billList", list);
		request.getRequestDispatcher("billAdmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
