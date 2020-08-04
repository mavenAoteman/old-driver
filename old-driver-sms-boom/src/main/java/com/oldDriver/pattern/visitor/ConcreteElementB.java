package com.oldDriver.pattern.visitor;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-08-04 09:20
 */
public class ConcreteElementB extends  Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementB(this);
    }
    public void operationB(){

    }
}
