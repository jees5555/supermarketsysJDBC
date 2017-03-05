package com.github.jees5555.supermarketsysJDBC.biz;

import java.util.List;

import com.github.jees5555.supermarketsysJDBC.dao.impl.SupplierDaoImpl;
import com.github.jees5555.supermarketsysJDBC.entity.Supplier;

public class SupplierBiz {

	public List<Supplier> getSupplierList(String supplierName, String supplierInfo) {
		SupplierDaoImpl pd =new SupplierDaoImpl();
		return pd.getObjectList(supplierName,supplierInfo);
	}

	public Supplier getSupplier(String supplierId) {
		SupplierDaoImpl pd =new SupplierDaoImpl();
		return pd.getObject(supplierId);
	}

	public String isSupplierExist(String supplierId) {
		SupplierDaoImpl pd =new SupplierDaoImpl();
		return pd.isObjectExistById(supplierId);
	}

	public void addSupplier(Supplier p) {
		SupplierDaoImpl pd =new SupplierDaoImpl();
		pd.addObject(p);
		
	}

	public void updateSupplier(String supplierOldId, Supplier p) {
		SupplierDaoImpl pd =new SupplierDaoImpl();
		pd.updateObject(supplierOldId, p);
		
	}

	public void deleteSupplier(String supplierId) {
		SupplierDaoImpl pd =new SupplierDaoImpl();
		pd.deleteObject(supplierId);
		
	}

}
