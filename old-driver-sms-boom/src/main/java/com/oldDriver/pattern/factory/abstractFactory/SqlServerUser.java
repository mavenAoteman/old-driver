package com.oldDriver.pattern.factory.abstractFactory;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-16 09:28
 */
public class SqlServerUser implements IUser {
    @Override
    public void insert(User user) {
        System.out.println("在SqlServer 中给User增加一条数据 ");
    }

    @Override
    public User getUser(int id) {
        System.out.println("在SqlServer 中根据id获取一条数据 ");
        return null;
    }
}
