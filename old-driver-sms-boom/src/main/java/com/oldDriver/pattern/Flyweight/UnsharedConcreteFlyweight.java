package com.oldDriver.pattern.Flyweight;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-30 09:17
 */
public class UnsharedConcreteFlyweight extends Flyweight {
    @Override
    public void operation(int extr) {
        System.out.println("不想共享的具体的Flyweight" + extr);
    }
}
