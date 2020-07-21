package com.oldDriver.pattern.adapter;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-21 09:23
 */
public class Adapter implements Target {
    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
