package com.oldDriver.pattern.Flyweight;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-30 09:22
 */
public class FlyweightMain {
    public static void main(String[] args) {
        int ext = 21;
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        Flyweight fx = flyweightFactory.getFlyweight("X");
        fx.operation(ext);

        Flyweight fy = flyweightFactory.getFlyweight("Y");
        fy.operation(ext);

        Flyweight fz = flyweightFactory.getFlyweight("Z");
        fz.operation(ext);

        UnsharedConcreteFlyweight uf = new UnsharedConcreteFlyweight();
        uf.operation(ext);

    }
}
