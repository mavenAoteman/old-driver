package com.oldDriver.pattern.Flyweight;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-30 09:19
 */
public class FlyweightFactory {
    private ConcurrentHashMap<String ,Flyweight> map = new ConcurrentHashMap();
    public FlyweightFactory(){
        map.put("X",new ConcreteFlyweight());
        map.put("Y",new ConcreteFlyweight());
        map.put("Z",new ConcreteFlyweight());
    }

    public Flyweight getFlyweight(String key){
        return  map.get(key);
    }
}
