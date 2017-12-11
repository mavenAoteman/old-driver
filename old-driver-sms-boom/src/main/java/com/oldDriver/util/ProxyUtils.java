package com.oldDriver.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.http.HttpHost;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

/**
 * 
 * 
 * @Description:代理工具类
 * 
 * @author:lixin
 * 
 * @time:2016年8月31日 上午10:25:38
 */
public class ProxyUtils {

    private static final Logger LOGGER = Logger.getLogger(ProxyUtils.class);

    private static final Map<String, HttpHost> PROXIES_HOLDER = new ConcurrentHashMap<>();

    private static final List<String> PROXIES_KEY_HOLDER = Collections
            .synchronizedList(new ArrayList<String>());

    /**
     * 无参构造
     */
    private ProxyUtils() {

    }

    static {
        try {
            LineIterator lineIterator = IOUtils.lineIterator(
                    ProxyUtils.class.getResourceAsStream("/com/puhui/crawler/proxy/http_proxies.txt"),
                    "utf-8");
            while (lineIterator.hasNext()) {
                String proxyString = lineIterator.next();
                proxyString = proxyString.trim();
                if (proxyString.isEmpty()) {
                    continue;
                }
                String[] addr = proxyString.split(":");
                if (addr.length == 2) {
                    PROXIES_HOLDER.put(proxyString,
                            new HttpHost(addr[0], NumberUtils.toInt(addr[1]), "http"));
                    PROXIES_KEY_HOLDER.add(proxyString);
                } else if (addr.length == 3) {
                    PROXIES_HOLDER.put(proxyString,
                            new HttpHost(addr[0], NumberUtils.toInt(addr[1]), addr[2]));
                    PROXIES_KEY_HOLDER.add(proxyString);
                }
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * @author zhuyuhang
     * @param proxy 127.0.0.1:8080,127.0.0.1:8081
     */
    public static String reset(String proxy) {
        try {
            PROXIES_KEY_HOLDER.clear();
            PROXIES_HOLDER.clear();
            if (StringUtils.isNotBlank(proxy)) {
                for (String proxyString : proxy.split(",")) {
                    proxyString = proxyString.trim();

                    if (proxyString.isEmpty()) {
                        continue;
                    }
                    String[] addr = proxyString.split(":");
                    if (addr.length == 2) {
                        PROXIES_HOLDER.put(proxyString,
                                new HttpHost(addr[0], NumberUtils.toInt(addr[1]), "http"));
                        PROXIES_KEY_HOLDER.add(proxyString);
                    } else if (addr.length == 3) {
                        PROXIES_HOLDER.put(proxyString,
                                new HttpHost(addr[0], NumberUtils.toInt(addr[1]), addr[2]));
                        PROXIES_KEY_HOLDER.add(proxyString);
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return e.getMessage();
        }
        return JSON.toJSONString(PROXIES_HOLDER);
    }

    public static Map<String, HttpHost> getProxiesHolder() {
        return PROXIES_HOLDER;
    }

    /**
     * 随机获取ip
     * 
     * @return host
     */
    public static HttpHost getProxyHost() {
        int size = PROXIES_HOLDER.size();
        int index = new Random().nextInt(size);
        LOGGER.info("size ->" + size + ",index ->" + index);
        if (PROXIES_KEY_HOLDER.size() > index) {
            return PROXIES_HOLDER.get(PROXIES_KEY_HOLDER.get(index));
        }
        return null;
    }

    /**
     * 
     * @param httpHost
     */
    public static void removeProxyHost(HttpHost httpHost) {
        if (httpHost != null) {
            String key = httpHost.getHostName() + ":" + httpHost.getPort()
                    + (httpHost.getSchemeName().equals("http") ? "" : httpHost.getSchemeName());
            PROXIES_KEY_HOLDER.remove(key);
            PROXIES_HOLDER.remove(key);
        }
    }

    /**
     * 主方法
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        HttpHost host = getProxyHost();
        LOGGER.info(host.getHostName() + "\t" + host.getPort() + host.getAddress());
    }
}
