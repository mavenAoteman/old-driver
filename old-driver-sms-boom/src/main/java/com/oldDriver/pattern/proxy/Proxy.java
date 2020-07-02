package com.oldDriver.pattern.proxy;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-02 09:20
 */
public class Proxy implements GiveGift {
    Pursuit pursuit;
    public Proxy(Girl girl){
        pursuit = new Pursuit(girl);
    }

    @Override
    public void giveFlowlers() {
        pursuit.giveFlowlers();
    }

    @Override
    public void giveDools() {
        pursuit.giveDools();
    }
}
