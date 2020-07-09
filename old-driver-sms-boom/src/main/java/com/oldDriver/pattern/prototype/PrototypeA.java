package com.oldDriver.pattern.prototype;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-07 09:20
 */
public class PrototypeA extends Prototype {
    public PrototypeA(String id) {
        super(id);
    }

    @Override
    public Prototype clone() {
        return this.clone();
    }
}
