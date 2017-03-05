package com.github.jees5555.supermarketsysJDBC.servlet.supplier;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.jees5555.supermarketsysJDBC.biz.SupplierBiz;
import com.github.jees5555.supermarketsysJDBC.entity.Supplier;

/**
 * Servlet implementation class SupplierOperateServlet
 */
@WebServlet("/view/SupplierOperateServlet")
public class SupplierOperateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierOperateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String supplierId=request.getParameter("supplierId");
		SupplierBiz pb =new SupplierBiz();
		if(supplierId==null){
			request.setAttribute("supplierId", "");
			request.setAttribute("supplierName", "");
			request.setAttribute("supplierInfo", "");
			request.setAttribute("supplierAtten", "");
			request.setAttribute("supplierTel", "");
			request.setAttribute("supplierFax", "");
			request.setAttribute("supplierAddress", "");
		}else{
			Supplier p =pb.getSupplier(supplierId);
			request.setAttribute("supplierId", p.getSupplierId());
			request.setAttribute("supplierName", p.getSupplierName());
			request.setAttribute("supplierInfo", p.getSupplierInfo());
			request.setAttribute("supplierAtten", p.getSupplierAtten());
			request.setAttribute("supplierTel", p.getSupplierTel()==0?"":p.getSupplierTel());
			request.setAttribute("supplierFax", p.getSupplierFax()==0?"":p.getSupplierFax());
			request.setAttribute("supplierAddress", p.getSupplierAddress());
		}
		request.getRequestDispatcher("supplierAdd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
