package com.oldDriver.pattern.singleton;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-23 11:44
 */
public final class Shuangjiansuo {

    private volatile static Shuangjiansuo instance = null;

    private Shuangjiansuo(){

    }

    public static Shuangjiansuo getInstance(){
        if(null == instance){
            synchronized(instance){
                if(null == instance){
                    instance = new Shuangjiansuo();
                }
            }
        }
        return  instance;
    }

}
