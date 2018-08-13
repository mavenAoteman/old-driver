package com.old.driver.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * @Description:读取配置文件工具类
 * @author:lixin
 * @time:2016年8月31日 上午11:48:50
 */
public class PropertiesUtil {
    private static final ConcurrentHashMap<String, Properties> PROPS_HOLDER = new ConcurrentHashMap<>();

    public static final String PRE_PROPS = "/com/puhui/crawler/mail/props/";

    private static final String SUF_PROPS = ".properties";

    private static final Logger log = Logger.getLogger(PropertiesUtil.class);

    private static Properties BANK_PROPS = null;

    private static Properties CREDIT_PROPS = null;

    private static Properties DEFAULT_PROPS = null;

    private PropertiesUtil() {
    }

    /**
     * 获取默认配置
     * 
     * @author zhuyuhang
     * @param key
     * @return
     */
    public static String getProps(String key) {
        return getProps(key, null);
    }

    /**
     * @param key
     * @param defVal
     * @return
     */
    public static String getProps(String key, String defVal) {
        if (DEFAULT_PROPS == null) {
            synchronized (PropertiesUtil.class) {
                if (DEFAULT_PROPS == null) {
                    DEFAULT_PROPS = readPropertiesFile("/client_spconf.properties");
                }
            }
        }
        return DEFAULT_PROPS.getProperty(key);
    }

    /**
     * 设置client_spconf.properties里的参数
     * 
     * @author zhuyuhang
     * @param key
     * @param value
     */
    public static void setProps(String key, String value) {
        if (DEFAULT_PROPS == null) {
            synchronized (PropertiesUtil.class) {
                if (DEFAULT_PROPS == null) {
                    DEFAULT_PROPS = readPropertiesFile("/client_spconf.properties");
                }
            }
        }
        DEFAULT_PROPS.setProperty(key, value);
    }

    /**
     * 设置client_spconf.properties里的参数
     * 
     * @author zhuyuhang
     * @param key
     * @param value
     */
    public static void reloadProps() {
        synchronized (PropertiesUtil.class) {
            DEFAULT_PROPS = readPropertiesFile("/client_spconf.properties");
        }
    }

    /**
     * @return
     */
    public static Set<Object> defaultPropKeys() {
        if (DEFAULT_PROPS == null) {
            synchronized (PropertiesUtil.class) {
                DEFAULT_PROPS = readPropertiesFile("/client_spconf.properties");
            }
        }
        return DEFAULT_PROPS.keySet();
    }

    /**
     * 获取银行借记卡配置文件
     * 
     * @author liuheli
     * @param key
     * @return
     */
    public static String getBankProps(String key) {
        if (BANK_PROPS == null) {
            synchronized (PropertiesUtil.class) {
                BANK_PROPS = readPropertiesFile("/bank_spconf.properties");
            }
        }
        if ("BANK.INFO.DIR".equals(key)) {
            return BANK_PROPS.getProperty(key) + DateUtils.getDateStr() + "/";
        } else {
            return BANK_PROPS.getProperty(key);
        }
    }

    /**
     * 设置bank_spconf.properties里的参数
     * 
     * @author zhuyuhang
     * @param key
     * @param value
     */
    public static void reloadtBankProps() {
        synchronized (PropertiesUtil.class) {
            BANK_PROPS = readPropertiesFile("/bank_spconf.properties");
        }
    }

    /**
     * 获取银行借记卡配置文件
     * 
     * @author liuheli
     * @param key
     * @return
     */
    public static int getBankProps4Int(String key) {
        if (BANK_PROPS == null) {
            synchronized (PropertiesUtil.class) {
                if (BANK_PROPS == null) {
                    BANK_PROPS = readPropertiesFile("/bank_spconf.properties");
                }
            }
        }
        return Integer.parseInt(BANK_PROPS.getProperty(key));
    }

    /**
     * 获取银行信用卡配置文件
     * 
     * @author liuheli
     * @param key
     * @return
     */
    public static String getCreditProps(String key) {
        if (CREDIT_PROPS == null) {
            synchronized (PropertiesUtil.class) {
                if (CREDIT_PROPS == null) {
                    CREDIT_PROPS = readPropertiesFile("/bank_ccconf.properties");
                }
            }
        }
        return CREDIT_PROPS.getProperty(key);
    }

    /**
     * 设置bank_ccconf.properties里的参数
     * 
     * @author zhuyuhang
     * @param key
     * @param value
     */
    public static void reloadtCreditProps() {
        synchronized (PropertiesUtil.class) {
            CREDIT_PROPS = readPropertiesFile("/bank_ccconf.properties");
        }
    }

    /**
     * 设置所有配置里的参数
     * 
     * @author zhuyuhang
     * @param key
     * @param value
     */
    public static void reloadAllProps() {
        reloadProps();
        reloadtBankProps();
        reloadtCreditProps();
    }

    /**
     * 获取银行信用卡配置文件
     * 
     * @author liuheli
     * @param key
     * @return
     */
    public static int getCreditProps4Int(String key) {
        if (CREDIT_PROPS == null) {
            synchronized (PropertiesUtil.class) {
                if (CREDIT_PROPS == null) {
                    CREDIT_PROPS = readPropertiesFile("/bank_ccconf.properties");
                }
            }
        }
        return Integer.parseInt(CREDIT_PROPS.getProperty(key));
    }

    /**
     * @param file
     * @return
     */
    public static Properties readPropertiesFile(String file) {
        InputStream in = PropertiesUtil.class.getResourceAsStream(file);
        Properties prop = new Properties();
        try {
            prop.load(in);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
        return prop;
    }

    /**
     * @param email
     * @return
     */
    public static Properties getPropsByEmail(String email) {
        String key = parseEmail(email);
        if (PROPS_HOLDER.get(key) != null) {
            return PROPS_HOLDER.get(key);
        }
        InputStream in = PropertiesUtil.class.getResourceAsStream(PRE_PROPS + key + SUF_PROPS);
        Properties prop = new Properties();
        try {
            if (in != null) {
                prop.load(in);
                PROPS_HOLDER.putIfAbsent(key, prop);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
        return prop;
    }

    /**
     * @param email
     * @return
     */
    public static String parseEmail(String email) {
        if (StringUtils.isNotBlank(email)) {
            String[] arr = email.split("@");
            return arr[arr.length - 1];
        }
        return null;
    }

}
