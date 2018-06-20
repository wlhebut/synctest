package com.huntech.web.common;

import com.huntech.web.model.rto.Weather;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by JHT0701 on 2015/10/19.
 */
public class WeatherUtils {
    public static Map<String,Object> getWeatherByLongitudeAndLatitude(String longitude, String latitude,String city){
       Map<String,Object> jsonMap=new HashMap<String,Object>();
        JSONArray resArray=null;
        URL url=null;
        URLConnection urlConnection=null;
        BufferedReader br=null;
        InputStreamReader isr=null;
        StringBuffer sb=null;
        try {
            url = new URL("http://api.map.baidu.com/telematics/v3/weather?location="
                    + longitude + "," + latitude
                    + "&output=json&ak=QGyGlKBA75O3OriiW5Fos3xs");
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

    /**
     * 百度天气
     */
    public static Object getWeatherObject(String longitude, String latitude,String city){
        //Map<String,Object> jsonMap=new HashMap<String,Object>();
        JSONArray resjsonArray=new JSONArray();
        JSONArray resArray=null;
        URL url=null;
        URLConnection urlConnection=null;
        BufferedReader br=null;
        InputStreamReader isr=null;
        StringBuffer sb=null;
        try {
            url = new URL("http://api.map.baidu.com/telematics/v3/weather?location="
                    + longitude + "," + latitude
                    + "&output=json&ak=QGyGlKBA75O3OriiW5Fos3xs");
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
            //jsonMap.put("weather",resArray);
            resjsonArray=resArray;

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
            return resjsonArray;
        }
    }
    public static String getWeatherIconUrl(String longitude, String latitude,String key){
        String iconUrl=null;
        JSONArray resArray=null;
        URL url=null;
        URLConnection urlConnection=null;
        BufferedReader br=null;
        InputStreamReader isr=null;
        StringBuffer sb=null;
        try {
            url = new URL("http://api.map.baidu.com/telematics/v3/weather?location="
                    + longitude + "," + latitude
                    + "&output=json&ak=QGyGlKBA75O3OriiW5Fos3xs");
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

            resArray=jsonArray.getJSONObject(0).getJSONArray("weather_data");

            iconUrl=resArray.getJSONObject(0).getString("dayPictureUrl"); //dayPictureUrl //weather
            //jsonMap.put("weather",resArray);

        } catch (MalformedURLException e) {
            //e.printStackTrace();
            System.err.println("访问路径有误 !");
        }catch (SocketTimeoutException e) {
            System.out.println("连接超时 !");
        } catch (FileNotFoundException e) {
            System.out.println("加载文件出错 !");
        } catch (Exception e) {
            System.out.println("解析内容出错 !");
        }finally {
            return iconUrl;
        }
    }
    public static String getWeather(String longitude, String latitude){
        String iconUrl=null;
        JSONArray resArray=null;
        URL url=null;
        URLConnection urlConnection=null;
        BufferedReader br=null;
        InputStreamReader isr=null;
        StringBuffer sb=null;
        try {
            url = new URL("http://api.map.baidu.com/telematics/v3/weather?location="
                    + longitude + "," + latitude
                    + "&output=json&ak=QGyGlKBA75O3OriiW5Fos3xs");
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

            resArray=jsonArray.getJSONObject(0).getJSONArray("weather_data");

            iconUrl=resArray.getJSONObject(0).getString("weather"); //dayPictureUrl //weather
            //jsonMap.put("weather",resArray);

        } catch (MalformedURLException e) {
            //e.printStackTrace();
            System.err.println("访问路径有误 !");
        }catch (SocketTimeoutException e) {
            System.out.println("连接超时 !");
        } catch (FileNotFoundException e) {
            System.out.println("加载文件出错 !");
        } catch (Exception e) {
            System.out.println("解析内容出错 !");
        }finally {
            return iconUrl;
        }
    }
    public static Object getWeatherObject(String city){
        //Map<String,Object> jsonMap=new HashMap<String,Object>();
        JSONArray resjsonArray=new JSONArray();
        JSONArray resArray=null;
        URL url=null;
        URLConnection urlConnection=null;
        BufferedReader br=null;
        InputStreamReader isr=null;
        StringBuffer sb=null;
        try {
            String urlCityName = URLEncoder.encode(city, "UTF-8");
            url = new URL("http://api.map.baidu.com/telematics/v3/weather?location="
                    + urlCityName
                    + "&output=json&ak=5slgyqGDENN7Sy7pw29IUvrZ");
            //5slgyqGDENN7Sy7pw29IUvrZ  6HyGhm9OihfbOU6ORnVV7GKT
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
            //jsonMap.put("weather",resArray);
            resjsonArray=resArray;

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
            return resjsonArray;
        }
    }
    public static String getWeather(String city){

        String iconUrl=null;
        JSONArray resArray=null;
        URL url=null;
        URLConnection urlConnection=null;
        BufferedReader br=null;
        InputStreamReader isr=null;
        StringBuffer sb=null;
        try {
            String urlCityName = URLEncoder.encode(city, "UTF-8");
            url = new URL("http://api.map.baidu.com/telematics/v3/weather?location="
                    + urlCityName
                    + "&output=json&ak=QGyGlKBA75O3OriiW5Fos3xs");
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

            resArray=jsonArray.getJSONObject(0).getJSONArray("weather_data");

            iconUrl=resArray.getJSONObject(0).getString("weather"); //dayPictureUrl //weather
            //jsonMap.put("weather",resArray);

        } catch (MalformedURLException e) {
            //e.printStackTrace();
            System.err.println("访问路径有误 !");
        }catch (SocketTimeoutException e) {
            System.out.println("连接超时 !");
        } catch (FileNotFoundException e) {
            System.out.println("加载文件出错 !");
        } catch (Exception e) {
            System.out.println("解析内容出错 !");
        }finally {
            return iconUrl;
        }
    }

    public static List<Weather> getWeatherObject(double latitude,double longitude, String city){
        //Map<String,Object> jsonMap=new HashMap<String,Object>();
        //JSONArray resjsonArray=new JSONArray();
        List<Weather> list=new ArrayList<Weather>();
        JSONArray resArray=null;
        URL url=null;
        URLConnection urlConnection=null;
        BufferedReader br=null;
        InputStreamReader isr=null;
        StringBuffer sb=null;
        try {
            url = new URL("http://api.map.baidu.com/telematics/v3/weather?location="
                    + longitude + "," + latitude
                    + "&output=json&ak=QGyGlKBA75O3OriiW5Fos3xs");
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
            //System.out.println(jsonArray.get(0));
            resArray=jsonArray.getJSONObject(0).getJSONArray("weather_data");
            //System.out.println(resArray.getJSONObject(0).getString("dayPictureUrl"));
            //System.out.println(resArray.getJSONObject(0).getJSONArray("dayPictureUrl"));
            //jsonMap.put("weather",resArray);
            //resjsonArray=resArray;
            if(!resArray.isEmpty()){
                Weather weather=null;
                for(int i=0;i<resArray.size();i++){
                    weather=new Weather();
                    weather.setDate(resArray.getJSONObject(i).getString("date") == null ? "--" : resArray.getJSONObject(i).getString("date"));
                    weather.setImgUrl(resArray.getJSONObject(i).getString("dayPictureUrl") == null ? "--" : resArray.getJSONObject(i).getString("dayPictureUrl"));
                    weather.setTemperature(resArray.getJSONObject(i).getString("temperature") == null ? "--" : resArray.getJSONObject(i).getString("temperature"));
                    weather.setWind(resArray.getJSONObject(i).getString("wind") == null ? "--" : resArray.getJSONObject(i).getString("wind"));
                    weather.setWeather(resArray.getJSONObject(i).getString("weather") == null ? "--" : resArray.getJSONObject(i).getString("weather"));
                    list.add(weather);
                }
            }
            System.out.println("return size="+resArray.size());

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
            //return resArray;
            return list;
        }
    }
    public static  void main(String[] args){

//        System.out.println(getWeatherByLongitudeAndLatitude("119.599687", "33.295645", ""));
        //System.out.println(getWeatherIconUrl("81.335798", "43.929312", ""));
        //System.out.println(getWeather("霍城"));
        //System.out.println(getWeather("119.599687", "33.295645"));
        System.out.println(getWeatherObject(119.599687, 33.295645, ""));
//        System.out.println(getWeatherObject(109.062055,19.304371, ""));
        //System.out.println(getWeatherObject("霍城"));
        //System.out.println(getWeatherIconUrl("80.87", "44.07",""));
    }
}
