package com.oldDriver.pattern.state;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-17 09:40
 */
public class StateMain {
    public static void main(String[] args) {
        Context c = new Context(new ConcreteStateA());
        c.request();
        c.request();
        c.request();
        c.request();
    }
}
