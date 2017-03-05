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
 * Servlet implementation class SupplierAddOrSaveServlet
 */
@WebServlet("/view/SupplierAddOrSaveServlet")
public class SupplierAddOrSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierAddOrSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String supplierIdOld=request.getParameter("supplierIdOld");
		String supplierIdNew=request.getParameter("supplierIdNew");
		String supplierName=request.getParameter("supplierName");
		String supplierInfo=request.getParameter("supplierInfo");
		String supplierAtten=request.getParameter("supplierAtten");
		String supplierTel=request.getParameter("supplierTel");
		String supplierFax=request.getParameter("supplierFax");
		String supplierAddress=request.getParameter("supplierAddress");
		Supplier p =new Supplier();
		p.setSupplierId(Integer.parseInt(supplierIdNew));
		p.setSupplierName(supplierName);
		p.setSupplierInfo(supplierInfo);
		p.setSupplierAtten(supplierAtten);
		if(supplierTel!=null&&!supplierTel.equals("")){
		p.setSupplierTel(Long.parseLong(supplierTel));
		}
		if(supplierFax!=null&&!supplierFax.equals("")){
		p.setSupplierFax(Long.parseLong(supplierFax));
		}
		p.setSupplierAddress(supplierAddress);
		SupplierBiz pb =new SupplierBiz();
		if(supplierIdOld==null||supplierIdOld.equals("")){
			pb.addSupplier(p);
		}else{
			pb.updateSupplier(supplierIdOld,p);
		}
		response.sendRedirect("SupplierMgrServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
