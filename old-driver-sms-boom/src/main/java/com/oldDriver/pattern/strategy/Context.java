package com.oldDriver.pattern.strategy;

/**
 * 策略
 *
 * @author mawenjie12
 * @date 2020-07-06 09:11
 */
public class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface() {
        strategy.algoritmInterface();
    }
}
