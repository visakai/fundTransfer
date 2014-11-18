$(document).ready(function() {	
	$( "#next" ).prop( "disabled", true ).css({backgroundColor:"#909090"});

	$.validator.addMethod(
			"alphaNumeric",
			function(value, element) {
				var re = /^[A-Za-z]+$/;
				// valid if it passes the regex test
				if(value!=null && value!=""){
					return re.test(value);
				}else{
					return true;
				} 
			}, "Please enter only alphanumerics"
	);


	$('#cbxShowHide').click(function(){		
		this.checked?$('#divshowResponse').show(1000):$('#divshowResponse').hide(1000); //time for show
	});	

	// modify default settings for validation
	jQuery.validator.setDefaults({
		// where to display the error relative to the element
		errorPlacement: function(error, element) {
			error.appendTo(element.parent().find('div.myErrors'));
		}
	});

	var senderValidator =  $("#senderForm").validate({
		rules: {		     
			// mandatory entry
			accNo: {required:true, digits:true, minlength:13, maxlength:19},		
		},

		// on page submit 
		submitHandler: function(){

			var accNo = $('#accNo').val();

			$.post('AccountVerificationRequestServlet',{accNo:accNo},function(responseText) { 


				$('#requestACTVHeader').html(responseText);  

			});	


			$.get('AccountVerificationRequestServlet',{accNo:accNo},function(responseText) { 


				$('#request').html(responseText);  

			});	

			$.get('AccountVerificationResponseServlet',{accNo:accNo},function(responseText) { 
				$('#response').html(responseText); 				  
				var responseRegExp = new RegExp("TransactionIdentifier");
				if (responseRegExp.test(responseText)) {
					$( "#next" ).prop( "disabled", false ).css({backgroundColor:"#3385FF"});
				}else{
					$( "#next" ).prop( "disabled", true ).css({backgroundColor:"#909090"});
				}
			});

		}

	});

	$("#clearSender").click(function() { 
		senderValidator.resetForm();
	});


	//2nd page

	var recpValidator = $("#recipientForm")
	.validate(
			{
				rules : {
					// mandatory entry
					recipientCardNumber: {required:true, digits:true, minlength:13, maxlength:19},
				},

				// on page submit 
				submitHandler : function() {
					$( "#next" ).prop( "disabled", false ).css({backgroundColor:"#3385FF"});
					var recipientCardNumber =$('#recipientCardNumber').val();   	 
					$.post('AccountlookuprequestServlet',{recipientCardNumber:recipientCardNumber},function(responseText) {    	
						$('#requestACTLHeader').html(responseText);     		 
					});	   	
					$.get('AccountlookuprequestServlet',{recipientCardNumber:recipientCardNumber},function(responseText) {    	
						$('#request').html(responseText);    		 
					});	   	 
					$.get('AccountlookupresponseServlet',{recipientCardNumber:recipientCardNumber},function(responseText) {
						$('#response').html(responseText);  
						var responseRegExp = new RegExp("CardProductTypeCode");
						if (responseRegExp.test(responseText)) {
							$( "#next" ).prop( "disabled", false ).css({backgroundColor:"#3385FF"});
						}else{
							$( "#next" ).prop( "disabled", true ).css({backgroundColor:"#909090"});
						}
					});	
				}

			});

	$("#clearRecp").click(function() { 
		recpValidator.resetForm();
	});		

	//3rd page

	function isNumberKey(evt){		
		var charCode = (evt.which) ? evt.which : event.keyCode
				if (charCode > 31 && (charCode != 46 &&(charCode < 48 || charCode > 57)))
					return false;
		return true;
	}
	var transferValidator = $("#frontend")
	.validate(
			{
				rules : {
					amount: {required:true}
				},

				// on page submit 
				submitHandler : function() {
					var amount = $('#amount').val();		 
					$.post('AFTrequestServlet',  {
						amount : amount
					}, function(responseText) { 
						$('#requestAftHeader').html(responseText); 
					});	

					$.get('AFTrequestServlet', {
						amount : amount
					}, function(responseText) {
						$('#requestAft').html(responseText);  
					});

					$.get('AFTresponseServlet', {
						amount : amount
					}, function(responseText) {
						$('#responseAft').html(responseText);  
						var responseRegExp = new RegExp("TransactionIdentifier");
						if (responseRegExp.test(responseText)) {

							doOCT();
						} 

					});

				}

			});

	$('#cbxShowHideAFT').click(
			function() {
				this.checked ? $('#divshowResponseAFT')
						.show(1000) : $(
						'#divshowResponseAFT').hide(
								1000); //time for show
			});
	$('#cbxShowHideOCT').click(
			function() {
				this.checked ? $('#divshowResponseOCT')
						.show(1000) : $(
						'#divshowResponseOCT').hide(
								1000); //time for show
			});
	$("#clearTransfer").click(function() { 
		transferValidator.resetForm();
	});		

	jQuery.validator.addMethod(
			"money",
			function(value, element) {
				var re = /^\d{0,5}(\.\d{0,2})?$/;
				if(value!=null && value!=""){
					return re.test(value);
				}else{
					return true;
				} 		        
			},
			"Enter Valid Amount"
	);


	function doOCT(){


		var amount = $('#amount').val();
		$.post('OCTrequestServlet',  {
			amount : amount
		},	function(responseText) { 


			$('#requestOCTHeader').html(responseText);  

		});	


		$.get('OCTrequestServlet', {amount : amount}, function(responseText) {

			$('#requestOCT').html(responseText);  

		});

		$.get('OCTresponseServlet', {
			amount : amount
		}, function(responseText) {

			$('#responseOCT').html(responseText);  

		});


	}
});

