package com.oldDriver.pattern.factory.abstractFactory;

/**
 * 如果新增类只需要在这里面新增一个create方法 病区对应的工厂里面创建就好了
 *
 * @author mawenjie12
 * @date 2020-07-16 09:31
 */
public interface IFactory {
    IUser createUser();
}
