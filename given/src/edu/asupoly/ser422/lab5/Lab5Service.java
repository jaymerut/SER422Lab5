package edu.asupoly.ser422.lab5;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public  class Lab5Service {
	// These are the possible queries
	/*private static String queryAll = "SELECT grade FROM Enrolled";
	private static String queryYear = "SELECT grade from Enrolled JOIN Student ON (Enrolled.sid=Student.id) WHERE year=";
	private static String querySubject = "SELECT grade from Enrolled JOIN Course ON (Enrolled.crsid=Course.id) WHERE subject='";
	private static String queryYearSubject = "SELECT grade from (Student JOIN Enrolled ON (Student.id=Enrolled.sid)) JOIN Course ON (Enrolled.crsid=Course.id) WHERE year=";

	private String __jdbcUrl    = null;
	private String __jdbcUser   = null;
	private String __jdbcPasswd = null;
	private String __jdbcDriver = null;*/

	// Singleton pattern
	private static Lab5Service __theService = null;

	public static final Lab5Service getService() throws Exception {
		if (__theService == null) {
			__theService = new Lab5Service();
		}
		return __theService;
	}

	private Lab5Service() throws Exception {
		Properties props = new Properties();
		try {
			InputStream propFile = this.getClass().getClassLoader().getResourceAsStream("lab5db.properties");
			props.load(propFile);
			propFile.close();
		}
		catch (IOException ie) {
			ie.printStackTrace();
			throw new Exception("Could not open property file");
		}

		/*__jdbcUrl    = props.getProperty("jdbc.url");
		__jdbcUser   = props.getProperty("jdbc.user");
		__jdbcPasswd = props.getProperty("jdbc.passwd");
		__jdbcDriver = props.getProperty("jdbc.driver"); 
		try {
			Class.forName(__jdbcDriver); // ensure the driver is loaded
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("*** Cannot find the JDBC driver");
			cnfe.printStackTrace();
			throw new Exception("Cannot initialize service from property file");
		} */
	}
}
