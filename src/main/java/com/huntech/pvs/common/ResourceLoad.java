package com.huntech.pvs.common;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ResourceLoad {

    public static String getResource(String key) {

        //linux下jdk1.8 方法获取时,不会拼接自己写的目录

        Properties properties = new Properties();
        InputStream in = null;
        in =new BufferedInputStream(ResourceLoad.class.getResourceAsStream("/weixin.properties"));
        try {
            properties.load(new InputStreamReader(in, "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value=properties.getProperty(key);
        return value;
    }


}