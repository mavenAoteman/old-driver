package com.oldDriver.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-15 09:37
 */
public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    /**
     * 增加观察者
     *
     * @param observer
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 移除观察者
     * @param observer
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知观察者
     */
    public void notifyObservers() {
        for (Observer observer :observers) {
            observer.update();
        }
    }

}
