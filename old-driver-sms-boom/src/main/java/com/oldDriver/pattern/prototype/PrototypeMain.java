package com.oldDriver.pattern.prototype;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-09 09:31
 */
public class PrototypeMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        Resume a = new Resume("大鸟");
        a .setPersonalMsg("大鸟","28");
        a.setWorkExperience("09点33分","腾讯");

        Resume b = (Resume)a.clone();
        b.setWorkExperience("09点332分","京东");

        Resume c = (Resume)a.clone();
        c.setWorkExperience("07点332分","当当");

        a.display();
        b.display();
        c.display();
    }
}
