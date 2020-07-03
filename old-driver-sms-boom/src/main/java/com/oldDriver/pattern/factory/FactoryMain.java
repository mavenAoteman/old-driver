package com.oldDriver.pattern.factory;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-03 09:28
 */
public class FactoryMain {
    public static void main(String[] args) {
        IFactory factory = new StudentFactory();
        LeiFeng leiFeng = factory.createLeiFeng();
        leiFeng.sweep();
        leiFeng.wash();
    }
}
