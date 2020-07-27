package com.oldDriver.pattern.chainOfResponsibility;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-27 18:34
 */
public class ConcreteHandler2 extends Handler {
    @Override
    public void HandleRequest(int request) {
        if (request > 10) {
            System.out.println("ConcreteHandler2通过");
        }
    }
}
