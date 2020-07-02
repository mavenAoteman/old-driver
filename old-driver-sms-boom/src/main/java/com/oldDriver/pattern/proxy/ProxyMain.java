package com.oldDriver.pattern.proxy;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-02 09:22
 */
public class ProxyMain {
    public static void main(String[] args) {
        Girl girl = new Girl("教教");
        Proxy proxy = new Proxy(girl);
        proxy.giveDools();
        proxy.giveFlowlers();
    }
}
