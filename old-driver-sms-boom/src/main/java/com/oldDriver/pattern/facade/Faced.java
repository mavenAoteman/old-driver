package com.oldDriver.pattern.facade;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-14 09:08
 */
public class Faced {
    SubSystemOne one;
    SubSystemTwo two;

    public Faced(){
        one = new SubSystemOne();
        two = new SubSystemTwo();
    }

    public void methodA(){
        System.out.println("方法A（）");
        one.methodOne();
        two.methodTwo();
    }

    public void methodB(){
        System.out.println("方法B（）");
        two.methodTwo();
        one.methodOne();
    }

}
