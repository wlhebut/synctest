package com.huntech.web.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by wl on 2017/7/10.
 * 将set集合按照时间排序
 */
public class StringTimeSort {
    public static List<String> splitByCommaToInteger(Set<String> sets){
        ArrayList<String> keyMap = new ArrayList<>();
        for (String string : sets) {
            keyMap.add(string);
        }
        for (int i = 0; i < keyMap.size() -1; i++) {
            for (int j = 0; j < keyMap.size() - i - 1; j++) {
                String s1 = keyMap.get(j);
                String s1split = s1.substring(0, s1.indexOf(":"));
                Integer integer1 = Integer.valueOf(s1split);
                String s2 = keyMap.get(j + 1);
                String s2split = s2.substring(0, s2.indexOf(":"));
                Integer integer2 = Integer.valueOf(s2split);
                if (integer1 > integer2) {    //把da的值交换到后面
                    String swap = keyMap.get(j);
                    keyMap.set(j, keyMap.get(j+1));
                    keyMap.set(j+1, swap);//交换数据
                }
            }
        }
        return  keyMap;
}
}
