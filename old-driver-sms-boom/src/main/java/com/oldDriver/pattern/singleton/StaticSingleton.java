package com.oldDriver.pattern.singleton;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-23 11:48
 */
public final class StaticSingleton {
    private static final StaticSingleton instance = new StaticSingleton();
    private StaticSingleton(){

    }
    public static StaticSingleton getInstance() {
        return instance;
    }
}
