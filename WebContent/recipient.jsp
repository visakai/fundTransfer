<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Visa Direct</title>

<link href="${pageContext.request.contextPath}/css/jquery-ui.css"
	rel="stylesheet" />
	
<link href="${pageContext.request.contextPath}/css/transferApp.css"
	rel="stylesheet" />

<script src="${pageContext.request.contextPath}/jquery/jquery.js"
	type="text/javascript"></script>
<script
		src="${pageContext.request.contextPath}/jquery/jquery-ui.min.js"
		type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jquery/validations.js"
	type="text/javascript"></script>
</head>
<body link="#FFFF99" vlink="#FFFF99" alink="#FFFF99">
	<div id="header" style="text-align: center">
		</br>
		<h2>Domestic Funds Transfer</h2>
		</br> <font size="2"> </font>
	</div>	
	<form id="recipientForm" name="recipientForm" method="post" action="">
	</br>
		<h5>
						<font size="3"> The easiest way to transfer money to a Visa
							card </font>
						<h5>
				</br> </br>
		
					<font size="2">
					Step 2 of 3- Enter Recipient's Visa Card Number:
					<font color="red">*</font></font>
					</h5>
					<div style="float: left;margin-left:25px" >
  					<table border="0" width="100%"> 
						<th align="center">		
							<tr>
								<td>
						<p style = "border:1px solid black; padding:10px 10px;font-size:10pt;">
								<b>Simple steps to transfer money to a Visa card</b></br></br>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Step 1: Enter Sender Details</br></br>
								<img src="images/arrow.png" alt="Mountain View" style="width:20px;height:18px">&nbsp;<mark style = "background-color: #3385FF;color: white;">Step 2: Enter Recipient's Visa Card Number</mark></br></br>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Step 3: Enter the Amount and transfer the money!</b></p></br>
							</td>	
							</tr>
					</table>
					</div>
						
<div style="float: left">
  					<table border="0" width="100%"> 
							
							<tr>
								<td>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;								
							&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>	
							</tr>
					</table>
					</div>
						<table border="0" align="left">
			<tr>
				<td>
				
				</td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td align="left"><input type="text" size="19" name="recipientCardNumber" id="recipientCardNumber" value="4957030005709912"/><div class="myErrors"></div></td>				
			</tr>
			<tr>
				<td></td>
			</tr>
		
			<tr>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add" id="add"
					style="height: 40px; width: 70px; background-color: #3385FF; color: white; font-family: Arial, Times, Sans-serif">
					</input> <input type="reset" value="Clear" id="clearRecp"
							style="height: 40px; width: 70px; background-color: #3385FF; color: white; font-family: Arial, Times, Sans-serif">
						</input><input type="button" value="Previous" id="prev"
					onclick="window.location='sender.jsp'"
					style="height: 40px; width: 70px; background-color: #3385FF; color: white; font-family: Arial, Times, Sans-serif">
					</input> <input type="button" value="Next" id="next"
					onclick="window.location='transfer.jsp'"
					style="height: 40px; width: 70px; background-color: #3385FF; color: white; font-family: Arial, Times, Sans-serif">
					</input></td><tr><td>&nbsp;</td></tr>
					<tr>
								<td style="font-size:10pt;"><b>Show Request Response:</b> <input type="checkbox"
									id="cbxShowHide" name="cbxShowHide" value="request"
									style="cursor: pointer;" title="show Request and Response";></td>
					</tr>
			</tr>


		</table>
		
			</form>
				<br></br>
			
		<div id="divshowResponse" style="display: none; margin-left: 200px">
		<table border="0" width="100%" align="center"> 
			<th align="left">X-Pay-Token:			
			<tr>
				<td width="50%"><textarea rows="2" cols="90" id="requestACTLHeader"
						style="resize: none; scroll: true;"></textarea></td><td width="50%"></td>		
			</tr>
		</table>
		<table border="0" width="100%" align="center">
			<th>Request(Account Lookup):
			<th>Response(Account Lookup):
			<tr>
				<td><textarea rows="20" cols="90" id="request"
						style="resize: none; scroll: true;"></textarea></td>
				<td> <textarea rows="20" cols="90" id="response"
						style="resize: none; scroll: true;"></textarea></td>
			</tr>
		</table>
	</div>
</body>
</html>