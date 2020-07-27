package com.oldDriver.pattern.command;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-24 09:53
 */
public class Invoker {
    private  Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand(){
        command.execute();
    }
}
