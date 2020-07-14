package com.oldDriver.pattern.builder;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-14 09:35
 */
public class ConcreteBuilder2 extends Builder {
    private Product product = new Product();
    @Override
    public void buildPardA() {
        product.add("零件X");
    }

    @Override
    public void buildPardB() {
        product.add("零件Y");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
