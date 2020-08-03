package com.oldDriver.pattern.interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-08-03 09:22
 */
public class InterpreterMain {
    public static void main(String[] args) {
        Context context = new Context();
        List<AbstractExpression> list = new ArrayList<>();
        list.add(new TerminalExpression());
        list.add(new NonterminalExpression());
        list.add(new TerminalExpression());
        list.add(new TerminalExpression());
        for (AbstractExpression abs:
             list) {
            abs.interpret(context);

        }
    }
}
