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
	<div id="header" style="align: center">

		<h2>Domestic Funds Transfer<input type="image" src="images/help1.gif"
				align="right" alt="Submit Button" id="transferAmt"
				onclick="window.open('http://localhost:8082/visaFT/help.html')"
				style="padding-right: 10px;padding-top: 5px;width: 20px; height: 20px; cursor: pointer;"
				title="click to get help" /></h2>
	</div>

	
	<div id="adminConsole" width="100%" title="Admin Console"
		style="font-size: 10pt";>
		<span id="ui-id-1" class="ui-dialog-title"></span>
		<form class="form" action="#" id="adminConsole">
			</br>
			<label><b>Api-Key:</b></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="text" id="apiKey" size="50" placeholder="" value="YU61R615DKXQP195HVKY21qjHi4NqQivhwWurF7rOHJJQUl-0"/></br>
			</br> <label><b>Shared Secret:</b></label>&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="text" id="sharedSecret"size="50"  placeholder="" value="@xTW5Ux4boHPKwp8cV@P3zU#0gdtM5QmBp/OTCXx"/></br>
			</br> </br>
			<input type="button" id="submit" value="submit" />&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="reset" value="Reset" id="clearSender">
							</input> &nbsp;&nbsp;&nbsp;&nbsp;<input
							type="button" value="closeWin"id="closeWin" >
							</input><br />
		</form>
	</div>
	<form id="senderForm" name="senderForm" method="post" action=""
		style="background-color: #ffe39f">
		</br>
		<h2>
		<font size="3" color="#3385FF" background-color="#ffe39f"style="background-color: #ffe39f"><center>The
				easiest way to transfer money to a Visa card</center></font>
	</h2>
		
		</br>
		<table border="0" width="50%" align="center">

			<tr>

				<td width="16.6%"><img src="images/m1.png" alt="Mountain View"
					style="width: 150px; height: 68px;"></td>
				<td width="16.6%"><img src="images/highlighted2.png"
					alt="Mountain View" style="width: 150px; height: 68px"></td>
				<td width="16.6%"><img src="images/highlighted3.png"
					alt="Mountain View" style="width: 150px; height: 68px;"></td>
			</tr>
			<tr>
				<td width="16.6%"><b><font color="#3385FF">Send
							Money</font></b></td>
				<td width="16.6%"><b><font color="#3385FF">Receive
							Money</font></b></td>
				<td width="16.6%"><b><font color="#3385FF">Transfer
							Money</font></b></td>
			</tr>
		</table>
		<br>
		<br>
		<table border="0">
			<td><input type="button" id="admin" value="Admin Console"
				style="float: left; padding: 7px; height: 40px; width: 100px; background-color: #3385FF; color: white; font-family: Arial, Times, Sans-serif;"></td>
			<input type="button"
				style="float: left; padding: 0; border: none; height: 40px; width: 90px; background: #ffe39f">
			</td>
		</table>
		<h5>
			<font size="2"> Step 1 of 3- Enter Sender Details:</font>
			<h5>

				</br>

				<table border="0" align="center" width="35%"
					style="border: 1px solid grey;">
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>Debit/Credit Card Number: <font color="red">*</font></td>

						<td align="left"><input type="text" name="accNo" id="accNo"
							value="4957030001386608"></input>
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
							style="height: 40px; width: 70px; background-color: #3385FF; color: white; font-family: Arial, Times, Sans-serif">
							</input> &nbsp;&nbsp;&nbsp;<input type="button" value="Next" id="next"
							style="height: 40px; width: 70px; background-color: #3385FF; color: white; font-family: Arial, Times, Sans-serif"
							onclick="window.location='recipient.jsp'"> </input>&nbsp;&nbsp;&nbsp;<input
							type="reset" value="Clear" id="clearSender"
							style="height: 40px; width: 70px; background-color: #3385FF; color: white; font-family: Arial, Times, Sans-serif">
							</input></td>
					</tr>

				</table>
			</h5>
		</h5>

		</br>
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


	<div id="divshowResponse"
		style="display: none; margin-left: 10px; background-color: white">

		<table border="0" width="80%" align="center">
			<tr>
				<td><b>API Name: Account Verification</b></td>
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
				<td width="50%"><textarea rows="2" cols="80"
						id="requestACTVHeader"
						style="resize: none; scroll: true; background-color: #E6E6D8"></textarea></td>
				<td width="50%"></td>
			</tr>
		</table>
		<table border="0" width="80%" align="center">
			<tr>
				<td>Request:</td>
				<td>Response:</td>
			</tr>


			<tr>
				<td><textarea rows="20" cols="80" id="request"
						style="resize: none; scroll: true; background-color: #E6E6D8"></textarea></td>
				<td><textarea rows="20" cols="80" id="response"
						style="resize: none; scroll: true; background-color: #E6E6D8"></textarea></td>
			</tr>
		</table>
	</div>

</body>
</html>