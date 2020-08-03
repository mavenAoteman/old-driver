package com.oldDriver.pattern.interpreter;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-08-03 09:06
 */
public class TerminalExpression extends AbstractExpression {
    @Override
    public void interpret(Context context) {
        System.out.println("终端解释器");
    }
}
