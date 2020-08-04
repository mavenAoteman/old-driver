package com.oldDriver.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-08-04 09:27
 */
public class ObjectStructure {
    private List<Element> elements = new ArrayList<>();

    public void attach(Element element) {
        elements.add(element);
    }

    public void detach(Element element) {
        elements.remove(element);
    }

    public void accept(Visitor vi) {
        for (Element el : elements) {
            el.accept(vi);
        }
    }
}
