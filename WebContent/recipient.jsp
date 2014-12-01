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

	<div id="header" style="align: center; background-color:#011f4b;">
</br>
		<h2 style="font-family: Source Code Pro">Funds Transfer App - Triangle Corp.</h2>
		
				
				<font size="2" color="white" style="font-family: Source Code Pro"><center>The
				easiest way to transfer money to a Visa card</center><div style="font-color: #011f4b; font-size: 10pt;font-family:Source Code Pro;float:right; margin-right:250px" >
         			<a id="admin" href='#'><font color="#e0cda7">Update Credentials</font></a></div></font>
				</br>
				<h4 style="margin-right:250px;margin-left:250px;background-color:#e8702a" color="#e8702a;"><font color="#e8702a">Test</font></h4>
	</div>
		<div id="adminConsole"  width="100%" title="Admin Console"
		style="font-size: 10pt; display: none";>
		<span id="ui-id-1" class="ui-dialog-title"></span>
		<form class="form" action="#" id="adminConsole">
			</br>
			<label><b>Api-Key:</b></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="text" id="apiKey"size="50" /></br>
			</br> <label><b>Shared Secret:</b></label>&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="text" id="sharedSecret" size="50"  /></br>
			</br> 
			<input type="button" id="adminsubmit" value="Submit" style="background-color: #e8702a; color: white; height: 30px; width: 60px; cursor: pointer;"/>&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="reset" value="Reset" id="clearAdmin" style="background-color: #e8702a; color: white; height: 30px; width: 60px; cursor: pointer;">
							</input> &nbsp;&nbsp;&nbsp;&nbsp;<input
							type="button" value="Close" id="closeWin" style="background-color: #e8702a; color: white; height: 30px; width: 60px; cursor: pointer;" >
							</input><br />
		</form>
</div>
	
</body>
<div id="div1">
	<form id="recipientForm" name="recipientForm" method="post" action="" style="background:#d2d4dc;margin-right:250px;margin-left:250px;">
	<br/><br/><br/>
	<table border="0" width="50%" align="center">			
			<tr>

				<td width="16.6%">								 		
				 		<a href="sender.jsp"><img src="images/bankIcon.png" style="width: 80px; height: 65px;"/></a>
				 </td>
				
					<!-- <td><img src="images/Blue_Arrow.png" alt="Mountain View"
					style="width: 40px; height: 20px;"></td> -->
					<td></td>
				<td width="16.6%"><a href="recipient.jsp"><img src="images/bankIcon-green.png" style="width: 80px; height: 65px;"/></a></td>
				
			</tr>
			<tr>
			<td width="16.6%" style="font-family: Source Code Pro"><b><font color="#011f4b" size="2px">Update Sender Account</font></b></td>
			<td></td>
			<td width="16.6%" style="font-family: Source Code Pro"><b><font color="#011f4b" size="2px">Manage Receivers 
							</font></b></td>
			</tr>
			
			<tr>
			
					<td width="16.6%" colspan="3" align="center"><a href="transfer.jsp"><img src="images/transfer.png" style="width: 130px; height: 130px;"/></a></td>
					<!-- <td><img src="images/Blue_Arrow.png" alt="Mountain View"
					style="width: 40px; height: 20px;"></td> -->
			</tr>
			
			<tr>
				
							<td></td>
				<td width="16.6%" style="font-family: Source Code Pro"><b><font color="#011f4b" size="4px">TRANSFER MONEY
							</font></b></td>
							<td></td>
				
			</tr>
		</table>
					<br>
			<font size="2" family = "Source Code Pro"> Step 2 of 3 - Enter Recipient's Visa Card Number</font>
	
<br>
		</br>
				
