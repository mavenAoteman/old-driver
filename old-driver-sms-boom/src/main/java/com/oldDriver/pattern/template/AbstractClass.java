package com.oldDriver.pattern.template;

/**
 * 模板模式
 *
 * @author mawenjie12
 * @date 2020-07-10 09:32
 */
public  abstract class AbstractClass {
    public abstract void methondA();
    public abstract void methondB();
    public void mainMethond(){
        methondA();
        methondB();
        System.out.println("执行完了!");
    }
}
