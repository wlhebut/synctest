package com.huntech.web.common;

import net.hydromatic.linq4j.Linq4j;
import net.hydromatic.linq4j.function.Predicate1;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by JHT0701 on 2015/11/25.
 */
public class CommUtils {
    public static void main(String[] args) {
        //long time=1448416244773l;
        long time = 1451577599000l;//1451577599000//1451577599000l
        Date date = new Date(time);
        System.out.println(date);

        Date d1 = new Date();//"2017-12-31 23:59:59"

        long x = d1.getTime();
        System.out.println(x);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d2 = sdf.parse("2016-12-31 23:59:59");//1514735999000
            System.out.println(d2.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        getXML(null, null, null);
        InputStream inputStream=downloadXML("http://tisp.utourworld.com/travel-web/upload/op/agentlinexml/OPL00002555.xml");
        try {
            String str=convertStreamToString(inputStream);
            System.out.println(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //testMap();
    }

    public static void testMap() {
        Map mm = new HashMap(100);
        List l = new ArrayList(100);
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            mm.put(i, i);
        }
        System.out.println("put map=" + (System.currentTimeMillis() - l1));
        l1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            l.add(i);
        }
        System.out.println("add list=" + (System.currentTimeMillis() - l1));
        l1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            mm.get(i);
            //String x=mm.get(10000).toString();
            //System.out.println(x);
        }

        System.out.println("get map=" + (System.currentTimeMillis() - l1));

        l1 = System.currentTimeMillis();
        String xx = mm.get(100).toString();
        System.out.println(xx);
        System.out.println("gethhhhh=" + (System.currentTimeMillis() - l1));

        l1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            String x = l.get(i).toString();
            if (x.equals("100")) {
                System.out.println(x);
                break;
            }
        }
        System.out.println("get list=" + (System.currentTimeMillis() - l1));
    }

    public static <T> T findObject(List<T> list, final String sfield, final Object v) {
        T obj = Linq4j.asEnumerable(list).first(new Predicate1<T>() {
            @Override
            public boolean apply(T t) {

                boolean flag = false;

                Class clazz = t.getClass();
                Field field = null; //获取成员变量
                Object v1 = null;
                try {
                    field = clazz.getDeclaredField(sfield);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                field.setAccessible(true); //设置成可访问状态
                try {
                    v1 = field.get(t); //获取field的值
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                //flag = ((Long) v1).equals(v);
                flag = v1.equals(v);

                return flag;
            }
        });
        return obj;
    }

    public static Map<String,Object> getXML(String longitude, String latitude,String city){
        Map<String,Object> jsonMap=new HashMap<String,Object>();
        JSONArray resArray=null;
        URL url=null;
        URLConnection urlConnection=null;
        BufferedReader br=null;
        InputStreamReader isr=null;
        StringBuffer sb=null;
        try {
            url = new URL("http://tisp.utourworld.com/travel-web/upload/op/agentlinexml/OPL00002555.xml");
            urlConnection= url.openConnection();
            urlConnection.setConnectTimeout(10000);

            isr=new InputStreamReader(urlConnection.getInputStream(),"UTF-8");

            br=new BufferedReader(isr);
            sb=new StringBuffer(new StringBuilder());

            String line=null;
            while (null!=(line=br.readLine())){
                sb.append(line);
            }
            String datas=sb.toString();
            JSONObject jsonObject=JSONObject.fromObject(datas);
            JSONArray jsonArray=jsonObject.getJSONArray("results");
            System.out.println(jsonArray.get(0));
            resArray=jsonArray.getJSONObject(0).getJSONArray("weather_data");
            System.out.println(resArray.getJSONObject(0).getString("dayPictureUrl"));
            //System.out.println(resArray.getJSONObject(0).getJSONArray("dayPictureUrl"));
            jsonMap.put("weather",resArray);

        } catch (MalformedURLException e) {
            //e.printStackTrace();
            System.out.println("访问路径有误 !");
        }catch (SocketTimeoutException e) {
            System.out.println("连接超时 !");
        } catch (FileNotFoundException e) {
            System.out.println("加载文件出错 !");
        } catch (Exception e) {
            System.out.println("解析内容出错 !");
        }finally {
            return jsonMap;
        }
    }

    public static InputStream downloadXML(final String urlStr){
        InputStream inStream = null;
        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        conn.setConnectTimeout(5 * 1000);
        try {
            conn.setRequestMethod("GET");
            conn.connect();
        } catch (Exception e) {
            // TODO Auto-generated catch block
        }

        try {
            inStream= conn.getInputStream();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return inStream;
    }
    public static String convertStreamToString(InputStream is) throws UnsupportedEncodingException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"GBK"));

        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "/n");
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                is.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

        return sb.toString();

    }
}

class Person {
    int age;
    String name;
    String sex;

    public Person(int age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return !(sex != null ? !sex.equals(person.sex) : person.sex != null);

    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }
}