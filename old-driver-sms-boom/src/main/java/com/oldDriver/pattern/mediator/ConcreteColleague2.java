package com.oldDriver.pattern.mediator;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-29 09:08
 */
public class ConcreteColleague2 extends Colleague {

    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }
    public void send(String message){
        mediator.send(message,this);
    }

    public void notify(String message){
        System.out.println("同事2得到消息" +message);
    }
}
