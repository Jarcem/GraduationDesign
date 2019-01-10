package org.jarcem.Util;

import java.util.regex.Pattern;

public class StringUtil {
    /**
     * 判断字符串是否为空
     */
    public static boolean isNull(String str) {
        return null == str|| str.length()== 0|| "".equals(str)||str.matches("\\s*");
    }
    /**
     * 非空判断
     */
    public static boolean isNotNull(String userName) {
        return !isNull(userName);
    }
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("^-?([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|0?\\.0+|0)$");
        return pattern.matcher(str).matches();
    }
}