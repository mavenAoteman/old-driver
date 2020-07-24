package com.oldDriver.pattern.bridge;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-24 09:23
 */
public class RefinedAbstraction extends  Abstraction {
    @Override
    public void operation(){
        implementor.operation();
    }
}
