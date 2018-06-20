package com.huntech.pvs.core.util;

/**
 * Created by lixiaoda on 2015/6/9.
 */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * List对象排序的通用方法
 *
 * @author chenchuang
 *
 * @param <E>
 */
public class ListSort<E> {
    /**
     * @param list   要排序的集合
     * @param method 要排序的实体的属性所对应的get方法
     * @param sort   desc 为正序
     */
    public void Sort(List<E> list, final String method, final String sort) {
        // 用内部类实现排序
        Collections.sort(list, new Comparator<E>(){

            public int compare(Object a, Object b) {
                int ret = 0;
                try {
                    // 获取m1的方法名
                    Method m1 = ((E)a).getClass().getMethod(method, null);
                    // 获取m2的方法名
                    Method m2 = ((E)b).getClass().getMethod(method, null);

                    if (sort != null && "desc".equals(sort)) {

                        ret = Double.valueOf(m2.invoke(((E)b), null).toString()).compareTo(Double.valueOf(m1.invoke(((E) a), null).toString()));

                    } else {
                        // 正序排序
                        ret = Double.valueOf(m1.invoke(((E) a), null).toString()).compareTo(Double.valueOf(m2.invoke(((E) b), null).toString()));
                    }
                } catch (NoSuchMethodException ne) {
                    System.out.println(ne);
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return ret;
            }
        });
    }
}
