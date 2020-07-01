package com.oldDriver.pattern.decorate;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-01 09:17
 */
public class Finery extends Person {
    protected  Person compent;
    public void decorate(Person compent){
        this.compent = compent;
    }
    @Override
    public  void show(){
        if(null != compent){
            compent.show();
        }
    }
}
