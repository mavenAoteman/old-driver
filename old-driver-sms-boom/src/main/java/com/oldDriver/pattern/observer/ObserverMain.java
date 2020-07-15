package com.oldDriver.pattern.observer;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-15 09:48
 */
public class ObserverMain {
    public static void main(String[] args) {
        ConcreteSubject s = new ConcreteSubject();
        s.attach(new ConcreteObserver(s,"张三"));
        s.attach(new ConcreteObserver(s,"李四"));
        s.attach(new ConcreteObserver(s,"王五"));
        s.setSubjectState("ABC");
        s.notifyObservers();
    }
}
