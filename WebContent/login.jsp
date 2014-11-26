<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">

<script src="${pageContext.request.contextPath}/jquery/jquery.js"
	type="text/javascript"></script>
<script
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jquery/validations.js"
	type="text/javascript"></script>

<title>Visa Direct</title>
<link href="${pageContext.request.contextPath}/css/transferApp.css" type="text/css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/jquery-ui.css"
	rel="stylesheet" />
	

</head>

<body link="#FFFF99" vlink="#FFFF99" alink="#FFFF99">

	<div id="header" style="align: center; background-color:#011f4b;">
</br>
		<h2 style="font-family: Source Code Pro">Funds Transfer App-Triangle Corp.</h2>
				
				<font size="2" color="white" style="font-family: Source Code Pro"><center>The
				easiest way to transfer money to a Visa card</center></font>
				</br>
				<h4 style="margin-right:250px;margin-left:250px;background-color:#e8702a" color="#e8702a;"><font color="#e8702a">Test</font></h4>
	</div>
	</br>
	</br>
	</br>
	</br>
	</br>
	<form id="loginForm" name="loginForm" method="post" action=""
		style="margin-right:250px;margin-left:250px;">
		
	<table border="0" align="center" width="25%">
	<tr>
	<td colspan="2" align="center">
	<div id="invalid" style="display:none"><font color="red" family= "Source Code Pro" size="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Invalid Login, Please Try again!</font>
	</td>
	</tr>
	<tr>
	</tr>
	<tr>
	</tr>
	<tr>
	</tr>
	<tr>
	<td><font size="2" family= "Source Code Pro" >UserName: <font color="red">*</font></font></td>
	<td align="left"><font size="2" family= "Source Code Pro" ><input type="text" id="username" name="username" value=""/></font><div class="myErrors"></div></td>
	</tr>
	<tr>
	<td><font size="2" family= "Source Code Pro" >Password: <font color="red">*</font></font></td>
	<td align="left"><font size="2" family= "Source Code Pro" ><input type="password" id="password1" name="password1" value=""/></font><div class="myErrors"></div></td>
	</tr>
	<tr></tr><tr></tr>
	<tr>
	<td colspan="2" align="center"><input type="submit" value="Login" style="background-color: #e8702a; color: white; height: 30px; width: 60px; font-family: Arial, Times, Sans-serif"/></td>
	</tr>
	</table>
	
				
	</form>
	</body>
	</html>
