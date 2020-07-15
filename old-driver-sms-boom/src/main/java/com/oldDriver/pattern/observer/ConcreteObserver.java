package com.oldDriver.pattern.observer;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-15 09:45
 */
public class ConcreteObserver extends Observer {
    private String name;
    private String observerState;
    private ConcreteSubject subject;

    /**
     *
     * @param subject
     * @param name
     */
    public ConcreteObserver(ConcreteSubject subject, String name) {
        this.subject = subject;
        this.name = name;
    }

    @Override
    public void update() {
        observerState = subject.getSubjectState();
        System.out.println("观察者" + name + "的新状态是" + observerState);
    }

    public ConcreteSubject getSubject() {
        return subject;
    }

    public void setSubject(ConcreteSubject subject) {
        this.subject = subject;
    }
}
