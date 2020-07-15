package com.oldDriver.pattern.observer;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-15 09:43
 */
public class ConcreteSubject extends Subject {

    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
