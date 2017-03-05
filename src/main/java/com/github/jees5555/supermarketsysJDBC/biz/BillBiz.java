package com.github.jees5555.supermarketsysJDBC.biz;

import java.util.List;

import com.github.jees5555.supermarketsysJDBC.dao.BillDao;
import com.github.jees5555.supermarketsysJDBC.dao.impl.BillDaoImpl;
import com.github.jees5555.supermarketsysJDBC.entity.Bill;

public class BillBiz {

	public List<Bill> getBillList(String productName, String payStatus) {
		BillDao bd =new BillDaoImpl();
		return bd.getObjectList(productName,payStatus);
		
	}

	public Bill getBill(String billId) {
		BillDao bd =new BillDaoImpl();
		return bd.getObject(billId);
	}

	public String isBillExist(String billId) {
		BillDao bd =new BillDaoImpl();
		return bd.isObjectExistById(billId);
		
	}

	public void addBill(Bill b) {
		BillDao bd =new BillDaoImpl();
		bd.addObject(b);
		
	}

	public void updateBill(int billIdOld, Bill b) {
		BillDao bd =new BillDaoImpl();
		bd.updateObject(billIdOld+"",b);
		
	}

	public void deleteBill(String billId) {
		BillDao bd =new BillDaoImpl();
		bd.deleteObject(billId);
		
	}

}
