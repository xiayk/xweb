package com.xiayk.xwebshorturl.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Author XiaYk
 * @Date 2019-11-02 03:06
 * @Version 1.0
 */
public class DateUtil {

    /**
     * 格式化时间
     * @param date
     * @return
     */
    public static String formatDate(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
