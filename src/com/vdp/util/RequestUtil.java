package com.vdp.util;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.visa.vdp.api.cardvalidatiion.AccountLookupRequest;
import com.visa.vdp.api.cardvalidatiion.AccountVerificationRequest;
import com.visa.vdp.api.common.Address;
import com.visa.vdp.api.common.CardAcceptor;
import com.visa.vdp.api.common.MagneticStripeData;
import com.visa.vdp.api.common.OriginalDataElements;
import com.visa.vdp.api.common.PointOfServiceCapability;
import com.visa.vdp.api.common.PointOfServiceData;
import com.visa.vdp.api.common.StreetAddress;
import com.visa.vdp.api.payment.AccountFundingReversalRequest;
import com.visa.vdp.api.payment.AccountFundingTransactionsRequest;
import com.visa.vdp.api.payment.OriginalCreditTransactionsRequest;

public class RequestUtil {

	public static AccountFundingTransactionsRequest createrequestforAFT(
			HttpServletRequest req) {

		AccountFundingTransactionsRequest AFTrequest = new AccountFundingTransactionsRequest();
		AFTrequest.setSystemsTraceAuditNumber(new Integer("300259"));
		AFTrequest.setRetrievalReferenceNumber("407509300259");
		AFTrequest.setDateAndTimeLocalTransaction("2021-10-26T21:32:52");
		AFTrequest.setAcquiringBin(new Integer("409999"));
		AFTrequest.setAcquirerCountryCode(101);
		
		AFTrequest.setSenderPrimaryAccountNumber("4005520000011126");
		
		HttpSession session = req.getSession();
		String senderPAN=(String)session.getAttribute("senderPAN");
		
		if(senderPAN != null){
			AFTrequest.setSenderPrimaryAccountNumber(senderPAN);
		}
		AFTrequest.setSenderCardExpiryDate("2015-05");
		AFTrequest.setSenderCurrencyCode("USD");
		AFTrequest.setAmount(new BigDecimal(req.getParameter("amount")));
		AFTrequest.setSurcharge(new BigDecimal("2.00"));
		AFTrequest.setForeignExchangeFeeTransaction(new BigDecimal("10.00"));
		AFTrequest.setBusinessApplicationID("AA");
		AFTrequest.setMerchantCategoryCode(new Integer("6012"));
		AFTrequest.setFeeProgramIndicator("123");
		AFTrequest.setCavv("0000010926000071934977253000000000000000");

		MagneticStripeData msd = new MagneticStripeData();
		msd.setTrack1Data("1010101010101010101010101010");
		AFTrequest.setMagneticStripeData(msd);

		Address AFTAddress = new Address();
		AFTAddress.setState("CA");
		AFTAddress.setCounty("081");
		AFTAddress.setCountry("USA");
		AFTAddress.setZipCode("94404");

		CardAcceptor aftrCardAcceptor = new CardAcceptor();
		aftrCardAcceptor.setName("Acceptor 1");
		aftrCardAcceptor.setTerminalId("365539");
		aftrCardAcceptor.setIdCode("VMT200911026070");

		aftrCardAcceptor.setAddress(AFTAddress);
		AFTrequest.setCardAcceptor(aftrCardAcceptor);

		PointOfServiceData posDatar = new PointOfServiceData();
		posDatar.setPanEntryMode("90");
		posDatar.setPosConditionCode(0);
		posDatar.setMotoECIIndicator("0");
		AFTrequest.setPointOfServiceData(posDatar);

		PointOfServiceCapability posCr = new PointOfServiceCapability();
		posCr.setPosTerminalEntryCapability(2);
		posCr.setPosTerminalType(4);
		AFTrequest.setPointOfServiceCapability(posCr);

		return AFTrequest;
	}

	public static AccountFundingReversalRequest createrequestforAccountFundingReversal(
			HttpServletRequest req) {

		AccountFundingReversalRequest AFRrequest = new AccountFundingReversalRequest();
		AFRrequest.setSystemsTraceAuditNumber(new Integer("300260"));
		AFRrequest.setRetrievalReferenceNumber("404006300260");
		AFRrequest.setDateAndTimeLocalTransaction("2021-10-26T21:32:52");
		AFRrequest.setAcquiringBin(new Integer("409999"));
		AFRrequest.setAcquirerCountryCode(101);
		AFRrequest.setSenderPrimaryAccountNumber("4895100000011112");
		AFRrequest.setSenderCardExpiryDate("2015-05");
		AFRrequest.setSenderCurrencyCode("CAD");
		AFRrequest.setAmount(new BigDecimal("112.00"));
		AFRrequest.setSurcharge(new BigDecimal("2.00"));
		AFRrequest.setForeignExchangeFeeTransaction(new BigDecimal("10.00"));
		AFRrequest.setTransactionIdentifier(new Long("481214059260001"));
		AFRrequest.setFeeProgramIndicator("123");

		Address aftrAddress = new Address();
		aftrAddress.setState("CA");
		aftrAddress.setCounty("081");
		aftrAddress.setCountry("USA");
		aftrAddress.setZipCode("94404");

		CardAcceptor aftrCardAcceptor = new CardAcceptor();
		aftrCardAcceptor.setName("Acceptor 1");
		aftrCardAcceptor.setTerminalId("365539");
		aftrCardAcceptor.setIdCode("VMT200911026070");

		aftrCardAcceptor.setAddress(aftrAddress);
		AFRrequest.setCardAcceptor(aftrCardAcceptor);

		OriginalDataElements ode = new OriginalDataElements();
		ode.setApprovalCode("000000");
		ode.setAcquiringBin(new Integer("409999"));
		ode.setDateAndTimeTransmission("2021-10-26T21:32:52");
		ode.setSystemsTraceAuditNumber(new Integer("897825"));

		AFRrequest.setOriginalDataElements(ode);

		PointOfServiceData posDatar = new PointOfServiceData();
		posDatar.setPanEntryMode("90");
		posDatar.setPosConditionCode(0);
		posDatar.setMotoECIIndicator("0");
		AFRrequest.setPointOfServiceData(posDatar);

		PointOfServiceCapability posCr = new PointOfServiceCapability();
		posCr.setPosTerminalEntryCapability(2);
		posCr.setPosTerminalType(4);
		AFRrequest.setPointOfServiceCapability(posCr);

		return AFRrequest;
	}

