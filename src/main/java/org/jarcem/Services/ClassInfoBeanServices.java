package org.jarcem.Services;

import org.jarcem.Beans.ClassInfoBean;

import java.util.List;

public interface ClassInfoBeanServices {
    public List<ClassInfoBean> getAllClass();
    public ClassInfoBean getClassInfo(String class_id);
    public int addClassInfo(ClassInfoBean classInfoBean);
    public int deleteClassInfo(String class_id);
    public int updateClassInfo(ClassInfoBean classInfoBean);
}
