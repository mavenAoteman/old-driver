package com.oldDriver.pattern.decorate;

/**
 * 装饰模式：
 * 动态的给一个对象添加一些职责，就增加共功能来说，装饰模式比生成子类更加灵活
 * 就是为已有的功能动态的添加更多的功能的一种方式   优点 就是有效的把类的核心职责和装饰功能区分开来 然后去除相关类的中重复的装饰逻辑
 * 缺点的话 就是如果搞混了顺序容易因为问题  比如说一些数据 需要先解密后组装  但是  如果反过来  可能就会存在问题了
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
