package com.oldDriver.pattern.factory.abstractFactory;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-16 09:34
 */
public class AbstractFactoryMain {
    public static void main(String[] args) {
        User user = new User();
        IFactory factory = new SqlServerFactory();
        IUser iu = factory.createUser();
        iu.insert(user);
        iu.getUser(1);
    }
}
