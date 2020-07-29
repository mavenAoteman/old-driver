package com.oldDriver.pattern.mediator;

/**
 * 中介者模式
 *
 * @author mawenjie12
 * @date 2020-07-29 09:04
 */
public abstract class Mediator {
    public abstract void send(String message,Colleague colleague);
}
