package com.oldDriver.pattern.command;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-24 09:55
 */
public class CommandMain {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker i = new Invoker();
        i.setCommand(command);
        i.executeCommand();

    }
}
