package com.oldDriver.pattern.state;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-17 09:35
 */
public class ConcreteStateB extends  State {
    @Override
    public void handle(Context context) {
        context.setState(new ConcreteStateA());
    }
}
