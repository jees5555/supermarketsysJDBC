<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,com.github.jees5555.supermarketsysJDBC.entity.*"
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">	
<html>
<head>
<link type="text/css" rel="stylesheet" href="../css/style.css">
<script type="text/javascript">
	
</script>
</head>
<body>
	<div class="menu">
	<table><tbody>
		<tr><td><form method="post" action="UserMgrServlet">
			用户名称：<input name="userName" class="input-text" type="text" value="<%=request.getAttribute("userName") %>">
			&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="submit" name="submit" value="查询" class="button" />
		</form></td></tr>
		</tbody></table>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input value="添加数据" class="input-button"
				onclick="window.location='UserOperateServlet'" type="button"></em>
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
				<% List<User>list=(List<User>)request.getAttribute("userList"); %>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
						<td width="80"><div class="STYLE1" align="center">用户名称</div></td>
						<td width="100"><div class="STYLE1" align="center">性别</div></td>
						<td width="100"><div class="STYLE1" align="center">年龄</div></td>
						<td width="150"><div class="STYLE1" align="center">电话</div></td>
						<td width="150"><div class="STYLE1" align="center">地址</div></td>
						<td width="150"><div class="STYLE1" align="center">权限</div></td>
					</tr>
                     <% for(int i=0;i<list.size();i++){ %>
                     <% User u =list.get(i); %>
					<tr>
						<td height="23"><span class="STYLE1"><%=u.getUserId() %></span></td>
						<td><span class="STYLE1"><a href="UserOperateServlet?userId=<%=u.getUserId() %>"><%=u.getUserName() %></a></span></td>
						<td><span class="STYLE1"><%=u.getUserSex()==0?"女":"男" %></span></td>
						<td><span class="STYLE1"><%=u.getUserAge()==0?"":u.getUserAge() %></span></td>
						<td><span class="STYLE1"><%=u.getUserTel()==0?"":u.getUserTel() %></span></td>
						<td><span class="STYLE1"><%=u.getUserAddress() %></span></td>
						<td><span class="STYLE1">
						<% if(u.getUserRole()==0){ %>
						普通用户
						<% }else if(u.getUserRole()==1){ %>
						经理
						<%}else{ %>
						管理员
						<% } %>
						 </span></td>

					</tr>
					<% } %>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>