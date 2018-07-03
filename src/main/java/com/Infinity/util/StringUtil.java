package com.Infinity.util;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class StringUtil {

    public static boolean isEmpty(String str) {
        if ("".equals(str) || str == null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotEmpty(String str) {
        if (!"".equals(str) && str != null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean existStrArr(String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String handleChinese(String str) {
        try {
            str = new String(str.getBytes("iso8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            return str;
        }
    }
}
