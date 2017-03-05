<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,com.github.jees5555.supermarketsysJDBC.entity.*"
    %>
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
	<tr><td><form method="get" action="BillMgrServlet">
			商品名称：<input type="text" name="productName"
				value="<%=request.getAttribute("productName") %>" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
			是否付款：<select name="payStatus">
				<option value=""
					<%=request.getAttribute("payStatus").equals("")?"selected":"" %>>请选择</option>
				<option value="1"
					<%=request.getAttribute("payStatus").equals("1")?"selected":"" %>>已付款</option>
				<option value="0"
					<%=request.getAttribute("payStatus").equals("0")?"selected":"" %>>未付款</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" name="submit"
				value="组合查询" class="button" />
		</form></td></tr>
		</tbody></table>
	</div>
	<div class="main">
	<div class="optitle clearfix">
		<em><input type="button" name="button" value="添加数据" class="input-button" 
		onclick="location.href='BillOperateServlet'" /></em>
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<div class="content">
		<table class="list">
		<tbody>
		<% List<Bill>list=(List<Bill>)request.getAttribute("billList"); %>
			<tr>
				<td height="29"><div class="STYLE1" align="center">账单编号</div></td>
				<td><div class="STYLE1" align="center">商品名称</div></td>
				<td><div class="STYLE1" align="center">商品数量</div></td>
				<td><div class="STYLE1" align="center">交易金额</div></td>
				<td><div class="STYLE1" align="center">是否付款</div></td>
				<td><div class="STYLE1" align="center">供应商名称</div></td>
				<td><div class="STYLE1" align="center">商品描述</div></td>
				<td><div class="STYLE1" align="center">账单时间</div></td>
			</tr>
			<% for(int i=0;i<list.size();i++){ %>
			<% Bill b =list.get(i); %>
			<tr>
				<td height="23"><span class="STYLE1"><%=b.getBillId() %></span></td>
				<td><span class="STYLE1"><a href="BillOperateServlet?billId=<%=b.getBillId() %>"><%=b.getProductName() %></a></span></td>
				<td><span class="STYLE1"><%=b.getProductNum() %></span></td>
				<td><span class="STYLE1"><%=b.getBillMoney() %></span></td>
				<td><span class="STYLE1"><%=b.getPayStatus()==0?"未付款":"已付款" %></span></td>
				<td><span class="STYLE1"><%=b.getSupplierName() %></span></td>
				<td><span class="STYLE1"><%=b.getProductInfo() %></span></td>
				<td><span class="STYLE1"><%=b.getFormatBillTime() %></span></td>
			</tr>
			<% } %>
			</tbody>
		</table>
	</div>
  </div>
</body>
</html>
