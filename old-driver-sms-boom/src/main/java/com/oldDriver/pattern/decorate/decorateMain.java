package com.oldDriver.pattern.decorate;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-01 09:38
 */
public class decorateMain {

    /**
     * 可以无限的增加装饰品 不过不要搞错了顺序
     * @param args
     */
    public static void main(String[] args) {
        Person person = new Person("laoma");
        System.out.println("打扮走起来");
        TShirts tShirts = new TShirts();
        Bigku bigku = new Bigku();
        tShirts.decorate(person);
        bigku.decorate(tShirts);
        bigku.show();
    }
}
