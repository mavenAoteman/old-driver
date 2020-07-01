package com.oldDriver.pattern.decorate;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-01 09:13
 */
public  class Person {
    public  String name;

    /**
     *
     */
    public Person(){}

    /**
     *
     * @param name
     */
    public Person(String name){
        this.name = name;
    }

    public  void show(){
        System.out.println("装扮的"+name);

    }
}
