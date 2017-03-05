<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" >
var xmlhttp;

function check() {
	if(document.getElementById("x").value==""){
		addCheck();
	}else{
		updateCheck();
	}
}

function addCheck() {
	var pass=true;
	var passwordcheck=true;
	if(document.getElementById("a").value==""){
		document.getElementById("aa").innerHTML="请输入用户编号";
		pass=false;
	}else{
		document.getElementById("aa").innerHTML="";
	}
	if(document.getElementById("b").value==""){
		document.getElementById("bb").innerHTML="请输入用户名称";
		pass=false;
	}else{
		document.getElementById("bb").innerHTML="";
	}
	if(document.getElementById("c").value==""){
		document.getElementById("cc").innerHTML="请输入用户密码";
		passwordcheck=false;
		pass=false;
	}else{
		document.getElementById("cc").innerHTML="";
	}
	if(document.getElementById("d").value==""){
		document.getElementById("dd").innerHTML="请再次输入用户密码";
		passwordcheck=false;
		pass=false;
	}else{
		document.getElementById("dd").innerHTML="";
	}
	if(passwordcheck){
		if(document.getElementById("c").value!=document.getElementById("d").value){
			document.getElementById("dd").innerHTML="两次输入的密码不一致";
			pass=false;
		}else{
			document.getElementById("dd").innerHTML="";
		}
	}
	
	if(document.getElementById("e").value==""){
		document.getElementById("ee").innerHTML="请输入用户年龄";
		pass=false;
	}else{
		document.getElementById("ee").innerHTML="";
	}
	if(document.getElementById("f").value==""){
		document.getElementById("ff").innerHTML="请输入用户电话";
		pass=false;
	}else{
		document.getElementById("ff").innerHTML="";
	}
	if(pass){
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = checkuserid;
		xmlhttp.open("post", "CheckUserServlet", true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("userId="+document.getElementById("a").value+"&&userName="+document.getElementById("b").value);
	}
	
}
function updateCheck() {
	var pass=true;
	if(document.getElementById("a").value==""){
		document.getElementById("aa").innerHTML="请输入用户编号";
		pass=false;
	}else{
		document.getElementById("aa").innerHTML="";
	}
	if(document.getElementById("b").value==""){
		document.getElementById("bb").innerHTML="请输入用户名称";
		pass=false;
	}else{
		document.getElementById("bb").innerHTML="";
	}
	
	if(document.getElementById("e").value==""){
		document.getElementById("ee").innerHTML="请输入用户年龄";
		pass=false;
	}else{
		document.getElementById("ee").innerHTML="";
	}
	if(document.getElementById("f").value==""){
		document.getElementById("ff").innerHTML="请输入用户电话";
		pass=false;
	}else{
		document.getElementById("ff").innerHTML="";
	}
	if(pass){
		var con=confirm("确认修改吗？");
		if(con){
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = checkuserid;
		xmlhttp.open("post", "CheckUserServlet", true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("userId="+document.getElementById("a").value+"&userName="+document.getElementById("b").value);
	}
	}
}

function checkuserid() {
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		var data = xmlhttp.responseText.trim();
		if(data=="false"){
			if(document.getElementById("x").value==""){
			alert("添加成功");
			}else{
			alert("修改成功");
			}
		  document.getElementById("form1").submit();
            }else if(data=="true1"){
            	 if(document.getElementById("a").value=="<%=request.getAttribute("userId") %>"){
 			    	alert("修改成功");
 			    	document.getElementById("form1").submit();
 			    }else{
 			    	document.getElementById("aa").innerHTML="用户编号已存在";
 			    }
			}else if(data=="true2"){
				if(document.getElementById("b").value=="<%=request.getAttribute("userName") %>"){
			    	alert("修改成功");
			    	document.getElementById("form1").submit();
			    }else{
			    	document.getElementById("bb").innerHTML="用户名已存在";
			    }
			}else if(data=="true3"){
				if(document.getElementById("a").value=='<%=request.getAttribute("userId")%>'&&document.getElementById("b").value=='<%=request.getAttribute("userName") %>'){
					alert("修改成功");
			    	document.getElementById("form1").submit();
			    }else if(document.getElementById("a").value=='<%=request.getAttribute("userId")%>'&&document.getElementById("b").value!='<%=request.getAttribute("userName") %>'){
			    	document.getElementById("bb").innerHTML="用户名已存在";
			    }else if(document.getElementById("a").value!='<%=request.getAttribute("userId")%>'&&document.getElementById("b").value=='<%=request.getAttribute("userName") %>'){
			    	document.getElementById("aa").innerHTML="用户编号已存在";
			    }else{
			    	document.getElementById("aa").innerHTML="用户编号已存在";
			    	document.getElementById("bb").innerHTML="用户名已存在";
			    }
			}else{
			 document.getElementById("aa").innerHTML="数据库错误";
			}
			
            
		
		
		
		
		
	}
}
function del(id) {
	var con=confirm("确认删除id为"+id+"的用户吗？");
	if(con){
		alert("删除成功");
		location.href ="UserDeleteServlet?userId="+id;
	}
}

function updatePwd(id) {
		location.href ="UserPasswordOperateServlet?userId="+id;
	
}
</script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">用户管理&gt;&gt;</div>

	</div>
	<form id="form1" name="form1" method="post" action="UserAddOrSaveServlet" onsubmit="return checkit();">
		<input  id="x" type="hidden" name="userIdOld" value="<%=request.getAttribute("userId") %>"/>
		<div class="content">
			<table class="box">
			<tr>
					<td class="field">用户编号：</td>
					<td><input type="text" name="userIdNew" id="a" class="text" value="<%=request.getAttribute("userId") %>"/> 
					<font color="red">*</font><font id="aa" color="red"></font></td>

				</tr>
			<tr>
					<td class="field">用户名称：</td>
					<td><input type="text" name="userName" class="text" id="b" value="<%=request.getAttribute("userName") %>"/> 
					<font color="red">*</font><font id="bb" color="red"></font></td>
				</tr>
				<%if(request.getAttribute("userId")==null||request.getAttribute("userId").equals("")){%>
				<tr>
					<td class="field">用户密码：</td>

					<td><input type="password" name="userPassword" class="text" id="c" /> 
					<font color="red">*</font><font id="cc" color="red"></font></td>
				</tr>
			    <tr>
					<td class="field">确认密码：</td>
					<td><input type="password" name="userPassword1" class="text" id="d"/> 
					<font color="red">*</font><font id="dd" color="red"></font></td>
				</tr>
                <% } %>
				<tr>
					<td class="field">用户性别：</td>
			 <td>
				<select name="userSex" id="select">
                    <option value="0" <%=request.getAttribute("userSex").equals("0")?"selected":"" %>>女</option>
                    <option value="1" <%=request.getAttribute("userSex").equals("1")?"selected":"" %>>男</option>
               </select>
              </td>
				</tr>

				<tr>
					<td class="field">用户年龄：</td>
					<td><input type="text" name="userAge" class="text" id="e"
					 value="<%=request.getAttribute("userAge").equals("0")?"":request.getAttribute("userAge") %>"/> 
					<font color="red">*</font><font id="ee" color="red"></font></td>
				</tr>
				<tr>
					<td class="field">用户电话：</td>
					<td><input type="text" name="userTel" class="text" id="f" 
					value="<%=request.getAttribute("userTel").equals("0")?"":request.getAttribute("userTel") %>"/> 
					<font color="red">*</font><font id="ff" color="red"></font></td>

				</tr>
				<tr>
					<td class="field">用户地址：</td>
					<td><textarea name="userAddress" id="textarea" class="text" cols="45" rows="5"><%=request.getAttribute("userAddress") %></textarea>
					</td>
				</tr>
				<% if(!session.getAttribute("userRole").equals(0)){ %>
				<tr>
					<td class="field">用户权限：</td>

					<td><input type="radio" name="userRole" id="auth" value="0" <%=request.getAttribute("userRole").equals("0")?"checked":"" %>/>普通用户
					<input type="radio" name="userRole" id="auth" value="1" <%=request.getAttribute("userRole").equals("1")?"checked":"" %>/>经理
					<input type="radio" name="userRole" id="auth" value="2" <%=request.getAttribute("userRole").equals("2")?"checked":"" %>/>管理员
					</td>
				</tr>
				<% }else{ %>
				<input type="hidden"  name="userRole" id="auth" value="0" />
				<%} %>
			</table>
		</div>
		<div class="buttons">
			<input type="button" onclick="check();" value="提交" class="input-button"/>
			 <% if(request.getAttribute("userId")!=null&&!request.getAttribute("userId").equals("")){ %>
			 <input type="button" onclick="del(<%=request.getAttribute("userId")%>);" value="删除" class="input-button"/>
			 <input type="button" onclick="updatePwd(<%=request.getAttribute("userId")%>)" value="修改密码" class="input-button"/>
			 <% } %>
			 <input type="button" name="button" id="button" onclick="history.back();" value="返回" class="input-button"/> 
		</div>

	</form>
</div>
</body>
</html>
