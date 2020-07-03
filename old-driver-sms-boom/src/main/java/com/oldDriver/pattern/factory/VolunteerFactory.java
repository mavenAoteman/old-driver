package com.oldDriver.pattern.factory;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-03 09:25
 */
public class VolunteerFactory implements  IFactory{
    @Override
    public LeiFeng createLeiFeng() {
        return new  Volunteer();
    }
}
