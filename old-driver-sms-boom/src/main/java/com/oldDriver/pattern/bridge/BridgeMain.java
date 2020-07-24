package com.oldDriver.pattern.bridge;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-24 09:24
 */
public class BridgeMain {
    public static void main(String[] args) {
        Abstraction ab = new Abstraction();
        ab.setImplementor(new ConcreteImplementorA());
        ab.operation();
        ab.setImplementor(new ConcreteImplementorB());
        ab.operation();
    }
}
