function dropDown(){ 
$.get('CSVActionServlet',function(responseJson) { 
    	        $.each(responseJson, function(key, value) {  
            	//  alert("value",responseJson);
            	   $("#cardNumber12345").find('option').remove();
                  for(i=0; i < value.length; i++){
                       $("#cardNumber12345").append('<option value="'+value[i]+'">'+value[i]+'</option>');
                    //   alert(value[i]);
                   }
              
              // alert("valueaaaaa",key);
                });
        });};

$(document).ready(function() {	
	
	 $('#showSuccessMsg').hide(); $('#showErrorMsg').hide();
	 $('#username').focus();	
	 
	//login page
	var loginValidator =  $("#loginForm").validate({
		rules: {		     
			// mandatory entry
			username: {required:true},	
			pwd: {required:true},	
		},	
		
		submitHandler: function(){
			var userId = $('#username').val();
			var password = $('#pwd').val();
			if(userId=="visaguest" && password=="possibilities"){
				 window.location = "transfer.jsp";
			}else{
				$('#invalid').show();
				$(':input','#loginForm')
				 .not(':button, :submit, :reset, :hidden')
				 .val('');		
				$('#username').focus();				
			}			
		}
		});
		
	$('#goback').click(function() {
        $('#divshowResponse').slideToggle("slow");
        $('#div1').show();       
        $('#cbxShowHide').attr('checked', false); 
 });
	
	
	$('#goback1').click(function() {
        $('#divshowResponse').slideToggle("slow");
        $('#div1').show();       
        $('#cbxShowHideAFT').attr('checked', false); 
 });
	
	
		
	//$( "#next" ).prop( "disabled", true ).css({backgroundColor:"#909090"});

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
		 $('#div1').slideToggle("slow");	
		 
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

		
			$.get('AccountVerificationRequestServlet',{accNo:accNo},function(responseText) { 


				$('#request').html(responseText);  

			});	

			$.get('AccountVerificationResponseServlet',{accNo:accNo},function(responseText) { 
				$('#requestACTVHeader').html(responseText.token);
				$('#response').html(responseText.response); 				  
				var responseRegExp = new RegExp("TransactionIdentifier");
				if (responseRegExp.test(responseText.response)) {					
					 $('#showSuccessMsg').show();

					//$( "#next" ).prop( "disabled", false ).css({backgroundColor: "#e8702a", color: "white"});
				}else{
					 $('#showErrorMsg').show();
					//$( "#next" ).prop( "disabled", true ).css({backgroundColor:"#909090"});
				}
			});

		}

	});

	$("#clearSender").click(function() { 
		senderValidator.resetForm();
	});



             
             
             
             var adminConsole = $( "#adminConsole" ).dialog({ 
                 autoOpen: false,
                 resizable: false,
                   height:    200,
                   width:     600,
                   background: "#ff0000"  
                 }).prev(".ui-dialog-titlebar").css("background","#e8702a");
                 $("#adminConsole").prev().css({"color":"white"});

                 $( "#admin" ).click(function() {
                 $( "#adminConsole" ).dialog( "open" );
                 
                 
                 $("#adminConsole").prev().css({"font-size":"80%"});
                 
                 });
                 
                 $("#closeWin").click(function() { 
                        
                        $( "#adminConsole" ).dialog( "close" );
                 });          
                 

             
             
             

$("#adminsubmit").click(function(){
			
			var apiKey = $('#apiKey').val();
			var sharedSecret = $('#sharedSecret').val();
			alert(apiKey);
			$.get('AdminConsoleServlet',{apiKey:apiKey,sharedSecret:sharedSecret}, function(responseText){
				
				alert("in function");
			});
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
				//	$( "#next" ).prop( "disabled", false ).css({backgroundColor: "#ecb939", color: "#011f4b"});
					var recipientCardNumber =$('#recipientCardNumber').val();   	 
					 	
					$.get('AccountlookuprequestServlet',{recipientCardNumber:recipientCardNumber},function(responseText) {    	
						
						$('#request').html(responseText);
							 
					});	   	 
					$.get('AccountlookupresponseServlet',{recipientCardNumber:recipientCardNumber},function(responseText) {
						$('#response').html(responseText.response);  
						$('#requestACTLHeader').html(responseText.token);    
						var responseRegExp = new RegExp("CardProductTypeCode");
						if (responseRegExp.test(responseText.response)) {
							 $('#showSuccessMsg').show();

								//$( "#next" ).prop( "disabled", false ).css({backgroundColor: "#e8702a", color: "white"});
							}else{
								 $('#showErrorMsg').show();
						//	$( "#next" ).prop( "disabled", true ).css({backgroundColor:"#909090"});
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
					

					$.get('AFTrequestServlet', {
						amount : amount
					}, function(responseText) {
						$('#requestAft').html(responseText);  
					});

					$.get('AFTresponseServlet', {
						amount : amount
					}, function(responseText) {
						$('#requestAftHeader').html(responseText.token); 
						$('#responseAft').html(responseText.response);  
						var responseRegExp = new RegExp("TransactionIdentifier");
						if (responseRegExp.test(responseText.response)) {
							doOCT();
						}else{
							 $('#showErrorMsg').show();
						} 

					});

				}

			});

	$('#cbxShowHideAFT').click(
			function() {
				this.checked ? $('#divshowResponse')
						.show(1000) : $(
						'#divshowResponse').hide(
								1000); //time for show
						 $('#div1').slideToggle("slow");	
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
		


		$.get('OCTrequestServlet', {amount : amount}, function(responseText) {

			$('#requestOCT').html(responseText);  

		});

		$.get('OCTresponseServlet', {
			amount : amount
		}, function(responseText) {

			$('#responseOCT').html(responseText.response);  
			$('#requestOCTHeader').html(responseText.token);
			var responseRegExp = new RegExp("TransactionIdentifier");
			if (responseRegExp.test(responseText.response)) {
				 $('#showSuccessMsg').show();				
			}else{
				 $('#showErrorMsg').show();
			} 

		});


	}
});

