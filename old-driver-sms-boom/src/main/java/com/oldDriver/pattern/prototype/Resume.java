package com.oldDriver.pattern.prototype;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-09 09:21
 */
public class Resume implements Cloneable {
    private String name;
    private String sex;
    private WorkExperience workExperience;

    private Resume(WorkExperience workExperience) throws CloneNotSupportedException {
        this.workExperience = (WorkExperience)workExperience.clone();
    }

    public Resume(String name) {
        this.name = name;
        workExperience = new WorkExperience();
    }

    public void setWorkExperience(String workDate, String workCompany) {
        workExperience.setWorkDate(workDate);
        workExperience.setWorkConpany(workCompany);
    }

    public void setPersonalMsg(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void display() {
        System.out.println("姓名：" + name + " 性别：" + sex);
        System.out.println("工作经历：日期" + workExperience.getWorkDate() + " 公司：" + workExperience.getWorkConpany());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Resume resume = new Resume(this.workExperience);
        resume.sex = this.sex;
        resume.name = this.name;
        return resume;
    }
}
