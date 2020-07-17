package com.oldDriver.pattern.state;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-17 09:34
 */
public class Context {
    private State state;

    public Context(State state){
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        System.out.println("当前状态：" + state.getClass().getName());
    }

    public void request(){
        state.handle(this);
    }
}
