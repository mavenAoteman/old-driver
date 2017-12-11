package com.oldDriver.fetcher;

import org.apache.log4j.Logger;

public class DriverFetcher {
    private static final Logger logger = Logger.getLogger(DriverFetcher.class);
    
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
     * 轰炸主方法
     * @param phone
     */
    public void boom(String phone) {
        
    }
    

}
