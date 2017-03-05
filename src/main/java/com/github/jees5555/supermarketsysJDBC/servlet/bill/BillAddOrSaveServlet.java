package com.github.jees5555.supermarketsysJDBC.servlet.bill;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.jees5555.supermarketsysJDBC.biz.BillBiz;
import com.github.jees5555.supermarketsysJDBC.entity.Bill;

/**
 * Servlet implementation class BillAddOrSaveServlet
 */
@WebServlet("/view/BillAddOrSaveServlet")
public class BillAddOrSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillAddOrSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String billIdOld=request.getParameter("billIdOld");
		String billIdNew=request.getParameter("billIdNew");
		String billMoney=request.getParameter("billMoney");
		String productName=request.getParameter("productName");
		String productNum=request.getParameter("productNum");
		String productInfo=request.getParameter("productInfo");
		String supplierId=request.getParameter("supplierId");
		String payStatus=request.getParameter("payStatus");
		Bill b =new Bill();
		b.setBillId(Integer.parseInt(billIdNew));
		b.setBillMoney(Integer.parseInt(billMoney));
		b.setProductName(productName);
		b.setProductNum(Integer.parseInt(productNum));
		b.setProductInfo(productInfo);
		b.setSupplierId(Integer.parseInt(supplierId));
		b.setPayStatus(Integer.parseInt(payStatus));
		BillBiz bb =new BillBiz();
		if(billIdOld==null||billIdOld.equals("")){
			bb.addBill(b);
		}else{
			bb.updateBill(Integer.parseInt(billIdOld),b);
		}
		response.sendRedirect("BillMgrServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
