//package com.oldDriver.util;
//
//import java.io.Closeable;
//import java.io.IOException;
//
//import org.apache.log4j.Logger;
//
//import com.puhui.crawler.mobile.MobileMoXieFetcher;
//
//import net.sf.ehcache.Cache;
//import net.sf.ehcache.CacheManager;
//import net.sf.ehcache.Element;
//
///**
// * @author finup
// *
// */
//public class CacheUtils {
//	private static final Logger logger = Logger.getLogger(CacheUtils.class);
//	public static final CacheManager CACHE_MANAGER = new CacheManager(
//			CacheUtils.class.getResourceAsStream("/ehcache.xml"));
//	private static final Cache MOBILE_CACHE = CACHE_MANAGER.getCache("mobile");
//
//	private CacheUtils() {
//	}
//
//	/**
//	 * 手机抓取器
//	 * 
//	 * @author zhuyuhang
//	 * @param key
//	 * @param mobileFetcher
//	 */
//	public static void putMoblieFetcher(String key, MobileMoXieFetcher mobileMoXieFetcher) {
//		Element element = MOBILE_CACHE.get(key);
//		if (element != null && element.getObjectValue() != null && element.getObjectValue() instanceof Closeable) {
//			try {
//				((Closeable) element.getObjectValue()).close();
//			} catch (IOException e) {
//				logger.error(e.getMessage(), e);
//			}
//		}
//		MOBILE_CACHE.put(new Element(key, mobileMoXieFetcher));
//	}
//
//	/**
//	 * 手机抓取器
//	 * 
//	 * @author zhuyuhang
//	 * @param key
//	 * @return
//	 */
//	public static MobileMoXieFetcher getMoblieFetcher(String key) {
//		Element element = MOBILE_CACHE.get(key);
//		if (element != null) {
//			return (MobileMoXieFetcher) element.getObjectValue();
//		}
//		return null;
//	}
//
//	/**
//	 * 删除手机抓取器
//	 * 
//	 * @author zhuyuhang
//	 * @param key
//	 */
//	public static void removeMoblieFetcher(String key) {
//		MOBILE_CACHE.remove(key);
//	}
//
//}
