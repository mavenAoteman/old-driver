package com.oldDriver.pattern.memento;

/**
 * 备忘录模式
 *
 * @author mawenjie12
 * @date 2020-07-21 09:46
 */
public class Memento {
    private  String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
