package com.spring.learning.service;

import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

@Service
public class LogReaderService {

	private final String bookServiceLog="";
	private final String revieweServiceLog="";
	private final String gatewayServiceLog="";
	private static final DateTimeFormatter LOG_TIME_FORMAT=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
	
	public String readRecentLogs(String filePath, int minutes) {
		return "";
	}
}
