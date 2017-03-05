<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
</head>
<body class="frame-bd">
<ul class="left-menu">
    <% if(session.getAttribute("userRole").equals(0)){ %>
    <li><a href="BillMgrServlet" target="mainFrame"><img src="../images/btn_bill.gif" /></a></li>
    <li><a href="UserOperateServlet?userId=<%=session.getAttribute("userId") %>" target="mainFrame"><img src="../images/btn_users.gif" /></a></li>
	<li><a href="LogoutServlet" onClick="javaScript:alert('用户已退出')"><img src="../images/btn_exit.gif" /></a></li>
    <% }else{ %>
	<li><a href="BillMgrServlet" target="mainFrame"><img src="../images/btn_bill.gif" /></a></li>
	<li><a href="SupplierMgrServlet" target="mainFrame"><img src="../images/btn_suppliers.gif" /></a></li>
	<li><a href="UserMgrServlet" target="mainFrame"><img src="../images/btn_users.gif" /></a></li>
	<li><a href="LogoutServlet" onClick="javaScript:alert('用户已退出')"><img src="../images/btn_exit.gif" /></a></li>
	<% } %>
</ul>
</body>
</html>