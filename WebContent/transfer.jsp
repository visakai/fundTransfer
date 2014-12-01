<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Visa Direct</title>
<link href="${pageContext.request.contextPath}/css/transferApp.css"
	rel="stylesheet" />

<link href="${pageContext.request.contextPath}/css/jquery-ui.css"
	rel="stylesheet" />
<script src="${pageContext.request.contextPath}/jquery/jquery.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jquery/jquery-ui.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jquery/validations.js"
	type="text/javascript"></script>

</head>
<body link="#FFFF99" vlink="#FFFF99" alink="#FFFF99" onLoad="populateAccNumbers()">

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
			<input type="button" id="adminsubmit" value="Submit" style="background-color: #e8702a; color: white; height: 30px; width: 60px; cursor: pointer;" />&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="reset" value="Reset" id="clearAdmin" style="background-color: #e8702a; color: white; height: 30px; width: 60px; cursor: pointer;">
							</input> &nbsp;&nbsp;&nbsp;&nbsp;<input
							type="button" value="Close"id="closeWin"  style="background-color: #e8702a; color: white; height: 30px; width: 60px; cursor: pointer;" >
							</input><br />
		</form>
</div>
	
		<div id="div1">
	<form id="frontend" method="post"style="background:#d2d4dc;margin-right:250px;margin-left:250px;">
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
					
		<div style="text-align: center">
			
				</br> <font size="2" family = "Source Code Pro">Step 3 of 3 - Transfer Money</br>
				</font>
				
		</br>

					
					<div style="text-align: left">
					
					<table border="0" align="center" width="45%" style="border: 1px solid grey; ">		
							<tr><td align="left" style="font-size: 10pt;font-family:Source Code Pro" width="35%" >&nbsp;&nbsp;&nbsp; Sender's A/c Number:<font color="red">*</font></td>
							<td align="left"><input type="text" name="accNo" id="accNo" disabled value="<%=session.getAttribute( "senderPAN" )==null?"":session.getAttribute( "senderPAN" )%>"></input>
							
							<input type="button" value="Update" id="update" size="3"
									style="font-size: 10px;background-color: #011f4b; color: white; height: 25px; width: 50px; cursor: pointer;"
									title="Click here to update Sender account number"; onClick="window.location='sender.jsp'"> </input>
									<div class="myErrors"></div></td>
							</tr>
							<tr><td align="left" style="font-size: 10pt;font-family:Source Code Pro" width="35%" >&nbsp;&nbsp;&nbsp; Receiver's A/c Number:<font color="red">*</font></td>
							<td align="left">
							<input type="text" name="recipientCardNumber" id="recipientCardNumber" disabled value="<%=session.getAttribute( "recipientPAN" )==null?"":session.getAttribute( "recipientPAN" )%>"></input>
							
							<input type="button" value="Update" id="addRec" size="3"
									style="font-size: 10px;background-color: #011f4b; color: white; height: 25px; width: 50px; cursor: pointer;"
									title="Click here to add Recipient account number"; onClick="window.location='recipient.jsp'"> </input>
									<div class="myErrors"></div></td>
							
							</tr>
							<tr>
							<div style="text-align: center" />
								<td align="left" style="font-size: 10pt;font-family:Source Code Pro" width="35%" >&nbsp;&nbsp;&nbsp; Amount: $ <font color="red">*</font></td>
								<td align="left"><input type="text" name="amount"
									id="amount" class="money" value="25"
									type=" number" step="any" size="8" height="20"
									; style="font-size: 12pt; cursor: pointer;font-family:Source Code Pro"
									> </input>
									<div class="myErrors"></div></td>
							</tr>
							<tr>
								<td align="center"  colspan="2"></br>
							
									<input type="submit" value="Transfer" id="transfer" size="3"
									style="background-color: #e8702a; color: white; height: 40px; width: 70px; cursor: pointer;"
									title="Click to transfer the amount";> </input>&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset" value="Reset" id="clearTransfer"
							style="height: 40px; width: 70px; background-color: #e8702a; color: white; font-family: Arial, Times, Sans-serif">
								</input>
									</td>
							</tr>
							
							<tr><td>&nbsp;</td></tr></table>
							</br>
						<div id="showMsg" style="display: none"></div>

							<table border="0" width="55%" align="center">
						<td align="center" style="font-size: 9pt;font-family:Source Code Pro" width="35%" >Under the hood: <input type="checkbox"
								id="cbxShowHide" name="requestAFT" value="requestAFT"
								style="cursor: pointer;" title="show AFT Request and Response";>
								&nbsp;
							</td>
							<!-- <td style="font-size: 9pt;font-family:Source Code Pro" width="35%" >Under the hood: <input type="checkbox"
								id="cbxShowHideOCT" name="requestOCT" value="requestOCT"
								style="cursor: pointer;" title="show OCT Request and Response";>
								</br>

							</td> -->
							</tr>
						
						</table>
						
					</div>
			


					</select> </select> </br>
					<div style="float: left">
						</br> </br>


					</div>
	</form>
	</div>
	<hr noshade size=3 width="100%">
		
		</div>
		
	</div>
	<form name="showResponseForm" id="showResponseForm" >
	<div id="divshowResponse"  style="display: none;">
			<table border="0" width="74%" align="center"> 
		<td><font size="2">API Name: Pull Money(AFT)</font></td>
				
				<td></td>
					<td style="font-size:13px; font-color:red" align="right"><input type="button" id="goback1" name="goback1" value="Go Back" style="height: 40px; width: 70px; background-color: #e8702a; color: white; font-family: Arial, Times, Sans-serif"></td>
				</tr>
				<tr>
				<td style="font-size:11px">API-KEY:</td>
				<td></td>
			</tr>
			<tr>
				<td width="50%"><textarea readonly rows="1" cols="80"
						id="apiKeyAFT"
						style="resize: none; scroll: true;background-color: black ;color:#3bd6c6"></textarea></td>
				<td width="50%"></td>
			</tr>
			
			<tr>
				<td style="font-size:11px">SharedSecret:</td>
				<td></td>
			</tr>
			<tr>
				<td width="50%"><textarea readonly rows="1" cols="80"
						id="sharedSecretAFT"
						style="resize: none; scroll: true;background-color: black ;color:#3bd6c6"></textarea></td>
				<td width="50%"></td>
			</tr>
			<tr>
				<td style="font-size:11px">End Point URL:</td>
				<td></td>
				</tr>			
			<tr>
				<td width="50%"><textarea readonly rows="1" cols="80"
						style="resize: none; scroll: true;background-color: black ;color:#3bd6c6">https://sandbox.api.visa.com/cva/cce/AccountFundingTransactions/</textarea></td>
				<td width="50%"></td>

			</tr>
			<tr>
				<td style="font-size:11px">X-Pay-Token:</td>
				<td></td>
				</tr>			
			<tr>
				<td width="50%"><textarea readonly rows="1" cols="80"
						id="requestAftHeader" style="resize: none; scroll: true;background-color: black ;color:#3bd6c6"></textarea></td>
				<td width="50%"></td>

			</tr>
		</table>
		<table border="0" align="center" width="74%" >
		<tr>
				<td style="font-size:11px">Request:</td>
				<td style="font-size:11px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Response:</td>
