/*
 * Lab5Servlet.java
 *
 * Copyright:  2008 Kevin A. Gary All Rights Reserved
 *
 */
package edu.asupoly.ser422.lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.*;
import javax.servlet.http.*;

import com.google.gson.Gson;
import com.sun.org.apache.xerces.internal.util.URI;

import sun.net.www.http.HttpClient;

/**
 * @author Kevin Gary
 *
 */
@SuppressWarnings("serial")
public class Lab5Servlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		StringBuffer pageBuf = new StringBuffer();
		double grade;
		//String year = req.getParameter("year");
		//String subject = req.getParameter("subject");

		
		//--------------------
		//Make sure to change to use lab5servlet.properties variables
		URL urlCalc = new URL("http://localhost:8081/lab5calc");
		HttpURLConnection conCalc = (HttpURLConnection) urlCalc.openConnection();
		conCalc.setRequestMethod("GET");
		//--------------------
		
		BufferedReader readerCalc = new BufferedReader(new InputStreamReader(conCalc.getInputStream(),"utf-8"));
        String outputCalc = null;  
        while ((outputCalc = readerCalc.readLine()) != null)  
        	pageBuf.append(outputCalc);  	
		
		//--------------------
		//Make sure to change to use lab5servlet.properties variables
		URL urlMap = new URL("http://localhost:8081/lab5map");
		HttpURLConnection conMap = (HttpURLConnection) urlMap.openConnection();
		conMap.setRequestMethod("GET");
		//--------------------
		
		BufferedReader readerMap = new BufferedReader(new InputStreamReader(conMap.getInputStream(),"utf-8"));
        String outputMap = null;  
        while ((outputMap = readerMap.readLine()) != null)  
        	pageBuf.append(outputMap);
		
		/*if (year != null && !year.trim().isEmpty()) {
			pageBuf.append("<br/>Year: " + year);
		}
		if (subject != null && !subject.trim().isEmpty()) {
			pageBuf.append("<br/>Subject: " + subject);
		}

		Lab5Service service = null;
		try {
			service = Lab5Service.getService();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (service == null) {
			pageBuf.append("\tSERVICE NOT AVAILABLE");
		} else {
		//	grade = service.calculateGrade(year, subject);
		//	pageBuf.append("\n\t<br/>Grade: " + grade);
		//	pageBuf.append("\n\t<br/>Letter: " + service.mapToLetterGrade(grade));
		}*/

		// some generic setup - our content type and output stream
        String json = new Gson().toJson(pageBuf);
		res.setContentType("application/json");
		res.getWriter().write(json);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}
}