<table border="0" align="center" width="38%" style="border: 1px solid grey; ">	
			<tr>
			<td>&nbsp;</td>
			</tr>
			<tr>
			<td style="font-size: 10pt;margin-left:500px;font-family:Source Code Pro" width="20%" align="left" >&nbsp;&nbsp;&nbsp; Recipient Name: </td>
				<td align="left" width="20%"><input type="text" size="19" name="recipientName" id="recipientName" value=""/></td>				
			</tr>
			
			
			<tr>
			<td style="font-size: 10pt;font-family:Source Code Pro" width="25%" align="left">&nbsp;&nbsp;&nbsp; Recipient Card Number: <font color="red">*</font></td>
				<td align="left"><input type="text" size="19" name="recipientCardNumber" id="recipientCardNumber" value="<%=session.getAttribute( "recipientPAN" )==null?"":session.getAttribute( "recipientPAN" )%>"/><div class="myErrors"></div></td>				
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Add" id="add"
					style="height: 40px; width: 70px; background-color: #e8702a; color: white;font-family: Arial, Times, Sans-serif">
					</input>&nbsp;&nbsp;&nbsp; <input type="reset" value="Reset" id="clearRecp"
							style="height: 40px; width: 70px; background-color: #e8702a; color: white; font-family: Arial, Times, Sans-serif">
						</input>&nbsp;&nbsp;&nbsp;<input type="button" value="Next" id="next"
					onclick="window.location='transfer.jsp'"
					style="height: 40px; width: 70px; background-color: #e8702a; color: white;  font-family: Arial, Times, Sans-serif">
					</input></td><tr><td>&nbsp;</td></tr>
					
			</tr>


		</table>
		<br/>
		
 <div id="showMsg" style="display: none"></div>

		<table border="0" width="55%" align="center">
			
			<tr>
				<td style="font-size: 9pt;font-family:Source Code Pro">Under the hood: <input
					type="checkbox" id="cbxShowHide" name="cbxShowHide" value="request"
					style="cursor: pointer;" title="show Request and Response";></td>
			</tr>
		</table>
		<hr noshade size=3 width="100%">
		
			</form>			
						
		</div>
		
		<form name="showResponseForm" id="showResponseForm" >
		<div id="divshowResponse" style="display: none; margin-right:100px;margin-left:100px;">
		<table border="0" width="80%" align="center"> 
		<tr>
				<td style="font-size:13px">API Name: Account Lookup </br></td>
								<td style="font-size:13px; font-color:red" align="right"><input type="button" id="goback" name="goback" value="Go Back" style="height: 40px; width: 70px; background-color: #e8702a; color: white; font-family: Arial, Times, Sans-serif"></td>
				
				</tr>
				<tr>
				<td style="font-size:11px">API-KEY:</td>
				<td></td>
			</tr>
			<tr>
				<td width="50%"><textarea readonly rows="1" cols="80"
						id="apiKeyALR"
						style="resize: none; scroll: true;background-color: black ;color:#3bd6c6"></textarea></td>
				<td width="50%"></td>
			</tr>
			
			<tr>
				<td style="font-size:11px">SharedSecret:</td>
				<td></td>
			</tr>
			<tr>
				<td width="50%"><textarea readonly rows="1" cols="80"
						id="sharedSecretALR"
						style="resize: none; scroll: true;background-color: black ;color:#3bd6c6"></textarea></td>
				<td width="50%"></td>
			</tr>
			<tr>
				<td style="font-size:11px">End Point URL:</td>
				<td></td>
			</tr>
			<tr>
				<td width="50%"><textarea readonly rows="1" cols="80"						
						style="resize: none; scroll: true;background-color: black ;color:#3bd6c6">https://sandbox.api.visa.com/cva/cce/AccountLookup/</textarea></td>
				<td width="50%"></td>
			</tr>
				
		
			<tr>
				<td style="font-size:11px">X-Pay-Token:</td>
				<td></td>
				</tr>			
			<tr>
				<td width="50%"><textarea readonly rows="1" cols="80" id="requestACTLHeader"
						style="resize: none; scroll: true;background-color: black ;color:#3bd6c6"></textarea></td><td width="50%"></td>		
			</tr>
		</table>
		<table border="0" width="80%" align="center">
			<tr>
				<td style="font-size:11px">Request:</td>
				<td style="font-size:11px">Response:</td>
		</tr>
			<tr>
				<td align="left"><textarea readonly rows="20" cols="80" id="request"
						style="resize: none; scroll: true; background-color: black ;color:#3bd6c6"></textarea></td>
				<td align="right"> <textarea readonly rows="20" cols="80" id="response"
						style="resize: none; scroll: true; background-color: black ;color:#3bd6c6"></textarea></td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>