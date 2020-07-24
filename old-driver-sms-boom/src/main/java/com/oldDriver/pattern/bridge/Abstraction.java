package com.oldDriver.pattern.bridge;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-24 09:17
 */
public class Abstraction {
    protected Implementor implementor;

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    public void operation(){
        implementor.operation();
    }
}
