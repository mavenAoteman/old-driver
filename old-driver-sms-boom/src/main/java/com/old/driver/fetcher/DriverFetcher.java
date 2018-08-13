package com.old.driver.fetcher;

import java.io.IOException;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.log4j.Logger;

public class DriverFetcher {
	private static final Logger logger = Logger.getLogger(DriverFetcher.class);
	protected CloseableHttpClient client;
	protected CookieStore cookieStore = new BasicCookieStore();
	private String phone;

	private String userName;

	private String password;

	private String userId;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public static Logger getLogger() {
		return logger;
	}

	
	/**
	 * 关闭client
	 */
	private void close() {
		if(this.client !=null) {
			try {
				client.close();
			} catch (IOException e) {
				logger.error(e.getMessage(),e);
			}
		}
	}

}
