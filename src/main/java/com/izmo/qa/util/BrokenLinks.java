package com.izmo.qa.util;

import java.net.HttpURLConnection;
import java.net.URL;

public class BrokenLinks {

	public static boolean verifyLinkActive(String linkUrl) {
		try {
			URL url = new URL(linkUrl);

			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();

			httpURLConnect.setConnectTimeout(3000);

			httpURLConnect.connect();

			if (httpURLConnect.getResponseCode() >= 400) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
				return true;
			} else if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_NOT_FOUND);
				return false;
			}
		} catch (Exception e) {

			// return Data;
			return false;

		}
		return false;
	}
}	
	
