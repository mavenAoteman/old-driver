package com.oldDriver.pattern.adapter;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-21 09:26
 */
public class AdpaterMain {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}
