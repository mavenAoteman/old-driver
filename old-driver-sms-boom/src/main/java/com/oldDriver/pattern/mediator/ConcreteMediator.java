package com.oldDriver.pattern.mediator;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-29 09:07
 */
public class ConcreteMediator extends  Mediator {
    private  ConcreteColleague1 concreteColleague1;
    private  ConcreteColleague2 concreteColleague2;
    @Override
    public void send(String message, Colleague colleague) {
        if(colleague == concreteColleague1){
            concreteColleague2.notify(message);
        }else {
            concreteColleague1.notify(message);
        }
    }

    public void setConcreteColleague1(ConcreteColleague1 concreteColleague1) {
        this.concreteColleague1 = concreteColleague1;
    }

    public void setConcreteColleague2(ConcreteColleague2 concreteColleague2) {
        this.concreteColleague2 = concreteColleague2;
    }
}