</tr>
			
			<tr>
				<td align="left"><textarea rows="15" cols="80" id="requestAft"
						style="resize: none; scroll: true; background-color: black ;color:#3bd6c6" readonly></textarea></td>
				<td align="right"><textarea rows="15" cols="80" id="responseAft"
						style="resize: none; scroll: true; background-color: black ;color:#3bd6c6" readonly></textarea></td>
			</tr>
		</table>
	
	</br>		
	
		<table border="0" width="74%" align="center" >	
		<td><font size="2">API Name:Push Money(OCT)</font></td>
		<tr>
				<td style="font-size:11px"></br>End Point URL:</td>
				<td></td>
				</tr>			
			<tr>
				
				
				<td width="50%"><textarea readonly rows="1" cols="80"
						style="resize: none; scroll: true;background-color: black ;color:#3bd6c6">https://sandbox.api.visa.com/cva/cce/OriginalCreditTransactions/</textarea></td>
				<td width="50%"></td>
			</tr>		
			<tr>
				<td style="font-size:11px">X-Pay-Token:</td>
				<td></td>
				</tr>
			<tr>
				<td width="50%"><textarea readonly rows="1" cols="80"
						id="requestOCTHeader" style="resize: none; scroll: true; background-color: black ;color:#3bd6c6""></textarea></td>
				<td width="50%"></td>
			</tr>
		</table>
		<table border=0" width="74%" align="center" style="">
			<tr>
				<td style="font-size:11px">Request:</td>
				<td style="font-size:11px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Response:</td>
		</tr>
			<tr>
				<td align="left"><textarea readonly rows="15" cols="80" id="requestOCT"
						style="resize: none; scroll: true; background-color: black ;color:#3bd6c6"></textarea></td>
				<td align="right"><textarea readonly rows="15" cols="80" id="responseOCT"
						style="resize: none; scroll: true; background-color: black ;color:#3bd6c6"></textarea></td>
			</tr>
		</table>

	</div>

	</br>
	</br>
	</pre>
	</div>
	</div>
	</form>
</body>
</html>