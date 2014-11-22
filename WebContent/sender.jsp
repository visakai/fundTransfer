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
<link href="${pageContext.request.contextPath}/css/transferApp.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/jquery-ui.css"
	rel="stylesheet" />
</head>

<body link="#FFFF99" vlink="#FFFF99" alink="#FFFF99">

	<div id="header" style="align: center; background-color:#011f4b;">
</br>
		<h2 style="font-family: Source Code Pro">Funds Transfer App - Triangle Corp.<input type="image" src="images/help1.gif"
				align="right" alt="Submit Button" id="transferAmt"
				onclick="window.open('http://localhost:8082/visaFT/help.html')"
				style="padding-right: 10px;padding-top: 5px;width: 20px; height: 20px; cursor: pointer;"
				title="click to get help" />
				
				
				</h2>
				
				
			
				
				
				<font size="2" color="white" style="font-family: Source Code Pro"><center>The
				easiest way to transfer money to a Visa card</center></font>
				</br>
				<h4 style="margin-right:250px;margin-left:250px;background-color:#e8702a" color="#e8702a;"><font color="#e8702a">Test</font></h4>
							
	</div>

	
	
	<div id="div1">
	<form id="senderForm" name="senderForm" method="post" action=""
		style="background:#d2d4dc;margin-right:250px;margin-left:250px;">
		</br>
		
		</br>
		</br>
		
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

		
		
			<font size="2" family = "Source Code Pro"> Step 1 of 3- Enter Sender Details:</font>
			            
				</br></br>

				<table border="0" align="center" width="38%"
					style="border: 1px solid grey;">
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="center" padding-bottom=" 225px"><font size="2" family= "Source Code Pro" >Debit/Credit Card Number: <font color="red">*</font></font></td>

						<td align="left"><input type="text" name="accNo" id="accNo"
							value="4957030001386632"></input>
							<div class="myErrors"></div></td>
					</tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>

					<tr>
						<td align="center" colspan="2" width="10%"><input
							type="submit" value="Verify" id="verify"
							style="height: 40px; width: 70px; background-color: #e8702a; color: white; font-family: Arial, Times, Sans-serif">
							</input> &nbsp;&nbsp;&nbsp;<input type="button" value="Next" id="next"
							style="height: 40px; width: 70px; background-color: #e8702a; color: white; font-family: Arial, Times, Sans-serif"
							onclick="window.location='recipient.jsp'"> </input>&nbsp;&nbsp;&nbsp;<input
							type="reset" value="Reset" id="clearSender"
							style="height: 40px; width: 70px; background-color: #e8702a; color: white; font-family: Arial, Times, Sans-serif">
							</input></td>
					</tr>

				</table>
			</h5>
		</h5>
		<br/>
 <div id="showSuccessMsg"><font color="green" family="Source Code Pro"><center>Sender's Account Verified Successfully!</center></font></div>
  <div id="showErrorMsg"><font color="red" family="Source Code Pro"><center>Failed to verify Sender's Account.<center></font></div>
		</br>
		<table border="0" width="55%" align="center">
			<th>
			<tr>
				<td style="font-size: 9pt;font-family:Source Code Pro">Under the hood:<input
					type="checkbox" id="cbxShowHide" name="cbxShowHide" value="request"
					style="cursor: pointer;" title="show Request and Response";></td>
			</tr>
		</table>
		<hr noshade size=3 width="100%">
		</div>
	</form>

<form name="showResponseForm" id="showResponseForm" >
	<div id="divshowResponse"
		style="display: none; background-color: white;margin-right:100px;margin-left:100px;">

		<table border="0" width="80%" align="center">
			<tr>
				<td style="font-size:13px">API Name: Account Verification </br></td>
								<td style="font-size:13px; font-color:red" align="right"><input type="button" id="goback" name="goback" value="Go Back" style="height: 40px; width: 70px; background-color: #e8702a; color: white; font-family: Arial, Times, Sans-serif"></td>
				
				</tr>
				
				<tr>
				<td style="font-size:11px">API-KEY:</td>
				<td></td>
			</tr>
			<tr>
				<td width="50%"><textarea rows="2" cols="80"						
						style="resize: none; scroll: true;background-color: black ;color:#3bd6c6">061UIYMQ9QE0OH6N5VCR21YvFEKZo2NKTyPNUgGGHH6fz04Xk</textarea></td>
				</textarea></td>
				<td width="50%"></td>
			</tr>
			
			
			<tr>
				<td style="font-size:11px">SharedSecret:</td>
				<td></td>
			</tr>
			<tr>
				<td width="50%"><textarea rows="2" cols="80"						
						style="resize: none; scroll: true;background-color: black ;color:#3bd6c6">8PgE+WUzTE}5qW35B@J21AlZum7D-rfxQ$E-}qF5</textarea></td>
				</textarea></td>
				<td width="50%"></td>
			</tr>
			
							
			<tr>
				<td style="font-size:11px">End Point URL:</td>
				<td></td>
			</tr>
			<tr>
				<td width="50%"><textarea rows="2" cols="80"						
						style="resize: none; scroll: true;background-color: black ;color:#3bd6c6">
						https://sandbox.api.visa.com/cva/cce/AccountVerification/061UIYMQ9QE0OH6N5VCR21YvFEKZo2NKTyPNUgGGHH6fz04Xk</textarea></td>
				</textarea></td>
				<td width="50%"></td>
			</tr>
			
			
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>

			<tr>
				<td style="font-size:11px">X-Pay-Token:</td>
				<td></td>
			</tr>
			<tr>
				<td width="50%"><textarea rows="2" cols="80"
						id="requestACTVHeader"
						style="resize: none; scroll: true;background-color: black ;color:#3bd6c6"></textarea></td>
				<td width="50%"></td>
			</tr>
		</table>
		<table border="0" width="80%" align="center">
			<tr>
				<td style="font-size:11px">Request:</td>
				<td style="font-size:11px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Response:</td>
			</tr>


			<tr>
				<td  align="left"><textarea rows="20" cols="80" id="request"
						style="resize: none; scroll: true; background-color: black ;color:#3bd6c6"></textarea></td>
				<td align="right"><textarea rows="20" cols="80" id="response"
						style="resize: none; scroll: true; background-color: black ;color:#3bd6c6"></textarea></td>
			</tr>
		</table>
		</br>
		</br>
	</div>
	</form>

</body>
</html>