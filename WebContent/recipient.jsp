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
		<div id="header" style="align: center; background-color:#011f4b">
</br>
		<h2>Funds Transfer App-Triangle Corp.<input type="image" src="images/help1.gif"
				align="right" alt="Submit Button" id="transferAmt"
				onclick="window.open('http://localhost:8082/visaFT/help.html')"
				style="padding-right: 10px;padding-top: 5px;width: 20px; height: 20px; cursor: pointer;"
				title="click to get help" /></h2>
				
				<font size="2" color="white" style=""><center>The
				easiest way to transfer money to a Visa card</center></font>
				</br>
	</div>
	<form id="recipientForm" name="recipientForm" method="post" action="" style="background:#d2d4dc">
	
	
</body>
	<table border="0" width="50%" align="center">
					</br>
						<tr>
						<td width="16.6%">	<img src="images/highlighted1.png" alt="Mountain View"
										style="width: 150px; height: 68px;">							
							</td><td><img src="images/Blue_Arrow.png" alt="Mountain View"
					style="width: 40px; height: 20px;"></td>
							<td  width="16.6%">	<img src="images/m2.png" alt="Mountain View"
										style="width: 150px; height: 68px">							
							</td><td><img src="images/Blue_Arrow.png" alt="Mountain View"
					style="width: 40px; height: 20px;"></td>
							<td  width="16.6%">	<img src="images/highlighted3.png" alt="Mountain View"
										style="width: 150px; height: 68px;">						
							</td>
						</tr>
						<tr>
				<td width="16.6%"><b><font color="#011f4b">Sender</font></b></td>
							<td></td>
				<td width="16.6%"><b><font color="#011f4b">Receiver
							</font></b></td>
							<td></td>
				<td width="16.6%"><b><font color="#011f4b">Money Transfer
							</font></b></td>
			</tr>
					</table>
					<br>
	
			<font size="2"> Step 2 of 3- Enter Recipient's Visa Card Number:<font color="red">*</font></font>
	
<br>
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
			<td style="font-size: 10pt;" width="35%" >Recipient Card Number: <font color="red">*</font></td>
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
					style="height: 40px; width: 70px; background-color: #ecb939; color: #011f4b;font-family: Arial, Times, Sans-serif">
					</input> <input type="reset" value="Clear" id="clearRecp"
							style="height: 40px; width: 70px; background-color: #ecb939; color: #011f4b; font-family: Arial, Times, Sans-serif">
						</input><input type="button" value="Previous" id="prev"
					onclick="window.location='sender.jsp'"
					style="height: 40px; width: 70px; background-color: #ecb939; color: #011f4b; font-family: Arial, Times, Sans-serif">
					</input> <input type="button" value="Next" id="next"
					onclick="window.location='transfer.jsp'"
					style="height: 40px; width: 70px; background-color: #3385FF; color: white; font-family: Arial, Times, Sans-serif">
					</input></td><tr><td>&nbsp;</td></tr>
					
			</tr>


		</table>
		<br/>
		<table border="0" width="55%" align="center">
			
			<tr>
				<td style="font-size: 10pt;">Show Request Response: <input
					type="checkbox" id="cbxShowHide" name="cbxShowHide" value="request"
					style="cursor: pointer;" title="show Request and Response";></td>
			</tr>
		</table>
		<hr noshade size=3 width="80%">
		
			</form>			
						
		<div id="divshowResponse" style="display: none; margin-left: 10px">
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
				<td style="font-size:11px">Response:</td>
				</tr>
			<tr>
				<td><textarea rows="20" cols="80" id="request"
						style="resize: none; scroll: true; background-color: black ;color:#3bd6c6"></textarea></td>
				<td> <textarea rows="20" cols="80" id="response"
						style="resize: none; scroll: true; background-color: black ;color:#3bd6c6"></textarea></td>
			</tr>
		</table>
	</div>
</body>
</html>