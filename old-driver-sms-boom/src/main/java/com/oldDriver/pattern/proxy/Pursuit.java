package com.oldDriver.pattern.proxy;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-02 09:16
 */
public class Pursuit implements  GiveGift {
    private  Girl girl;

    public Pursuit(Girl girl){
        this.girl = girl;
    }
    @Override
    public void giveFlowlers() {
        System.out.println("送你小花花");
    }

    @Override
    public void giveDools() {
        System.out.println("送你洋娃娃");
    }
}
