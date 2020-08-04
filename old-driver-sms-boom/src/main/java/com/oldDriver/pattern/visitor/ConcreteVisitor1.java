package com.oldDriver.pattern.visitor;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-08-04 09:23
 */
public class ConcreteVisitor1 extends  Visitor {
    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        System.out.println(concreteElementA.getClass().getName() + "被"+this.getClass().getName()  + "访问");
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
        System.out.println(concreteElementB.getClass().getName() + "被"+this.getClass().getName()  + "访问");

    }
}
