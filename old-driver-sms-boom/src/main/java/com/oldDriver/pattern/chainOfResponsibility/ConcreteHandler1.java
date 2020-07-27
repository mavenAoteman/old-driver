package com.oldDriver.pattern.chainOfResponsibility;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-27 18:32
 */
public class ConcreteHandler1   extends Handler{
    @Override
    public void HandleRequest(int request) {
        if (request > 0 && request < 10) {
            System.out.println("ConcreteHandler1通过");
        } else {
            successor.HandleRequest(request);
        }
    }
}