	public static OriginalCreditTransactionsRequest createrequestforOCT(
			HttpServletRequest req) {
		OriginalCreditTransactionsRequest OCTrequest = new OriginalCreditTransactionsRequest();

		CardAcceptor cardAcceptor = new CardAcceptor();

		Address address = new Address();
		address.setCountry("USA");
		address.setState("CA");
		address.setCounty("081");
		address.setZipCode("94105");

		cardAcceptor.setName("John Smith");
		cardAcceptor.setIdCode("VMT200911026070");
		cardAcceptor.setTerminalId("13655392");
		cardAcceptor.setAddress(address);

		OCTrequest.setSystemsTraceAuditNumber(new Integer(350420));
		OCTrequest.setRetrievalReferenceNumber("401010350420");
		OCTrequest.setDateAndTimeLocalTransaction("2021-10-26T21:32:52");
		OCTrequest.setAcquiringBin(409999);
		OCTrequest.setAcquirerCountryCode(new Integer(101));
		OCTrequest.setSenderReference("");
		OCTrequest.setSenderAccountNumber("4957030420210454");
		
		HttpSession session = req.getSession();
		String senderPAN=(String)session.getAttribute("senderPAN");
		
		if(senderPAN != null){
			OCTrequest.setSenderAccountNumber(senderPAN);
		}
		String recipientaccno=(String)session.getAttribute("recipientaccno");
		
		OCTrequest.setSenderCountryCode("USA");
		OCTrequest.setTransactionCurrency("USD");
		OCTrequest.setSenderName("John Smith");
		OCTrequest.setSenderAddress("44 Market St.");
		OCTrequest.setSenderCity("San Francisco");
		OCTrequest.setSenderStateCode("CA");
		OCTrequest.setRecipientCardPrimaryAccountNumber(recipientaccno);
		OCTrequest.setAmount(new BigDecimal(req.getParameter("amount")));
		OCTrequest.setBusinessApplicationID("AA");
		OCTrequest.setMerchantCategoryCode(6012);
		;
		OCTrequest.setTransactionIdentifier(new Long("234234322342343")
				.longValue());
		OCTrequest.setSourceOfFunds("03");
		OCTrequest.setCardAcceptor(cardAcceptor);
		OCTrequest.setFeeProgramIndicator("123");

		return OCTrequest;
	}

	public static AccountLookupRequest createAccountLookupRequest(
			HttpServletRequest req) {

		AccountLookupRequest LookupRequest = new AccountLookupRequest();
		LookupRequest.setSystemsTraceAuditNumber(new Integer(455690));
		LookupRequest.setRetrievalReferenceNumber("405060908072");
		LookupRequest.setAcquiringBin(409999);
		LookupRequest.setAcquirerCountryCode(101);
		LookupRequest.setPrimaryAccountNumber(req.getParameter("recipientCardNumber"));

		return LookupRequest;
	}

	public static AccountVerificationRequest createAccountverifyRequest(
			HttpServletRequest req) {

		AccountVerificationRequest AVrequest = new AccountVerificationRequest();
		CardAcceptor cardAcceptor = new CardAcceptor();

		Address address = new Address();
		address.setCountry("USA");
		address.setState("CA");
		address.setCounty("075");
		address.setZipCode("94404");
		address.setCity("San Francisco");

		StreetAddress street = new StreetAddress();

		street.setStreet("900 Metro Center Blv");
		street.setPostalCode("94404");

		cardAcceptor.setName("ABC");
		cardAcceptor.setIdCode("123");
		cardAcceptor.setTerminalId("45678");
		cardAcceptor.setAddress(address);

		AVrequest.setSystemsTraceAuditNumber(new Integer(701050));
		AVrequest.setRetrievalReferenceNumber("405012701050");
		AVrequest.setAcquiringBin(409999);
		AVrequest.setAcquirerCountryCode(101);
		AVrequest.setPrimaryAccountNumber("4957030420210462");
		AVrequest.setCardExpiryDate("2015-10");
		AVrequest.setCardCvv2Value("022");
		AVrequest.setCardAcceptor(cardAcceptor);
		AVrequest.setStreetAddress(street);

		return AVrequest;
	}

}
