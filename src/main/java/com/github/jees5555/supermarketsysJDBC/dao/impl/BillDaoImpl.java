package com.github.jees5555.supermarketsysJDBC.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.jees5555.supermarketsysJDBC.dao.BillDao;
import com.github.jees5555.supermarketsysJDBC.entity.Bill;
import com.github.jees5555.supermarketsysJDBC.util.JDBCUtil;

public class BillDaoImpl implements BillDao{

	@Override
	public List<Bill> getObjectList(String productName, String payStatus) {
		Connection conn =JDBCUtil.getConnection();
		String sql="select bill.*,supplier.supplierName from bill LEFT JOIN supplier ON bill.supplierId=supplier.supplierId where 1=1 ";
		if(productName!=null&&!productName.equals("")){
			sql =sql +"and productName like '%"+productName+"%' ";
		}
		if(payStatus!=null&&!payStatus.equals("")){
			sql =sql +"and payStatus="+payStatus+" ";
		}
		sql=sql+"ORDER BY billId ASC";
		PreparedStatement ps =JDBCUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		try{
			List<Bill> list =new ArrayList<Bill>();
			rs=ps.executeQuery();
			while(rs.next()){
					Bill b =new Bill();
				 	b.setBillId(rs.getInt("billId"));
				 	b.setProductName(rs.getString("productName"));
				 	b.setProductNum(rs.getInt("productNum"));
				 	b.setBillMoney(rs.getInt("billMoney"));
				 	b.setPayStatus(rs.getInt("payStatus"));
				 	b.setSupplierId(rs.getInt("supplierId"));
				 	b.setSupplierName(rs.getString("supplierName"));
				 	b.setProductInfo(rs.getString("productInfo"));
				 	Timestamp ts =rs.getTimestamp("billTime");
				 	Date date =new Date(ts.getTime());
				 	b.setBillTime(date);
				 	list.add(b);
				
			   }
			return list;
			}catch( SQLException e){
				e.printStackTrace();
				return null;
			}finally{
				JDBCUtil.close(rs, ps, conn);
			}
	}
	@Override
	public Bill getObject(String billId) {
		Connection conn =JDBCUtil.getConnection();
		String sql="select * from bill where billId="+billId;
		PreparedStatement ps =JDBCUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		try{
			Bill b =new Bill();
			rs=ps.executeQuery();
			while(rs.next()){
				b.setBillId(rs.getInt("billId"));
			 	b.setProductName(rs.getString("productName"));
			 	b.setProductNum(rs.getInt("productNum"));
			 	b.setBillMoney(rs.getInt("billMoney"));
			 	b.setPayStatus(rs.getInt("payStatus"));
			 	b.setSupplierId(rs.getInt("supplierId"));
			 	b.setProductInfo(rs.getString("productInfo"));
			 	Timestamp ts =rs.getTimestamp("billTime");
			 	Date date =new Date(ts.getTime());
			 	b.setBillTime(date);	
			}
		return b;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally {
			JDBCUtil.close(rs, ps, conn);
		}
		
	}
	@Override
	public String isObjectExistById(String billId) {
		Connection conn =JDBCUtil.getConnection();
		String sql="select count(*) from bill where billId="+billId;
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
	public void addObject(Bill b) {
		Connection conn =JDBCUtil.getConnection();
		String sql="insert into bill (billId,productName,productNum,billMoney,"
				+ "payStatus,supplierId,productInfo,billTime) "
				+ "values(?,?,?,?,?,?,?,now())";
		PreparedStatement ps =JDBCUtil.getPreparedStatement(conn, sql);
		try{
			ps.setInt(1, b.getBillId());
			ps.setString(2, b.getProductName());
			ps.setInt(3, b.getProductNum());
			ps.setInt(4, b.getBillMoney());
			ps.setInt(5, b.getPayStatus());
			ps.setInt(6, b.getSupplierId());
			ps.setString(7, b.getProductInfo());
			ps.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(ps, conn);
		}
		
	}
    
	@Override
	public void updateObject(String billId, Bill b) {
		Connection conn =JDBCUtil.getConnection();
		String sql="update bill set billId=?,productName=?,productNum=?,billMoney=?,"
				+ "payStatus=?,supplierId=?,productInfo=? where billId=?";
		PreparedStatement ps =JDBCUtil.getPreparedStatement(conn, sql);
		try{
			ps.setInt(1, b.getBillId());
			ps.setString(2, b.getProductName());
			ps.setInt(3, b.getProductNum());
			ps.setInt(4, b.getBillMoney());
			ps.setInt(5, b.getPayStatus());
			ps.setInt(6, b.getSupplierId());
			ps.setString(7, b.getProductInfo());
			ps.setString(8, billId);
			ps.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(ps, conn);
		}
		
	}
	
	@Override
	public void deleteObject(String billId) {
		Connection conn =JDBCUtil.getConnection();
		String sql="delete from bill where billId="+billId;
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
