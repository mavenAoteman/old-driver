package com.oldDriver.pattern.prototype;

/**
 * 原型类
 *
 * @author mawenjie12
 * @date 2020-07-07 09:17
 */
public abstract class Prototype {
    private  String id;
    @Override
    public  abstract Prototype clone();
    public  Prototype(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



}
