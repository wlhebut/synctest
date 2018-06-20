package com.huntech.web.common;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */
public class StringSplit {
    public static List<Integer> splitByCommaToInteger(String checkItems){
        String[] split = checkItems.split(",");
        List<String> temp = Arrays.asList(split);
        List<Integer> checkItemsid=new ArrayList<>();
        for (String s : temp) {
            Integer integer = Integer.valueOf(s);
            checkItemsid.add(integer);
        }
        return checkItemsid;
    }
}
