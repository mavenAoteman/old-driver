package com.oldDriver.pattern.visitor;

/**
 * 访问者模式
 *
 * @author mawenjie12
 * @date 2020-08-04 09:18
 */
public  abstract class Visitor {
    public abstract void visitConcreteElementA(ConcreteElementA concreteElementA);
    public abstract void visitConcreteElementB(ConcreteElementB concreteElementB);

}
