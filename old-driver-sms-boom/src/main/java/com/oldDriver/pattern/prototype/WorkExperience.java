package com.oldDriver.pattern.prototype;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-09 09:25
 */
public class WorkExperience implements  Cloneable{
    private  String workDate;
    private  String workConpany;

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getWorkConpany() {
        return workConpany;
    }

    public void setWorkConpany(String workConpany) {
        this.workConpany = workConpany;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
