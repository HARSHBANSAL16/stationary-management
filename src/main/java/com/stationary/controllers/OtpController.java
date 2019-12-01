package com.stationary.controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stationary.constant.ApplicationConstant;
import com.stationary.services.OtpService;
import com.stationary.util.RestUtil;
import com.stationary.util.SmsUtil;

@RestController
public class OtpController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	public OtpService otpService;
	
	@GetMapping("/generateOtp")
	public int generateOtp(@RequestParam("empId") int empId, @RequestParam("phoneNo") String phoneNo, @RequestParam("name") String name) {
		
		int otp = otpService.generateOTP(String.valueOf(empId));
		logger.info("OTP : " + otp);
		
		//Generate The Template to send OTP 
		final Map<String, Object> params =
                SmsUtil.buildParams(phoneNo, SmsUtil.buildSmsBody(String.valueOf(otp)));
        RestUtil.get(ApplicationConstant.BASE_URL_SMS, params);
        
        return otp;
        
	}

	@GetMapping("/validateOtp/")
	public @ResponseBody String validateOtp(@RequestParam("empId") int empId, @RequestParam("otpnum") int otpnum) {
		final String SUCCESS = "Entered Otp is valid";
		final String FAIL = "Entered Otp is NOT valid. Please Retry!";

		logger.info(" Otp Number : " + otpnum);

		//Validate the Otp 
		if (otpnum >= 0) {
			int serverOtp = otpService.getOtp(String.valueOf(empId));
			if (serverOtp > 0) {
				if (otpnum == serverOtp) {
					otpService.clearOTP(String.valueOf(empId));
					return ("Entered Otp is valid");
				} else {
					return SUCCESS;
				}
			} else {
				return FAIL;
			}
		} else {
			return FAIL;
		}
	}
}