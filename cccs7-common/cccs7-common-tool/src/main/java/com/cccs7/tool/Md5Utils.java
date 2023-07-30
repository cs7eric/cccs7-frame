package com.cccs7.tool;

import java.security.MessageDigest;

/**
 * md5工具类
 *
 * @author cccs7
 * @date 2023/07/30
 */
public class Md5Utils {

    public static String encode(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.update(text.getBytes());
            byte s[] = md.digest();
            String result = "";
            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}