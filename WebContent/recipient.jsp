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
	<div id="header" style="align: center">
		
		<h2>Domestic Funds Transfer<input type="image" src="images/help1.gif"
				align="right" alt="Submit Button" id="transferAmt"
				onclick="window.open('http://localhost:8082/visaFT/help.html')"
				style="padding-right: 10px;padding-top: 5px;width: 20px; height: 20px; cursor: pointer;"
				title="click to get help" /></h2>
	</div>
	
	<form id="recipientForm" name="recipientForm" method="post" action="" style="background-color:#ffe39f">
	
	
</body>
	<table border="0" width="50%" align="center">
					</br><h5>
			<font size="3" color="#3385FF"> <center>The easiest way to transfer money to a Visa
				card </center></font>
		</h5>	
						<tr>
						<td width="16.6%">	<img src="images/highlighted1.png" alt="Mountain View"
										style="width: 150px; height: 68px;">							
							</td>
							<td  width="16.6%">	<img src="images/m2.png" alt="Mountain View"
										style="width: 150px; height: 68px">							
							</td>
							<td  width="16.6%">	<img src="images/highlighted3.png" alt="Mountain View"
										style="width: 150px; height: 68px;">						
							</td>
						</tr>
						<tr>
						<td  width="16.6%" ><b><font color="#3385FF">Send Money</font></b></td>
						<td  width="16.6%"><b><font color="#3385FF">Receive Money</font></b></td>
						<td  width="16.6%"><b><font color="#3385FF">Transfer Money</font></b></td>
						</tr>
					</table>
					<br><br>
		<h5>
			<font size="2"> Step 2 of 3- Enter Recipient's Visa Card Number:<font color="red">*</font></font>
		</h5>

		</br>
				
<table border="0" align="center" width="35%" style="border: 1px solid grey; ">	
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
			<td style="font-size: 10pt;" width="35%" ><b>Recipient Card Number:</b> <font color="red">*</font></td>
				<td align="left"><input type="text" size="19" name="recipientCardNumber" id="recipientCardNumber" value="4957030005709912"/><div class="myErrors"></div></td>				
			</tr>
			<tr>
				<td></td>
			</tr>
		
			<tr>
				<td></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add" id="add"
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
					
			</tr>


		</table>
		<br/>
		<table border="0" width="55%" align="center">
			<th>
			<tr>
				<td style="font-size: 10pt;"><b>Show Request Response: </b><input
					type="checkbox" id="cbxShowHide" name="cbxShowHide" value="request"
					style="cursor: pointer;" title="show Request and Response";></td>
			</tr>
		</table>
		<hr noshade size=3 width="80%">
		
			</form>			
						
		<div id="divshowResponse" style="display: none; margin-left: 10px">
		<table border="0" width="80%" align="center"> 
		<tr>
				<td><b>API Name: Account Lookup</b></td>
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
				<td>X-Pay-Token:</td>
				<td></td>
				</tr>			
			<tr>
				<td width="50%"><textarea rows="2" cols="80" id="requestACTLHeader"
						style="resize: none; scroll: true;background-color:#E6E6D8"></textarea></td><td width="50%"></td>		
			</tr>
		</table>
		<table border="0" width="80%" align="center">
			<tr>
				<td>Request:</td>
				<td>Response:</td>
				</tr>
			<tr>
				<td><textarea rows="20" cols="80" id="request"
						style="resize: none; scroll: true;background-color:#E6E6D8"></textarea></td>
				<td> <textarea rows="20" cols="80" id="response"
						style="resize: none; scroll: true;background-color:#E6E6D8"></textarea></td>
			</tr>
		</table>
	</div>
</body>
</html>