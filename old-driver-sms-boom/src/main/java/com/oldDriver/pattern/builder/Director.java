package com.oldDriver.pattern.builder;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-14 09:37
 */
public class Director {

    public void construct(Builder builder){
        builder.buildPardA();
        builder.buildPardB();
    }
}
