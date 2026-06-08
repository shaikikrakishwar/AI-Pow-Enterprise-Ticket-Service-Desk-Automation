package com.project.ai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.util.DBConnection;

public class DuplicateTicketDetector {

	public static boolean isDuplicate(
	        String title,
	        String description) {

	    try {

	        Connection con =
	                DBConnection.getConnection();

	        PreparedStatement ps =
	                con.prepareStatement(
	                "SELECT title FROM tickets");

	        ResultSet rs =
	                ps.executeQuery();

	        while(rs.next()) {

	            String existingTitle =
	                    rs.getString("title")
	                    .toLowerCase();

	            if(existingTitle.equals(
	                    title.toLowerCase())) {

	                return true;
	            }
	        }

	    } catch(Exception e) {

	        e.printStackTrace();
	    }

	    return false;
	}
}