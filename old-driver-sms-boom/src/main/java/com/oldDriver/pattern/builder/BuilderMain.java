package com.oldDriver.pattern.builder;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-14 09:38
 */
public class BuilderMain {
    public static void main(String[] args) {
        Director director = new Director();
        Builder b1 = new ConcreteBuilder1();
        Builder b2 = new ConcreteBuilder2();
        director.construct(b1);
        Product p1 = b1.getResult() ;
        p1.show();
        director.construct(b2);
        Product p2 = b2.getResult() ;
        p2.show();
    }


}
