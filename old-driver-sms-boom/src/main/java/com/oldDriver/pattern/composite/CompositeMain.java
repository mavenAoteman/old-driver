package com.oldDriver.pattern.composite;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-22 10:00
 */
public class CompositeMain {
    public static void main(String[] args) {
        Composite root = new Composite("root");
        root.add(new Leaf("leaf A"));
        root.add(new Leaf("leaf B"));

        Composite comp = new Composite("X");
        comp.add(new Leaf("leaf XA"));
        comp.add(new Leaf("leaf XB"));
        root.add(comp);

        Composite comp2 = new Composite("Y");
        comp2.add(new Leaf("leaf YA"));
        comp2.add(new Leaf("leaf YB"));
        comp.add(comp2);
        root.display(1);
    }
}
