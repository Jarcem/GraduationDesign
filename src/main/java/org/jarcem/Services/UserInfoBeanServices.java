package org.jarcem.Services;

import org.jarcem.Beans.UserInfoBean;

import java.util.List;

public interface UserInfoBeanServices {
    public List<UserInfoBean> getAllUser();
    public List<UserInfoBean> getAllUsers(String str);
    public UserInfoBean getUserInfo(String use_id);
    public int loginCheck(String uid, String pwd);
    public int registerUser(UserInfoBean userInfoBean);
    public int deleteUser(String use_id);
    public int updateUser(UserInfoBean userInfoBean);
}
