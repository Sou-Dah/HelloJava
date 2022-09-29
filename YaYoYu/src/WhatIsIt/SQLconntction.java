package WhatIsIt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class SQLconntction {
	public static void main(String[] args) throws ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/cities" +
		             "?serverTimezone=Europe/Moscow",
				lg = "root",
				pw = "";
		String str;
		try {
//			Driver driver = new com.mysql.cj.jdbc.Driver();
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
//				SQLException
			e.printStackTrace();
		}
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.println("     URL: "+url+"\n   Login: root");
			if (pw.equals("")) {
				System.out.print("Password: ");
//				pw = br.readLine();
			}
			Statement st;
			ResultSet rs;
			try (Connection cc = DriverManager.getConnection(url, lg, br.readLine());) {
//			    Connection cc = DriverManager.getConnection(url);
//			    Connection cc = DriverManager.getConnection(url, Properties);
//				Connection cc = DriverManager.getConnection(url, lg, pw);
				st = cc.createStatement();
				while (!(str = br.readLine()).equals("end")) {
					rs = st.executeQuery(str);
					
					while (rs.next()) {
						System.out.println(rs.getString(1));
					}
					
					rs.close();
				}
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				pw = "";
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}