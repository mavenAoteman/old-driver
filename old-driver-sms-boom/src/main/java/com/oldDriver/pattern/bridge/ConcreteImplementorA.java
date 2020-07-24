package com.oldDriver.pattern.bridge;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-24 09:19
 */
public class ConcreteImplementorA extends Implementor {
    @Override
    public void operation() {
        System.out.println("A类的具体实现");
    }
}
