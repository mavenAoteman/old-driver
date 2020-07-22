package com.oldDriver.pattern.composite;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-22 09:35
 */
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        System.out.println("can not add a Leaf");
    }

    @Override
    public void remove(Component component) {
        System.out.println("can not remove a Leaf");

    }

    @Override
    public void display(int depth) {
        System.out.println("-" + depth + name);

    }
}
