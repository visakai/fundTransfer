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
		</br>
		<h2>
			Domestic Funds Transfer <input type="image" src="images/help.png"
				align="right" alt="Submit Button" id="transferAmt"
				onclick="window.open('http://localhost:8080/visaFT/help.html')"
				style="width: 20px; height: 20px; cursor: pointer;"
				title="click to get help" />
		</h2>
		</br> <font size="2"> </font>

	</div>
	</br>


	<form id="frontend" method="post">


		<div style="text-align: center">
			<h5>
				</br> <font size="2"> The easiest way to transfer money to a Visa
					card </br> </br> Step 3 of 3- Transfer Money:
				</font>
				<h5>

					<div style="float: left; margin-left: 25px">
						<table border="0" width="100%">
							<th align="center">
							<tr>
								<td>


									<p
										style="border: 1px solid black; padding: 10px 10px; font-size: 10pt;">
										<b>Simple steps to transfer money to a Visa card</b></br>
										</br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Step 1: Enter Sender
										Details.</br>
										</br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Step 2: Enter Recipient's
										Visa Card Number.</br>
										</br> <img src="images/arrow.png" alt="Mountain View"
											style="width: 20px; height: 18px">&nbsp;
										<mark style="background-color: #3385FF;color: white;">Step
										3: Enter the Amount and transfer the money!</mark>
									</p>
									</br>
								</td>
							</tr>
						</table>
					</div>
					<div style="float: left">
						<table border="0" width="100%">

							<tr>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							</tr>
						</table>
					</div>
					<div style="text-align: left">
						<table border="0" align="left" width="20%">
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
							<tr>
							
						<td align="right">Pull Money(AFT): <input type="checkbox"
								id="cbxShowHideAFT" name="requestAFT" value="requestAFT"
								style="cursor: pointer;" title="show AFT Request and Response";>
								&nbsp;
							</td>
							<td>Push Money(OCT): <input type="checkbox"
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

	<script type="text/javascript"></script>

	</br>

	</div>
	</div>
	<div id="divshowResponseAFT" style="display: none; margin-left: 200px">
		<table border="0" width="100%">
			<th align="left">X-Pay-Token:
			<tr>
				<td width="50%"><textarea rows="2" cols="90"
						id="requestAftHeader" style="resize: none; scroll: true;"></textarea></td>
				<td width="50%"></td>

			</tr>
		</table>
		<table border="0" width="100%">
			<th>Request(AFT):
			<th>Response(AFT):
			<tr>
				<td><textarea rows="15" cols="90" id="requestAft"
						style="resize: none; scroll: true;"></textarea></td>
				<td><textarea rows="15" cols="90" id="responseAft"
						style="resize: none; scroll: true;"></textarea></td>
			</tr>
		</table>
	</div>
	</br>
	<div id="divshowResponseOCT" style="display: none; margin-left: 200px">
		<table border="0" width="100%" align="center">
			<th align="left">X-Pay-Token:
			<tr>
				<td width="50%"><textarea rows="2" cols="90"
						id="requestOCTHeader" style="resize: none; scroll: true;"></textarea></td>
				<td width="50%"></td>
			</tr>
		</table>
		<table border="0" width="100%" align="center">
			<th>Request(OCT):
			<th>Response(OCT):
			<tr>
				<td><textarea rows="15" cols="90" id="requestOCT"
						style="resize: none; scroll: true;"></textarea></td>
				<td><textarea rows="15" cols="90" id="responseOCT"
						style="resize: none; scroll: true;"></textarea></td>
			</tr>
		</table>

	</div>

	</br>
	</br>
	</pre>
	</div>
</body>
</html>