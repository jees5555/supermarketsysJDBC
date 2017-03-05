package com.github.jees5555.supermarketsysJDBC.servlet.bill;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.jees5555.supermarketsysJDBC.biz.BillBiz;
import com.github.jees5555.supermarketsysJDBC.biz.SupplierBiz;
import com.github.jees5555.supermarketsysJDBC.entity.Bill;
import com.github.jees5555.supermarketsysJDBC.entity.Supplier;

/**
 * Servlet implementation class BillOperateServlet
 */
@WebServlet("/view/BillOperateServlet")
public class BillOperateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillOperateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String billId=request.getParameter("billId");
		SupplierBiz pb =new SupplierBiz();
		List<Supplier> list=pb.getSupplierList(null,null);
		BillBiz bb =new BillBiz();
		request.setAttribute("supplierList", list);
		if(billId==null){
			request.setAttribute("billId", "");
			request.setAttribute("billMoney","");
			request.setAttribute("productName", "");
			request.setAttribute("productNum", "");
			request.setAttribute("productInfo", "");
			request.setAttribute("supplierId", "");
			request.setAttribute("payStatus", "0");
		}else{
			Bill b =bb.getBill(billId);
			request.setAttribute("billId", b.getBillId());
			request.setAttribute("billMoney", b.getBillMoney());
			request.setAttribute("productName", b.getProductName());
			request.setAttribute("productNum", b.getProductNum());
			request.setAttribute("productInfo", b.getProductInfo());
			request.setAttribute("supplierId", b.getSupplierId());
			request.setAttribute("payStatus", b.getPayStatus()+"");
		}
		request.getRequestDispatcher("billAdd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
