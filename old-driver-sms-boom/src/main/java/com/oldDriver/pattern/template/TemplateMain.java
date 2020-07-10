package com.oldDriver.pattern.template;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-10 09:35
 */
public class TemplateMain {
    public static void main(String[] args) {
        AbstractClass ab ;
        ab = new SubClassA();
        ab.mainMethond();
        ab = new SubClassB();
        ab.mainMethond();
    }
}
