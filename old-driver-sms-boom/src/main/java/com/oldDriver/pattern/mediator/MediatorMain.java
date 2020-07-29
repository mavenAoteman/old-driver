package com.oldDriver.pattern.mediator;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-29 09:14
 */
public class MediatorMain {
    public static void main(String[] args) {
        ConcreteMediator concreteMediator = new ConcreteMediator();
        ConcreteColleague1 concreteColleague1 = new ConcreteColleague1(concreteMediator);
        ConcreteColleague2 concreteColleague2 = new ConcreteColleague2(concreteMediator);
        concreteMediator.setConcreteColleague1(concreteColleague1);
        concreteMediator.setConcreteColleague2(concreteColleague2);
        concreteColleague1.send("ni吃饭了么");
        concreteColleague2.send("没吃呢 你打算请客么");
    }
}
