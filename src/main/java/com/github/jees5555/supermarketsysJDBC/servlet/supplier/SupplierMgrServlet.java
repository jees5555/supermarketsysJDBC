package com.github.jees5555.supermarketsysJDBC.servlet.supplier;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.jees5555.supermarketsysJDBC.biz.SupplierBiz;
import com.github.jees5555.supermarketsysJDBC.entity.Supplier;

/**
 * Servlet implementation class SupplierMgrServlet
 */
@WebServlet("/view/SupplierMgrServlet")
public class SupplierMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierMgrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String supplierName=request.getParameter("supplierName");
		String supplierInfo=request.getParameter("supplierInfo");
		if(supplierName==null){
			supplierName="";
		}
		if(supplierInfo==null){
			supplierInfo="";
		}
		SupplierBiz pb =new SupplierBiz();
		List<Supplier> list =pb.getSupplierList(supplierName,supplierInfo);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("supplierInfo", supplierInfo);
		request.setAttribute("supplierList", list);
		request.getRequestDispatcher("supplierAdmin.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
