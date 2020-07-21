package com.oldDriver.pattern.memento;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-21 09:44
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento(){
        return  new Memento(state);
    }

    public  void setMemento(Memento memento){
        state = memento.getState();
    }

    public void show(){
        System.out.println("State" + state);
    }
}
