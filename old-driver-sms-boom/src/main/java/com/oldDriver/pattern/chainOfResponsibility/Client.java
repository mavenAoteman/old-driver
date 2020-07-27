package com.oldDriver.pattern.chainOfResponsibility;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-27 18:35
 */
public class Client {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setSuccessor(handler2);
        int[] requests = {2, 5, 14, 22};
        for (int request : requests) {
            handler1.HandleRequest(request);
        }
    }
}
