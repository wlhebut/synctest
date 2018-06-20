package com.huntech.web.common;

import java.io.*;
import java.util.*;

/**
 * Created by JHT0701 on 2015/10/12.
 * 文件操作工具类
 */
public class FileUtils {
    /**
     * 读txt 文件
     * @param filePath
     */
    public static void readTxtFile(String filePath){
        try{
            String encoding ="GBK";
            File file =new File(filePath);
            if(file.isFile()&&file.exists()){
                InputStreamReader read= new InputStreamReader(new FileInputStream(file), encoding);

                BufferedReader bufferedReader=new BufferedReader(read);
                String lineTxt=null;
                while((lineTxt=bufferedReader.readLine())!=null){
                    System.out.println(lineTxt);
                }
                read.close();
            }else{
                System.out.println("file does not exist!!!");
            }
        }catch (Exception e){
            System.out.println("file does not exist!!!");
            e.printStackTrace();
        }
    }

    /**
     * 写txt文件
     * @param filePath
     * @param text
     */
    public static void writeTxtFile(String filePath,String text){
        /**method one**/
        BufferedWriter bw=null;
        try{
            FileOutputStream fos=new FileOutputStream(filePath,true);
            bw=new BufferedWriter(new OutputStreamWriter(fos));
            bw.write(text+"\r\n");
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                bw.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }


    /**
     * 读取资源文件
     * @param filename
     */
    public static void readPropertiesFile(String filename)
    {
        Properties properties = new Properties();
        try
        {
            InputStream inputStream = new FileInputStream(filename);
            properties.load(inputStream);
            inputStream.close(); //关闭流
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String username = properties.getProperty("username");
        String passsword = properties.getProperty("password");
        String chinese = properties.getProperty("chinese");
        try
        {
            chinese = new String(chinese.getBytes("ISO-8859-1"), "GBK"); // 处理中文乱码
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        System.out.println(username);
        System.out.println(passsword);
        System.out.println(chinese);
    }

    /**
     *
     * @param filename
     * @param key
     * @param c 中英文字符编码
     * @return
     */
    public static String readPropertiesFile(String filename,String key,String c)
    {
        Properties properties = new Properties();
        String value=null;
        try
        {
            InputStream inputStream = new FileInputStream(filename);
            properties.load(inputStream);
            inputStream.close(); //关闭流

            value = properties.getProperty(key);
            if(c.equals("C")){
                value=new String(value.getBytes("ISO-8859-1"), "UTF-8");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            return value;
        }

    }

    public static List<Map<String,String>> readPropertiesFile(String filename,List<String> keyLists)
    {
        Properties properties = new Properties();
        List<Map<String,String>> list=new ArrayList<Map<String,String>>();
        try
        {
            InputStream inputStream = new FileInputStream(filename);
            properties.load(inputStream);
            inputStream.close(); //关闭流
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Map<String,String> map=null;
        for(int i=0;i<keyLists.size();i++){
            String key=keyLists.get(i);
            map=new HashMap<String,String>();
            String value=properties.getProperty(key);
            map.put(key,value);

            list.add(map);
        }
        /*String username = properties.getProperty("username");
        String passsword = properties.getProperty("password");
        String chinese = properties.getProperty("chinese");
        try
        {
            chinese = new String(chinese.getBytes("ISO-8859-1"), "GBK"); // 处理中文乱码
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        System.out.println(username);
        System.out.println(passsword);
        System.out.println(chinese);
                */
        return  list;
    }

    /**
     * 写资源文件，含中文
     * @param filename
     */
    public static void writePropertiesFile(String filename)
    {
        Properties properties = new Properties();
        try
        {
            OutputStream outputStream = new FileOutputStream(filename);
            properties.setProperty("username", "myname");
            properties.setProperty("password", "mypassword");
            properties.setProperty("chinese", "中文");
            properties.store(outputStream, "author: shixing_11@sina.com");
            outputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
      /**
     * 读取XML文件,并处理中文乱码
     * @param filename
     */
    public static void readPropertiesFileFromXML(String filename)
    {
        Properties properties = new Properties();
        try
        {
            InputStream inputStream = new FileInputStream(filename);
            properties.loadFromXML(inputStream);
            inputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String username = properties.getProperty("username");
        String passsword = properties.getProperty("password");
        String chinese = properties.getProperty("chinese"); //XML中的中文不用处理乱码，正常显示
        System.out.println(username);
        System.out.println(passsword);
        System.out.println(chinese);
    }


    /**
     * 写资源文件到XML文件，含中文
     * @param filename
     */
    public static void writePropertiesFileToXML(String filename)
    {
        Properties properties = new Properties();
        try
        {
            OutputStream outputStream = new FileOutputStream(filename);
            properties.setProperty("username", "myname");
            properties.setProperty("password", "mypassword");
            properties.setProperty("chinese", "中文");
            properties.storeToXML(outputStream, "author: shixing_11@sina.com");
            outputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            writeTxtFile("E:\\response.txt", i+"-xxxxxxxx,");
            System.out.println(i);
        }
        List<String> list=new ArrayList<String>();
        list.add("010101001");
        list.add("010101002");
        list.add("010101003");
        list.add("010101004");
        System.out.println(readPropertiesFile("d:/coordinate.properties", list));
        writePropertiesFileToXML("d:/test.xml");
    }
}
