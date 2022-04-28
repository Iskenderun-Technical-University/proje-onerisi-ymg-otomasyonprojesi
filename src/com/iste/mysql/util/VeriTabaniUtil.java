package com.iste.mysql.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class VeriTabaniUtil {
	static Connection conn = null;

	public static Connection Baglan() {
		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx", "root", "1234");
			return conn;
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
		}

	}

	public static String MD5Sifreleme(String icerik) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] sifrelenmis = md.digest(icerik.getBytes());

			BigInteger no = new BigInteger(1, sifrelenmis);
			String hshIcerik = no.toString(16);

			while (hshIcerik.length() < 32) {
				hshIcerik = "0" + hshIcerik;
			}

			return hshIcerik;
		} catch (NoSuchAlgorithmException e) {
			throw new  RuntimeException(e);
		}

	}

}
