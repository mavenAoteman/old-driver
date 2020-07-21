package com.oldDriver.pattern.memento;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-21 09:49
 */
public class MementoMain {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("on");
        originator.show();
        Caretaker c = new Caretaker();
        c.setMemento(originator.createMemento());
        originator.setState("off");
        originator.show();
        originator.setMemento(c.getMemento());
        originator.show();

    }

}
