package com.oldDriver.pattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-14 09:31
 */
public class Product {
    List<String> parts = new ArrayList<>();

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        System.out.println("产品创建");
        for (String part : parts) {
            System.out.println(part);
        }
    }


}
