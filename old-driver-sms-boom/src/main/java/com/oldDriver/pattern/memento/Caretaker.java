package com.oldDriver.pattern.memento;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-21 09:48
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
