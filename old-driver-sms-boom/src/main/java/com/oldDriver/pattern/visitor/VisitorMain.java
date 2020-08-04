package com.oldDriver.pattern.visitor;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-08-04 09:30
 */
public class VisitorMain {
    public static void main(String[] args) {
        ObjectStructure o = new ObjectStructure();
        o.attach(new ConcreteElementA());
        o.attach(new ConcreteElementB());

        ConcreteVisitor1 v1 = new ConcreteVisitor1();
        ConcreteVisitor2 v2 = new ConcreteVisitor2();
        o.accept(v1);
        o.accept(v2);
    }
}
