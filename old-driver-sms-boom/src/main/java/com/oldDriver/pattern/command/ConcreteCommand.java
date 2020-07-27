package com.oldDriver.pattern.command;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-24 09:52
 */
public class ConcreteCommand extends  Command {
    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        super.receiver.action();
    }
}
