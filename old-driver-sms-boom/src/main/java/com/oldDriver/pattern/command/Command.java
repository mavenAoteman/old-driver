package com.oldDriver.pattern.command;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-24 09:45
 */
public abstract class Command {
    protected Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }
    public abstract  void execute();
}
