package com.oldDriver.pattern.composite;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-22 09:25
 */
public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void add(Component component);

    public abstract void remove(Component component);

    public abstract void display(int depth);

}
