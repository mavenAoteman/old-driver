package com.oldDriver.fetcher;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.log4j.Logger;

import com.mchange.v1.io.InputStreamUtils;
import com.oldDriver.util.HttpUtils;
import org.springframework.stereotype.Component;

@Component
public class OldDriverFetcher extends DriverFetcher {
    private static final Logger logger = Logger.getLogger(OldDriverFetcher.class);




    private static String script1;

    private static String script2;

    private static String script3;
    static {
        try {
            InputStream is = OldDriverFetcher.class
                    .getResourceAsStream("/com/puhui/crawler/mobile/ct_fj/BigInt.js");
            script1 = InputStreamUtils.getContentsAsString(is, HttpUtils.UTF_8);
            is = OldDriverFetcher.class.getResourceAsStream("/com/puhui/crawler/mobile/ct_fj/Barrett.js");
            script2 = InputStreamUtils.getContentsAsString(is, HttpUtils.UTF_8);
            is = OldDriverFetcher.class.getResourceAsStream("/com/puhui/crawler/mobile/ct_fj/RSA.js");
            script3 = InputStreamUtils.getContentsAsString(is, HttpUtils.UTF_8);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.oldDriver.fetcher.DriverFetcher#boom(java.lang.String)
     */
    public void boom() {
        boomXiaoDing();
//        boomXinRong();
        boomZhiNanZhen();
        boomHeXinDai();
    }

    /**
     * 小顶网
     * 
     * @param phone
     * @return
     */
    private boolean boomXiaoDing() {// http://yt.juqiwang.net/bj/dk/20170706/index?dkbjbdpc/-15-01-0000-0100#cl2
        String url = "http://admin.dggjqw.com/api/consult/add.do?" + "callback=jQuery1102048561618402372664_"
                + System.currentTimeMillis() + "&name=%E5%BC%A0%E4%B8%89"// 默认张三
                + "&tel=" + getPhone() + "&content=30000"// 默认3万
                + "&type=dk" + "&place=bj" + "&device=pc" + "&web=xdw" + "&_=" + System.currentTimeMillis();

        logger.info(getPhone()+url);
        HttpGet get = HttpUtils.get(url);
        get.addHeader("Accept", "*/*");
        get.addHeader("Accept-Encoding", "gzip, deflate");
        get.addHeader("Accept-Language", "en-US,en;q=0.5");
        get.addHeader("Referer", "http://yt.juqiwang.net/bj/dk/20170706/index?dkbjbdpc/-15-01-0000-0100");
        try {
            String content = HttpUtils.executeGetWithResult(client, get);
            logger.info(getPhone()+content);
            if (content.contains("成功")) {
                logger.info("小顶网针 boom SUCCESS!!");
                return true;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * boom 信融财富 暂时不可用
     * 
     * @return
     */
    private boolean boomXinRong() {// https://www.xinrong.com/register/fast.html?c=abd
        String url = "https://www.xinrong.com/v2/register/register_tel_captcha_check_ip_and_phone.jso";
        logger.info(getPhone()+url);
        Map<String, Object> params = new HashMap<>();
        params.put("sd", System.currentTimeMillis());
        params.put("tellPhone", getPhone());
        params.put("type", "0");
        params.put("word", "");
        HttpPost post = HttpUtils.post(url, params);
        post.addHeader("Accept", "aplication/json, text/javascript, */*; q=0.01");
        post.addHeader("Accept-Encoding", "gzip, deflate, br");
        post.addHeader("Accept-Language", "en-US,en;q=0.5");
        post.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        post.addHeader("Referer", "https://www.xinrong.com/register/fast.html?c=abd");
        try {
            String content = HttpUtils.executePostWithResult(client, post);
            logger.info(getPhone()+content);
            if (content.contains("result\":true")) {
                logger.info("信融 boom SUCCESS!!");
                return true;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * boom 指南针 一家炒股公司
     * 
     * @param phone
     */
    private boolean boomZhiNanZhen() {// http://qy.compass.cn/fenfen2.php?from=baidu_1_17804650_665761281_9625319002_17393673811
        String url = "http://boyi.compass.cn/reg/intreg.php?callback=jQuery16308192311421604185_"
                + System.currentTimeMillis() + "&phone=" + encrypt(getPhone()) + "&name=%E5%BC%A0%E4%B8%89"// 默认为张三
                + "&fromwhere=baidu_1_17804650_665761281_9625319002_17393673811" + "&type=16" + "&_="
                + System.currentTimeMillis();
        logger.info(getPhone()+url);
        HttpGet get = HttpUtils.get(url);
        get.addHeader("Accept", "*/*");
        get.addHeader("Accept-Encoding", "gzip, deflate");
        get.addHeader("Accept-Language", "en-US,en;q=0.5");
        get.addHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:58.0) Gecko/20100101 Firefox/58.0");
        get.addHeader("Referer", "http://qy.compass.cn/fenfen2.php");
        try {
            String content = HttpUtils.executeGetWithResult(client, get);
            logger.info(getPhone()+content);
            if (content.contains("result\":true")) {
                logger.info("指南针 boom SUCCESS!!");
                return true;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    private boolean boomHeXinDai() {//和信贷  一家贷款网址
        String url = "https://app4.hexindai.com/guest/spot?phone=" + getPhone()
                + "&page=HXLoginViewController";
        logger.info(getPhone()+url);
        HttpGet get = HttpUtils.get(url);
        get.setHeader("Accept", "*/*");
        get.setHeader("Accept-Encoding", "br, gzip, deflate");
        get.setHeader("Accept-Language", "zh-cn");
        get.setHeader("User-Agent", "CreditHe/4020");
        try {
            String content = HttpUtils.executeGetWithResult(client, get);
            logger.info(getPhone()+content);
            if(content.contains("ret_code\": 0")) {
                logger.info("和信贷 boom SUCCESS!!");
                return true;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return false;
    }

    private String encrypt(String password) {
        try {
            String maxDigits = "67";
            String email_empoent;
            String email_module;
            email_empoent = "10001";
            email_module = "EC44CB7EB6131B59BCAAA03297309FD8334E7D5E3D780AD585186599C11DD309C15E4D9F330295C21237DBA3D2671EC05E7BA98527A53361279BADDB3E9581AD";
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
            engine.eval(script1);
            engine.eval(script2);
            engine.eval(script3);
            String script4 = "function justDoId(){setMaxDigits(" + Integer.parseInt(maxDigits)
                    + "); var key = new RSAKeyPair('" + email_empoent + "','','" + email_module
                    + "'); return encryptedString(key, '" + password + "');}";
            engine.eval(script4);
            if (engine instanceof Invocable) {
                Invocable in = (Invocable) engine;
                String result = (String) in.invokeFunction("justDoId", new Object[0]);
                logger.info("调用js加密密码，加密前为[" + password + "],加密后为[" + result + "]");
                return result;
            }
        } catch (Exception e) {
            logger.error("加密字符串出错", e);
        }
        return password;
    }

    public static void main(String[] args) {
        OldDriverFetcher old = new OldDriverFetcher();
        old.setPhone("18842861234");
        old.boom();
    }

}
