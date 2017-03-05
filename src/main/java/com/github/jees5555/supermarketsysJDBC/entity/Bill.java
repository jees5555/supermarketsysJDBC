package com.github.jees5555.supermarketsysJDBC.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Bill {
private int billId;
private String productName;
private int productNum;
private int billMoney;
private int payStatus;
private int supplierId;
private String supplierName;
private String productInfo;
private Date billTime;
public int getBillId() {
	return billId;
}
public void setBillId(int billId) {
	this.billId = billId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public int getProductNum() {
	return productNum;
}
public void setProductNum(int productNum) {
	this.productNum = productNum;
}
public int getBillMoney() {
	return billMoney;
}
public void setBillMoney(int billMoney) {
	this.billMoney = billMoney;
}
public int getPayStatus() {
	return payStatus;
}
public void setPayStatus(int payStatus) {
	this.payStatus = payStatus;
}
public int getSupplierId() {
	return supplierId;
}
public void setSupplierId(int supplierId) {
	this.supplierId = supplierId;
}
public String getSupplierName() {
	return supplierName;
}
public void setSupplierName(String supplierName) {
	this.supplierName = supplierName;
}
public String getProductInfo() {
	return productInfo;
}
public void setProductInfo(String productInfo) {
	this.productInfo = productInfo;
}
public Date getBillTime() {
	return billTime;
}
public void setBillTime(Date billTime) {
	this.billTime = billTime;
}
public String getFormatBillTime(){
	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String formatBillTime=sdf.format(this.billTime);
	return formatBillTime;
}

}
