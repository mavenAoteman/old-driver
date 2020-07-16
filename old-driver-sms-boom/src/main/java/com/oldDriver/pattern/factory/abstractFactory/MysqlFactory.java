package com.oldDriver.pattern.factory.abstractFactory;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-16 09:33
 */
public class MysqlFactory implements IFactory {
    @Override
    public IUser createUser() {
        return new MysqlUser();
    }
}
