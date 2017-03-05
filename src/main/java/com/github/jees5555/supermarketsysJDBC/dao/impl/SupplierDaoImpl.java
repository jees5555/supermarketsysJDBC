package com.github.jees5555.supermarketsysJDBC.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.github.jees5555.supermarketsysJDBC.dao.SupplierDao;
import com.github.jees5555.supermarketsysJDBC.entity.Supplier;
import com.github.jees5555.supermarketsysJDBC.util.JDBCUtil;

public class SupplierDaoImpl implements SupplierDao{
    
	@Override
	public List<Supplier> getObjectList(String supplierName, String supplierInfo) {
		Connection conn =JDBCUtil.getConnection();
		String sql="select * from supplier where 1=1 ";
		if(supplierName!=null&&!supplierName.equals("")){
			sql =sql +"and supplierName like '%"+supplierName+"%' ";
		}
		if(supplierInfo!=null&&!supplierInfo.equals("")){
			sql =sql +"and supplierInfo like '%"+supplierInfo+"%' ";
		}
		sql=sql+"ORDER BY supplierId ASC";
		PreparedStatement ps =JDBCUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		try{
			List<Supplier>list=new ArrayList<Supplier>();
			rs=ps.executeQuery();
			while(rs.next()){
				
					Supplier p=new Supplier();
					p.setSupplierId(rs.getInt("supplierId"));
					p.setSupplierName(rs.getString("supplierName"));
					p.setSupplierInfo(rs.getString("supplierInfo"));
					p.setSupplierAtten(rs.getString("supplierAtten"));
					p.setSupplierTel(rs.getLong("supplierTel"));
					p.setSupplierAddress(rs.getString("supplierAddress"));
					list.add(p);
				
		   }
		return list;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
    @Override
	public Supplier getObject(String supplierId) {
		Connection conn =JDBCUtil.getConnection();
		String sql="select * from supplier where supplierId="+supplierId;
		PreparedStatement ps =JDBCUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		try{
			Supplier p =new Supplier();
			rs=ps.executeQuery();
			while(rs.next()){
				p.setSupplierId(rs.getInt("supplierId"));	
				p.setSupplierName(rs.getString("supplierName"));
				p.setSupplierInfo(rs.getString("supplierInfo"));
				p.setSupplierAtten(rs.getString("supplierAtten"));
				p.setSupplierTel(rs.getLong("supplierTel"));
				p.setSupplierFax(rs.getLong("supplierFax"));
				p.setSupplierAddress(rs.getString("supplierAddress"));
			}
		return p;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally {
			JDBCUtil.close(rs, ps, conn);
		}
	}
    
    @Override
	public String isObjectExistById(String supplierId) {
		Connection conn =JDBCUtil.getConnection();
		String sql="select count(*) from supplier where supplierId="+supplierId;
		PreparedStatement ps =JDBCUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		try{
			String msg =null;
			rs=ps.executeQuery();
			while(rs.next()){
				if(rs.getInt("count(*)")==0){
					msg="false";
				}else{
					msg="true";
				}
			}
		return msg;
		}catch(SQLException e){
			e.printStackTrace();
			return "error";
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
	}

    @Override
	public void addObject(Supplier p) {
		Connection conn =JDBCUtil.getConnection();
		String sql="insert into supplier (supplierId,supplierName,supplierInfo,supplierAtten,"
				+ "supplierTel,supplierFax,supplierAddress) "
				+ "values(?,?,?,?,?,?,?)";
		PreparedStatement ps =JDBCUtil.getPreparedStatement(conn, sql);
		try{
			ps.setInt(1, p.getSupplierId());
			ps.setString(2, p.getSupplierName());
			ps.setString(3, p.getSupplierInfo());
			ps.setString(4, p.getSupplierAtten());
			if(p.getSupplierTel()!=0){
				ps.setLong(5, p.getSupplierTel());
			}else{
				ps.setString(5, null);
			}
			if(p.getSupplierFax()!=0){
				ps.setLong(6, p.getSupplierFax());
			}else{
				ps.setString(6, null);
			}
			ps.setString(7, p.getSupplierAddress());
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(ps, conn);
		}
		
	}

    @Override
	public void updateObject(String supplierOldId, Supplier p) {
		Connection conn =JDBCUtil.getConnection();
		String sql="update supplier set supplierId=?,supplierName=?,supplierInfo=?,supplierAtten=?,"
				+ "supplierTel=?,supplierFax=?,supplierAddress=? where supplierId=?";
		PreparedStatement ps =JDBCUtil.getPreparedStatement(conn, sql);
		try{
			ps.setInt(1, p.getSupplierId());
			ps.setString(2, p.getSupplierName());
			ps.setString(3, p.getSupplierInfo());
			ps.setString(4, p.getSupplierAtten());
			if(p.getSupplierTel()!=0){
				ps.setLong(5, p.getSupplierTel());
			}else{
				ps.setString(5, null);
			}
			if(p.getSupplierFax()!=0){
				ps.setLong(6, p.getSupplierFax());
			}else{
				ps.setString(6, null);
			}
			ps.setString(7, p.getSupplierAddress());
			ps.setString(8, supplierOldId);
			ps.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(ps, conn);
		}
		
	}

    @Override
	public void deleteObject(String supplierId) {
		Connection conn =JDBCUtil.getConnection();
		String sql="delete from supplier where supplierId="+supplierId;
		PreparedStatement ps =JDBCUtil.getPreparedStatement(conn, sql);
		try{
			ps.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(ps, conn);
		}
		
	}

}
