<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		document.getElementById("aa").innerHTML="请输入供应商编号";
		pass=false;
	}else{
		document.getElementById("aa").innerHTML="";
	}
	if(document.getElementById("b").value==""){
		document.getElementById("bb").innerHTML="请输入供应商名称";
		pass=false;
	}else{
		document.getElementById("bb").innerHTML="";
	}
	if(pass){
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = checkbillid;
		xmlhttp.open("post", "CheckSupplierIdServlet", true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("supplierId="+document.getElementById("a").value);
 }
}
function checkbillid() {
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		var data = xmlhttp.responseText.trim();
		if(data=="true"){
			    if(document.getElementById("a").value=="<%=request.getAttribute("supplierId") %>"){
			    	var con=confirm("确认修改吗？");
			    	if(con){
			    	alert("修改成功");
			    	document.getElementById("form1").submit();
			    	}
			    }else{
			    	document.getElementById("aa").innerHTML="账单编号已存在";
			    }
			}else{
				if(data=="false"){
					alert("添加成功");
				document.getElementById("form1").submit();
				}else{
					document.getElementById("aa").innerHTML="数据库错误";
				}
			}
		}
	
}
function del(id) {
	var con=confirm("确认删除id为"+id+"的供应商吗？");
	if(con){
		alert("删除成功");
		location.href("SupplierDeleteServlet?supplierId="+id);
	}
}
</script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">供应商管理&gt;&gt;</div>
	</div>
	<form id="form1" name="form1" method="post" action="SupplierAddOrSaveServlet" onsubmit="return checkit();">
		<input name="supplierIdOld" value="<%=request.getAttribute("supplierId") %>" type="hidden" />
		<div class="content">
		<font color="red"></font>
			<table class="box" >
			<tbody><tr>
					<td class="field">供应商编号：</td>
					<td><input name="supplierIdNew" id="a" class="text" type="text" value="<%=request.getAttribute("supplierId") %>"/> 
					<font color="red">*</font><font id="aa" color="red"></font></td>
				</tr>
				<tr>
					<td class="field">供应商名称：</td>
					<td><input name="supplierName" id="b" class="text" type="text" value="<%=request.getAttribute("supplierName")%>"/> 
					<font color="red">*</font><font id="bb" color="red"></font></td>

				</tr>
			<tr>
					<td class="field">供应商描述：</td>
					<td><textarea name="supplierInfo" id="textarea" cols="45" rows="5"><%=request.getAttribute("supplierInfo")%></textarea></td>
				</tr>
				<tr>
					<td class="field">供应商联系人：</td>
					<td><input name="supplierAtten" id="textfield2" class="text" type="text" 
					value="<%=request.getAttribute("supplierAtten")%>"/></td>
				</tr>
				<tr>
					<td class="field">供应商电话：</td>
					<td><input name="supplierTel" id="textfield2" class="text" type="text" 
					value="<%=request.getAttribute("supplierTel").equals("0")?"":request.getAttribute("supplierTel") %>"/></td>
				</tr>
				<tr>
					<td class="field">供应商传真：</td>

					<td><input name="supplierFax" id="textfield2" class="text" type="text" 
					value="<%=request.getAttribute("supplierFax") %>"/></td>
				</tr>
				<tr>
					<td class="field">供应商地址：</td>
					<td><input name="supplierAddress" id="textfield2" class="text" type="text" value="<%=request.getAttribute("supplierAddress")%>"/></td>
				</tr>
			</tbody></table>
		</div>

		<div class="buttons">
			<input name="button"  value="提交" class="input-button" type="button" onclick="check();"/> 
			<% if(request.getAttribute("supplierId")!=null&&!request.getAttribute("supplierId").equals("")){ %>
			<input type="button" onclick="del(<%=request.getAttribute("supplierId")%>);" value="删除" class="input-button" />
			<%} %>
			<input name="button"  onclick="history.back();" value="返回" class="input-button" type="button" /> 
		</div>
	</form>
</div>
</body>
</html>
