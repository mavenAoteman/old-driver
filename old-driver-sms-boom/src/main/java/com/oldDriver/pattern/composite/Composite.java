package com.oldDriver.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-22 09:49
 */
public class Composite extends Component {

    public List<Component> children = new ArrayList<>();


    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void display(int depth) {
        System.out.println("-" + depth + name);
        for (Component component : children) {
            component.display(depth + 2);
        }
    }
}
