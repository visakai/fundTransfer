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
		<h2 style="font-family: Source Code Pro">Funds Transfer App-Triangle Corp.<input type="image" src="images/help1.gif"
				align="right" alt="Submit Button" id="transferAmt"
				onclick="window.open('http://localhost:8082/visaFT/help.html')"
				style="padding-right: 10px;padding-top: 5px;width: 20px; height: 20px; cursor: pointer;"
				title="click to get help" /></h2>
				
				<font size="2" color="white" style="font-family: Source Code Pro"><center>The
				easiest way to transfer money to a Visa card</center></font>
				</br>
				<h4 style="margin-right:250px;margin-left:250px;background-color:#e8702a" color="#e8702a;"><font color="#e8702a">Test</font></h4>
	</div>
	

	
</body>
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
			
					<td width="16.6%" colspan="3" align="center"><a href="transfer.jsp"><img src="images/transfer.png" style="width: 100px; height: 100px;"/></a></td>
					<!-- <td><img src="images/Blue_Arrow.png" alt="Mountain View"
					style="width: 40px; height: 20px;"></td> -->
			</tr>
			
			<tr>
				
							<td></td>
				<td width="16.6%" style="font-family: Source Code Pro"><b><font color="#011f4b" size="4px">Money Transfer
							</font></b></td>
							<td></td>
				
			</tr>
		</table>
					<br>
			<font size="2" family = "Source Code Pro"> Step 2 of 3- Enter Recipient's Visa Card Number:<font color="red">*</font></font>
	
<br>
		</br>
				
<table border="0" align="center" width="40%" style="border: 1px solid grey; ">	
			<tr>
				<td>
				
				</td>
			</tr>
			<tr>
				<td></td>
			</tr>
			
			<tr>
			<td style="font-size: 10pt;" width="35%" family = "Source Code Pro" align="center">Recipient Card Number: <font color="red">*</font></td>
				<td align="left"><input type="text" size="19" name="recipientCardNumber" id="recipientCardNumber" value="4957030005709912"/><div class="myErrors"></div></td>				
			</tr>
			
		
			<tr>
				<td></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add" id="add"
					style="height: 40px; width: 70px; background-color: #e8702a; color: white;font-family: Arial, Times, Sans-serif">
					</input> <input type="reset" value="Clear" id="clearRecp"
							style="height: 40px; width: 70px; background-color: #e8702a; color: white; font-family: Arial, Times, Sans-serif">
						</input><input type="button" value="Previous" id="prev"
					onclick="window.location='sender.jsp'"
					style="height: 40px; width: 70px; background-color: #e8702a; color: white; font-family: Arial, Times, Sans-serif">
					</input> <input type="button" value="Next" id="next"
					onclick="window.location='transfer.jsp'"
					style="height: 40px; width: 70px; background-color: #3385FF; color: white; font-family: Arial, Times, Sans-serif">
					</input></td><tr><td>&nbsp;</td></tr>
					
			</tr>


		</table>
		<br/>
		<table border="0" width="55%" align="center">
			
			<tr>
				<td style="font-size: 10pt;font-family = "Source Code Pro"">Show Request Response: <input
					type="checkbox" id="cbxShowHide" name="cbxShowHide" value="request"
					style="cursor: pointer;" title="show Request and Response";></td>
			</tr>
		</table>
		<hr noshade size=3 width="100%">
		
			</form>			
						
		<div id="divshowResponse" style="display: none; margin-right:100px;margin-left:100px;">
		<table border="0" width="80%" align="center"> 
		<tr>
				<td><font size="2">API Name: Account Lookup</font></td>
				<td></td>
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
				<td width="50%"><textarea rows="2" cols="80" id="requestACTLHeader"
						style="resize: none; scroll: true;background-color: black ;color:#3bd6c6"></textarea></td><td width="50%"></td>		
			</tr>
		</table>
		<table border="0" width="80%" align="center">
			<tr>
				<td style="font-size:11px">Request:</td>
				<td style="font-size:11px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Response:</td>
		</tr>
			<tr>
				<td align="left"><textarea rows="20" cols="80" id="request"
						style="resize: none; scroll: true; background-color: black ;color:#3bd6c6"></textarea></td>
				<td align="right"> <textarea rows="20" cols="80" id="response"
						style="resize: none; scroll: true; background-color: black ;color:#3bd6c6"></textarea></td>
			</tr>
		</table>
	</div>
</body>
</html>