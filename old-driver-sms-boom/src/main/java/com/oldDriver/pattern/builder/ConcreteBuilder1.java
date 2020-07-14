package com.oldDriver.pattern.builder;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-14 09:35
 */
public class ConcreteBuilder1 extends Builder {
    private Product product = new Product();
    @Override
    public void buildPardA() {
        product.add("零件A");
    }

    @Override
    public void buildPardB() {
        product.add("零件B");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
