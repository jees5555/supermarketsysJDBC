<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,com.github.jees5555.supermarketsysJDBC.entity.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript">
var xmlhttp;
function check() {
	var pass=true;
	if(document.getElementById("a").value==""){
		document.getElementById("aa").innerHTML="请输入账单编号";
		pass=false;
	}else{
		document.getElementById("aa").innerHTML="";
	}
	if(document.getElementById("b").value==""){
		document.getElementById("bb").innerHTML="请输入交易金额";
		pass=false;
	}else{
		document.getElementById("bb").innerHTML="";
	}
	if(document.getElementById("c").value==""){
		document.getElementById("cc").innerHTML="请输入商品名称";
		pass=false;
	}else{
		document.getElementById("cc").innerHTML="";
	}
	if(document.getElementById("d").value==""){
		document.getElementById("dd").innerHTML="请输入交易数量";
		pass=false;
	}else{
		document.getElementById("dd").innerHTML="";
	}
	if(document.getElementById("e").value==""){
		document.getElementById("ee").innerHTML="请选择供应商";
		pass=false;
	}else{
		document.getElementById("ee").innerHTML="";
	}
	if(pass){
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = checkbillid;
		xmlhttp.open("post", "CheckBillIdServlet", true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("billId="+document.getElementById("a").value);
	}
		
	}
function checkbillid() {
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		var data = xmlhttp.responseText.trim();
		if(data=="true"){
			    if(document.getElementById("a").value=="<%=request.getAttribute("billId") %>"){
			    	var con=confirm("确认修改吗？");
			    	if(con){
			    	alert("修改成功");
			    	document.getElementById("billform").submit();
			    	}
			    }else{
			    	document.getElementById("aa").innerHTML="账单编号已存在";
			    }
			}else{
				if(data=="false"){
					alert("添加成功");
				document.getElementById("billform").submit();
				}else{
					document.getElementById("aa").innerHTML="数据库错误";
				}
			}
		}
	
}
function del(id) {
	var con=confirm("确认删除id为"+id+"的账单吗？");
	if(con){
		alert("删除成功");
		location.href("BillDeleteServlet?billId="+id);
	}
}
</script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<em><input type="button" name="button" value="添加数据" class="input-button" onclick="location.href='modify.html'" /></em>
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<form id="billform" method="post" action="BillAddOrSaveServlet">
	<input  type="hidden" name="billIdOld" value="<%=request.getAttribute("billId") %>" />
		<div class="content">
			<table class="box">
				<tr>
					<td class="field">账单编号：</td>
					<td><input id="a" type="text" name="billIdNew" class="text" value="<%=request.getAttribute("billId") %>"/>
					 <font color="red">*</font><font id="aa" color="red"></font></td>
				</tr>
				<tr>
					<td class="field">交易金额：</td>
					<td><input id="b" type="text" name="billMoney" class="text" value="<%=request.getAttribute("billMoney") %>" /> 
					<font color="red">*</font><font id="bb" color="red"></font></td>
				</tr>
				<tr>
					<td class="field">商品名称：</td>
					<td><input id="c" type="text" name="productName" class="text" value="<%=request.getAttribute("productName") %>"/> 
					<font color="red">*</font><font id="cc" color="red"></font></td>
				</tr>
				<tr>
					<td class="field">交易数量：</td>
					<td><input id="d" type="text" name="productNum" class="text" value="<%=request.getAttribute("productNum") %>"/> 
					<font color="red">*</font><font id="dd" color="red"></font></td>
				</tr>
				<tr>
					<td class="field">商品描述：</td>
					<td><textarea name="productInfo"><%=request.getAttribute("productInfo") %></textarea></td>
				</tr>
				<tr>
					<td class="field">所属供应商：</td>
					<% List<Supplier>list=(List<Supplier>)request.getAttribute("supplierList"); %>
					<td><select name="supplierId" id="e">
					    <option value="">请选择</option>
					    <% for(int i=0;i<list.size();i++){ %>
					    <% Supplier p= list.get(i); %>
						<option value="<%=p.getSupplierId() %>" <%=request.getAttribute("supplierId").equals(p.getSupplierId())?"selected":"" %>><%=p.getSupplierName() %></option>
						<%} %>
					</select>
					<font color="red">*</font><font id="ee" color="red"></font></td>
				</tr>
				<tr>
					<td class="field">是否付款：</td>
					<td><select name="payStatus">
					    <option value="0" <%=request.getAttribute("payStatus").equals("0")?"selected":"" %>>否</option>
						<option value="1" <%=request.getAttribute("payStatus").equals("1")?"selected":"" %>>是</option>
					</select></td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="button" onclick="check();" value="提交" class="input-button" />
			<% if(request.getAttribute("billId")!=null&&!request.getAttribute("billId").equals("")){ %>
			<input type="button" onclick="del(<%=request.getAttribute("billId")%>);" value="删除" class="input-button" />
			<%} %>
			<input type="button" value="返回" class="input-button" onclick="history.back();" />
		</div>
	</form>
</div>
</body>
</html>