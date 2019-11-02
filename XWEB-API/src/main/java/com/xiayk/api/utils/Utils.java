package com.xiayk.api.utils;

import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 杂物工具类
 */
public class Utils {

    //唯一标识符
    public static String generateUUID() {
        String uuid = UUID.randomUUID().toString();
        Long currentTime = System.currentTimeMillis();
        String currentDate = String.valueOf(currentTime);
        return uuid + currentDate;
    }

    private Utils() {
        // No instances.
    }

    private static final String TOKEN_KEY = "XWEB_TOKEN";

    public static String getToken(HttpServletRequest request){
        return request.getHeader(TOKEN_KEY);
    }

    public static byte[] toBytes(Object out) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

            objectOutputStream.writeObject(out);

            byte[] bs = byteArrayOutputStream.toByteArray();

            System.out.println(Arrays.toString(bs));

            return bs;

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            objectOutputStream.close();
        }
        return null;
    }

    public static Object toObject(byte[] bs){
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            byteArrayInputStream = new ByteArrayInputStream(bs);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);

            Object obj = objectInputStream.readObject();
            return obj;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String toAmount(long amount) {
        return new BigDecimal(amount).divide(new BigDecimal(100)).toString();
    }

    public static String toDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static boolean isEmpty(Object object) {
        if (object instanceof String) {
            return StringUtils.isEmpty((String) object);
        }
        return object == null;
    }

    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }

    public static <T> boolean isListNotEmpty(List<T> list) {
        return list != null && list.size() > 0;
    }

    public static <T> boolean isListEmpty(List<T> list) {
        return !isListNotEmpty(list);
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
