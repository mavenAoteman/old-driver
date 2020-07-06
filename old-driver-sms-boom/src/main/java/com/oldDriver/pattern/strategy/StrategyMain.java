package com.oldDriver.pattern.strategy;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-06 09:13
 */
public class StrategyMain {
    public static void main(String[] args) {
        Context context;
        context = new Context(new StrategyA());
        context.contextInterface();

        context = new Context(new StrategyB());
        context.contextInterface();
    }

}
