/*
 * Lab5Servlet.java
 *
 * Copyright:  2008 Kevin A. Gary All Rights Reserved
 *
 */
package edu.asupoly.ser422.lab5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * @author Kevin Gary
 *
 */
@SuppressWarnings("serial")
@WebServlet("/lab5calc")
public class Lab5CalcServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		StringBuffer pageBuf = new StringBuffer();
		pageBuf.append("This is a test for Lab5Calc");
		/*
		double grade;
		String year = req.getParameter("year");
		String subject = req.getParameter("subject");

		if (year != null && !year.trim().isEmpty()) {
			pageBuf.append("<br/>Year: " + year);
		}
		if (subject != null && !subject.trim().isEmpty()) {
			pageBuf.append("<br/>Subject: " + subject);
		}

		Lab5CalcService service = null;
		try {
			service = Lab5CalcService.getService();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (service == null) {
			pageBuf.append("\tSERVICE NOT AVAILABLE");
		} else {
			grade = service.calculateGrade(year, subject);
			pageBuf.append("\n\t<br/>Grade: " + grade);
			//pageBuf.append("\n\t<br/>Letter: " + service.mapToLetterGrade(grade));
		}

		*/
		// some generic setup - our content type and output stream
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		out.println(pageBuf.toString());
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}
}
