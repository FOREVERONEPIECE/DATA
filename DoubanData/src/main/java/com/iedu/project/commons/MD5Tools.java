package com.iedu.project.commons;
import org.springframework.util.DigestUtils;

public class MD5Tools {


    public static String buildMD5StringNoraml(String source){
        return DigestUtils.md5DigestAsHex(DigestUtils.md5DigestAsHex(source.getBytes()).getBytes());
    }

}
