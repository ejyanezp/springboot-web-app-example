package com.awsec2.eywebappdemo.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping("/login")
	@ResponseBody
	public String login() {
		try {
			InetAddress ip = InetAddress.getLocalHost();
			String hostname = ip.getHostName();
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			System.out.println("Request log at: " + sdf2.format(timestamp));
			return "Your current Hostname : " + hostname + "<br>" + sdf2.format(timestamp);
		} 
		catch (UnknownHostException ex) {
			return "Unknown host!";
		}
	}

	// Assign the web resource "/" for the health check.
	@RequestMapping("/")
	@ResponseBody
	public String healthy() {
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println("Health check at: " + sdf2.format(timestamp));
		return "Healthy at: " + sdf2.format(timestamp);
	}

}
