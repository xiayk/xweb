package com.xiayk.api.common.po;

public class GClass {
    private Integer id;

    private String className;

    private String classCreateDate;

    private String classIcon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getClassCreateDate() {
        return classCreateDate;
    }

    public void setClassCreateDate(String classCreateDate) {
        this.classCreateDate = classCreateDate == null ? null : classCreateDate.trim();
    }

    public String getClassIcon() {
        return classIcon;
    }

    public void setClassIcon(String classIcon) {
        this.classIcon = classIcon == null ? null : classIcon.trim();
    }
}