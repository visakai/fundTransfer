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
<body link="#FFFF99" vlink="#FFFF99" alink="#FFFF99">
	<div id="header" style="text-align: center">
		
		<h2>Domestic Funds Transfer<input type="image" src="images/help1.gif"
				align="right" alt="Submit Button" id="transferAmt"
				onclick="window.open('http://localhost:8082/visaFT/help.html')"
				style="padding-right: 10px;padding-top: 5px;width: 20px; height: 20px; cursor: pointer;"
				title="click to get help" /></h2>
	</div>

		
	</div>
	


	<form id="frontend" method="post"style="background-color:#ffe39f">

	<table border="0" width="50%" align="center">
					</br>	<h5>
			<font size="3" color="#3385FF"> <center>The easiest way to transfer money to a Visa
				card </center></font>
		</h5>
	
						<tr>
						<td width="16.6%">	<img src="images/highlighted1.png" alt="Mountain View"
										style="width: 150px; height: 68px;">							
							</td>
							<td  width="16.6%">	<img src="images/highlighted2.png" alt="Mountain View"
										style="width: 150px; height: 68px">							
							</td>
							<td  width="16.6%">	<img src="images/m3.png" alt="Mountain View"
										style="width: 150px; height: 68px;">						
							</td>
						</tr>
						<tr>
						<td  width="16.6%" ><b><font color="#3385FF">Send Money</font></b></td>
						<td  width="16.6%"><b><font color="#3385FF">Receive Money</font></b></td>
						<td  width="16.6%"><b><font color="#3385FF">Transfer Money</font></b></td>
						</tr>
					</table>
					<br>
		<div style="text-align: center">
			<h5>
				</br> <font size="2">Step 3 of 3- Transfer Money:
				</font>
				<h5>
		</br>

					
					<div style="text-align: left">
					<table border="0" align="center" width="25%" style="border: 1px solid grey; ">		
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<div style="text-align: center" />
								<td align="center">Amount: $ <font color="red">*</font></td>
								<td align="left"><input type="TEXT" name="amount"
									id="amount" class="money" value="25"
									type=" number" step="any" size="8" height="20"
									; style="font-size: 12pt; cursor: pointer;"
									> </input>
									<div class="myErrors"></div></td>
							</tr>
							<tr>
								<td align="center"  colspan="2"></br>
							
									<input type="submit" value="Transfer" id="transfer" size="3"
									style="background-color: #3385FF; height: 40px; width: 70px; color: white; cursor: pointer;"
									title="Click to transfer the amount";> </input>
								<input type="reset" value="Clear" id="clearTransfer"
							style="height: 40px; width: 70px; background-color: #3385FF; color: white; font-family: Arial, Times, Sans-serif">
								</input>
									<input type="button" value="Previous" id="transferAmt" size="3"
									onclick="window.location='recipient.jsp'"
									style="background-color: #3385FF; height: 40px; width: 70px; color: white; cursor: pointer;"
									title="Back to previous page"; ></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr></table>
							</br>
							<table border="0" width="55%" align="center">
						<td align="right">Pull Money: <input type="checkbox"
								id="cbxShowHideAFT" name="requestAFT" value="requestAFT"
								style="cursor: pointer;" title="show AFT Request and Response";>
								&nbsp;
							</td>
							<td>Push Money: <input type="checkbox"
								id="cbxShowHideOCT" name="requestOCT" value="requestOCT"
								style="cursor: pointer;" title="show OCT Request and Response";>
								</br>

							</td>
							</tr>
						
						</table>
						
					</div>
			


					</select> </select> </br>
					<div style="float: left">
						</br> </br>


					</div>
	</form>
	<hr noshade size=3 width="80%">
		
		</div>
		
	</div>
	<div id="divshowResponseAFT" style="display: none; margin-left: 10px">
		<table border="0" width="80%" align="center"> 
		<td><b>API Name: Pull Money(AFT), Push Money(OCT)</b></td>
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
						id="requestAftHeader" style="resize: none; scroll: true;background-color:#E6E6D8"></textarea></td>
				<td width="50%"></td>

			</tr>
		</table>
		<table border="0"align="center" width="80%">
		<tr>
				<td>Request(Pull Money):</td>
				<td>Response(Pull Money):</td>
				</tr>
			
			<tr>
				<td><textarea rows="15" cols="80" id="requestAft"
						style="resize: none; scroll: true;background-color:#E6E6D8"></textarea></td>
				<td><textarea rows="15" cols="80" id="responseAft"
						style="resize: none; scroll: true;background-color:#E6E6D8"></textarea></td>
			</tr>
		</table>
	</div>
	</br>		
	<div id="divshowResponseOCT" style="display: none; margin-left: 10px">
		<table border="0" width="80%" align="center">			
			<tr>
				<td>X-Pay-Token:</td>
				<td></td>
				</tr>
			<tr>
				<td width="50%"><textarea rows="2" cols="80"
						id="requestOCTHeader" style="resize: none; scroll: true;background-color:#E6E6D8"></textarea></td>
				<td width="50%"></td>
			</tr>
		</table>
		<table border="0" width="80%" align="center">
			<tr>
				<td>Request(Push Money):</td>
				<td>Response(Push Money):</td>
				</tr>
			<tr>
				<td><textarea rows="15" cols="80" id="requestOCT"
						style="resize: none; scroll: true;background-color:#E6E6D8"></textarea></td>
				<td><textarea rows="15" cols="80" id="responseOCT"
						style="resize: none; scroll: true;background-color:#E6E6D8"></textarea></td>
			</tr>
		</table>

	</div>

	</br>
	</br>
	</pre>
	</div>
</body>
</html>