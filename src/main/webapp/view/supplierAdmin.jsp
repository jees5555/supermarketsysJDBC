<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.github.jees5555.supermarketsysJDBC.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">	
<html>
<head>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript">
	
</script>
</head>
<body>
	<div class="menu">
		<table><tbody>
		<tr><td><form method="post" action="SupplierMgrServlet">
							<input name="flag" value="search" type="hidden" /> 供应商名称：<input
								name="supplierName"
								value="<%=request.getAttribute("supplierName")%>"
								class="input-text" type="text" /> &nbsp;&nbsp;&nbsp;&nbsp;
							供应商描述：<input name="supplierInfo"
								value="<%=request.getAttribute("supplierInfo")%>"
								class="input-text" type="text" />&nbsp;&nbsp;&nbsp;&nbsp; <input
								type="submit" name="submit" value="组合查询" class="button" />
						</form></td></tr>
			</tbody></table>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input value="添加数据" class="input-button"
				onclick="window.location='SupplierOperateServlet'" type="button" /></em>
			<div class="title">供应商管理&gt;&gt;</div>
		</div>

		<div class="content">
			<table class="list">
				<%
					List<Supplier> list = (List<Supplier>) request.getAttribute("supplierList");
				%>
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
						<td width="80"><div class="STYLE1" align="center">供应商名称</div></td>
						<td width="100"><div class="STYLE1" align="center">供应商描述</div></td>
						<td width="100"><div class="STYLE1" align="center">联系人</div></td>
						<td width="100"><div class="STYLE1" align="center">电话</div></td>
						<td width="100"><div class="STYLE1" align="center">地址</div></td>
					</tr>
					<% for (int i = 0; i < list.size(); i++) {%>
					<% Supplier p = list.get(i); %>
					<tr>
						<td height="23"><span class="STYLE1"><%=p.getSupplierId()%></span></td>
						<td><span class="STYLE1"><a
							href="SupplierOperateServlet?supplierId=<%=p.getSupplierId()%>"><%=p.getSupplierName()%></a></span></td>
						<td><span class="STYLE1"><%=p.getSupplierInfo()%></span></td>
						<td><span class="STYLE1"><%=p.getSupplierAtten()%></span></td>
						<td><span class="STYLE1"><%=p.getSupplierTel() == 0 ? "" : p.getSupplierTel()%></span></td>
						<td><span class="STYLE1"><%=p.getSupplierAddress()%></span></td>
					</tr>
					<% } %>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>