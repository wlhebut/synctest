package com.huntech.web.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by JHT0701 on 2015/10/5.
 * 日期处理工具类
 */
public class DateUtils<B> {
	
	/**
     * 获取时间字符串
     * @return
     */

    private static Integer arr[]=new Integer[]{9,11,13,15,17};
    public static String dateToYMDHM() {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        String dateStr = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            dateStr = sdf.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return dateStr;
        }
    }
    
    /**
     * 获取时间字符串
     * @param date
     * @param format
     * @return
     */
    public static String dateToStr(Date date, String format) {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        String dateStr = null;
        if(date==null){
            return dateStr;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            dateStr = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return dateStr;
        }
    }

    /**
     * 获取时间字符串，使用默认格式
     * @param date
     * @return
     */
    public static String dateToStr(Date date) {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        String dateStr = null;
        if(date==null){
            return dateStr;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            dateStr = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return dateStr;
        }
    }
    
    /**
     * String转换成Date
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Date stringToDate(String dateStr, String format) {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return date;
        }
    }

    /**
     * 简单的String转换成Date；格式：yyyy-MM-dd
     *
     * @param dateStr
     * @return
     */
    public static Date simpleStringToDate(String dateStr) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return date;
        }
    }

    /**
     * 简单的String转换成Date；格式：yyyy-MM
     *
     * @param dateStr
     * @return
     */
    public static Date simpleStringToYearAndMonth(String dateStr) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            if(dateStr == null || "".equals(dateStr)){
                return date;
            }
            date = sdf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return date;
        }
    }
    
    /**
     * String转换成Date
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Calendar stringToCalendar(String dateStr, String format) {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        Calendar date = Calendar.getInstance();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date.setTime(sdf.parse(dateStr));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return date;
        }
    }
    
    /**
     * 获取某月有几天
     *
     * @param year
     * @param month
     * @return
     */
    public static int getDaysOfMonth(String year, String month) {
        int res = 0;
        int y = Integer.parseInt(year);
        int m = Integer.parseInt(month);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, y);
        calendar.set(Calendar.MONTH, m - 1);
        res = calendar.getActualMaximum(Calendar.DATE);

        return res;
    }

    /**
     * 获取某月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getBeginOfMonth(String year, String month) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date date = null;
        try {
            date = sdf.parse(year + "-" + month);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取某月最后一天,截止到当前日期
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getEndOfMonth(String year, String month) {
        Date date = null;
        int y = Integer.parseInt(year);
        int m = Integer.parseInt(month);
        Calendar calendar = Calendar.getInstance();
        int cy = calendar.get(Calendar.YEAR);
        int cm = calendar.get(Calendar.MONTH + 1);
        if (y == cy && m == cm) {
            date = new Date();
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            calendar.clear();
            calendar.set(Calendar.YEAR, y);
            calendar.set(Calendar.MONTH, m - 1);
            int day = calendar.getActualMaximum(Calendar.DATE);
            String d = year + "-" + month + "-" + day;
            try {
                date = sdf.parse(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return date;
    }

    public static int getHoursNum(String date) {
        int res = 0;
        if (date.equals(dateToStr(new Date(), "yyyy-MM-dd"))) {
            res = getCurrentHourNum();
        } else {
            res = 22 - 5;
        }
        return res;
    }

    public static int getCurrentHourNum() {

        Calendar calendar = Calendar.getInstance();
        int res = calendar.get(Calendar.HOUR_OF_DAY);
        return res;
    }

    public static int getCurrentMinuteNum() {
        Calendar calendar = Calendar.getInstance();
        int res = calendar.get(Calendar.MINUTE);
        return res;
    }

    /**
     * @param date 2015-10-06
     * @return
     */
    public static List<Date> getTimeLists(String date) {
        List<Date> list = new ArrayList<Date>();
        if (date.equals(dateToStr(new Date(), "yyyy-MM-dd"))) {
            int h = getCurrentHourNum();
            int m = getCurrentMinuteNum() / 5;

            for (int i = 5; i <= h; i++) {
                int j = 0;
                if (i != h) {
                    for (; j < 12; j++) {
                        String time = date + " " + i + ":" + j * 5 + ":00";
                        Date d = stringToDate(time, "yyyy-MM-dd HH:mm:ss");
                        list.add(d);
                    }
                } else {
                    for (; j <= m; j++) {
                        String time = date + " " + i + ":" + j * 5 + ":00";
                        Date d = stringToDate(time, "yyyy-MM-dd HH:mm:ss");
                        list.add(d);
                    }
                }

            }
        } else {
            for (int i = 5; i <= 22; i++) {
                if(i!=22) {
                    for (int j = 0; j < 12; j++) {
                        String time = date + " " + i + ":" + j * 5 + ":00";
                        Date d = stringToDate(time, "yyyy-MM-dd HH:mm:ss");
                        list.add(d);
                    }
                }else{
                    list.add(stringToDate(date+" 22:00:00","yyyy-MM-dd HH:mm:ss"));
                }
            }

        }
        return list;
    }

    public static List<Date> getAllTimeLists(String date) {
        List<Date> list = new ArrayList<Date>();
        if (date.equals(dateToStr(new Date(), "yyyy-MM-dd"))) {
            int h = getCurrentHourNum();
            int m = getCurrentMinuteNum() / 5;


            for (int i = 5; i <= 22; i++) {
                if(i!=22) {
                    for (int j = 0; j < 12; j++) {
                        String time = date + " " + i + ":" + j * 5 + ":00";
                        Date d = stringToDate(time, "yyyy-MM-dd HH:mm:ss");
                        list.add(d);
                    }
                }else{
                    list.add(stringToDate(date+" 22:00:00","yyyy-MM-dd HH:mm:ss"));
                }
            }

        }
        return list;
    }
    public static String strDate(int year,int month,int day){
        String str="";
        str+=year+"-"+(month<10?"0"+month:month)+"-"+(day<10?"0"+day:day);
        return str;
    }
    public static List<Date> getAllTimeLists(int year,int month,int day) {
        List<Date> list = new ArrayList<Date>();
        String date=strDate(year, month, day);
        /*if (date.equals(dateToStr(new Date(), "yyyy-MM-dd"))) {
            int h = getCurrentHourNum();
            int m = getCurrentMinuteNum() / 5;*/


            for (int i = 5; i <= 22; i++) {
                if(i!=22) {
                    for (int j = 0; j < 12; j++) {
                        String time = date + " " + i + ":" + j * 5 + ":00";
                        Date d = stringToDate(time, "yyyy-MM-dd HH:mm:ss");
                        list.add(d);
                    }
                }else{
                    list.add(stringToDate(date+" 22:00:00","yyyy-MM-dd HH:mm:ss"));
                }
            }

       // }
        return list;
    }

    public static List<Date> getAllTimeLists(int year,int month,int day,int begin,int end,int interval) {
        List<Date> list = new ArrayList<Date>();
        String date=strDate(year, month, day);

        if(begin==0 && end==0){
            begin=5;
            end=22;
        }
        if(interval==0){
            interval=5;
        }
        for (int i = begin; i <= end; i++) {
            if(i!=22) {
                int len=60/interval;
                for (int j = 0; j < len; j++) {
                    String time = date + " " + i + ":" + j * interval + ":00";
                    Date d = stringToDate(time, "yyyy-MM-dd HH:mm:ss");
                    list.add(d);
                }
            }else{
                list.add(stringToDate(date+" 22:00:00","yyyy-MM-dd HH:mm:ss"));
            }
        }

        // }
        return list;
    }

    public static List<String> getAllTimeStringLists(String date) {
        List<String> list = new ArrayList<String>();
        if (date.equals(dateToStr(new Date(), "yyyy-MM-dd"))) {
            int h = getCurrentHourNum();
            int m = getCurrentMinuteNum() / 5;


            for (int i = 5; i <= 22; i++) {
                if(i!=22) {
                    for (int j = 0; j < 12; j++) {
                        String time = date + " " + i + ":" + j * 5 + ":00";
                        //Date d = stringToDate(time, "yyyy-MM-dd HH:mm:ss");
                        list.add(time);
                    }
                }else{
                    list.add(date+" 22:00:00");
                }
            }

        }
        return list;
    }
    public static int[] getAllMonths(){

        int res[]=new int[12];
        for(int i=0;i<12;i++){
            res[i]=i+1;
        }
        return res;
    }
    public static int[] getAllDays(int year,int month){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        int day = calendar.getActualMaximum(Calendar.DATE);
        int res[]=new int[day];
        for(int i=0;i<day;i++){
            res[i]=i+1;
        }
        return res;
    }
    /**
     * @param date 2015-10-06
     * @return
     */
    public static List<String> getTimeStrLists(String date) {
        List<String> list = new ArrayList<String>();
        if (date.equals(dateToStr(new Date(), "yyyy-MM-dd"))) {
            int h = getCurrentHourNum();
            int m = getCurrentMinuteNum() / 5;

            for (int i = 5; i <= h; i++) {
                int j = 0;
                if (i != h) {
                    for (; j < 12; j++) {
                        String time =  date + " " + i + ":" + j * 5 + ":00";
                        //Date d = stringToDate(time, "yyyy-MM-dd HH:mm:ss");

                        list.add(time);
                    }
                } else {
                    for (; j <= m; j++) {
                        String time = date + " " + i + ":" + j * 5 + ":00";
                        //Date d = stringToDate(time, "yyyy-MM-dd HH:mm:ss");
                        list.add(time);
                    }
                }

            }
        } else {
            for (int i = 5; i <= 22; i++) {
                if(i!=22) {
                    for (int j = 0; j < 12; j++) {

                        String time = date + " " + i + ":" + j * 5 + ":00";
                        //Date d = stringToDate(time, "yyyy-MM-dd HH:mm:ss");
                        list.add(time);
                    }
                }else{
                    list.add(date+" 22:00:00");
                }
            }

        }
        return list;
    }
    public static List<String> getHourStringHH(){
        List<String> list=new ArrayList<String>();
        for(int i=6;i<=22;i++){
            String str="";
            if(i<10){
                str=str+"0";
            }
            str=str+i;
            list.add(str);
        }
        return list;
    }
    public static String getLatestTimeStr(){
        String str=null;
       Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.MINUTE,-10);
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        int day=calendar.get(Calendar.DATE);
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);

        str=year+"-";
        if(month<10){
            str=str+"0";
        }
        str=str+month+"-";
        if(day<10){
            str=str+"0";
        }
        str=str+day+" ";
        if(hour<10){
            str=str+"0";
        }
        str=str+hour+":";
        if(minute%5!=0){
            int mod=minute%5;
            minute=minute-mod;
        }
        if(minute<10){
            str=str+"0";
        }
        str=str+minute+":00";
        /*if(minute<=10 &&minute>5 && hour>5){
            hour=hour-1;
            str=str+hour+":55:00";
        }else if(minute<=5 && hour>5){
            hour=hour-1;
            str=str+hour+":50:00";
        }else{

        }*/

        return  str;
    }
    public static String getTimeScale(){
        String result="";
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.MINUTE,-10);
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        int day=calendar.get(Calendar.DATE);
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);
        int second=calendar.get(Calendar.SECOND);
        result=year+"";
        if(month<10){
            result=result+"0";
        }
        result=result+month;
        if(day<10){
            result=result+"0";
        }
        result=result+day;
        if(hour<10){
            result=result+"0";
        }
        result=result+hour;
        if(minute<=10){
            result=result+"0";
        }
        result=result+minute;
        if(second<10){
            result=result+"0";
        }
        result=result+second;
        return result;
    }
    public static Date getLatestTime(){
        String str=null;
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.MINUTE,-10);
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        int day=calendar.get(Calendar.DATE);
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);

        str=year+"-";
        if(month<10){
            str=str+"0";
        }
        str=str+month+"-";
        if(day<10){
            str=str+"0";
        }
        str=str+day+" ";
        if(hour<10){
            str=str+"0";
        }
        str=str+hour+":";
        if(minute%5!=0){
            int mod=minute%5;
            minute=minute-mod;
        }
        if(minute<10){
            str=str+"0";
        }
        str=str+minute+":00";
        /*if(minute<=10 &&minute>5 && hour>5){
            hour=hour-1;
            str=str+hour+":55:00";
        }else if(minute<=5 && hour>5){
            hour=hour-1;
            str=str+hour+":50:00";
        }else{

        }*/

        return  stringToDate(str,"yyyy-MM-dd HH:mm:ss");
    }
    public static Date getEndTime(int year,int month,int day ,String endTime){
        String str=null;

        str=year+"-";
        if(month<10){
            str=str+"0";
        }
        str=str+month+"-";
        if(day<10){
            str=str+"0";
        }
        str=str+day+" "+endTime;

        return  stringToDate(str,"yyyy-MM-dd HH:mm:ss");
    }
    public static Date getBeginTime(int year,int month,int day ,String beginTime){
        String str=null;

        str=year+"-";
        if(month<10){
            str=str+"0";
        }
        str=str+month+"-";
        if(day<10){
            str=str+"0";
        }
        str=str+day+" "+beginTime;

        return  stringToDate(str,"yyyy-MM-dd HH:mm:ss");
    }
    public static Date getLastestTimeOfYesterday(){
        String str=null;
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DATE,-1);
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        int day=calendar.get(Calendar.DATE);

        str=year+"-";
        if(month<10){
            str=str+"0";
        }
        str=str+month+"-";
        if(day<10){
            str=str+"0";
        }
        str=str+day+" 22:00:00";

        /*if(minute<=10 &&minute>5 && hour>5){
            hour=hour-1;
            str=str+hour+":55:00";
        }else if(minute<=5 && hour>5){
            hour=hour-1;
            str=str+hour+":50:00";
        }else{

        }*/

        return  stringToDate(str,"yyyy-MM-dd HH:mm:ss");
    }
    public static Date getEaliestTime(){
        String str=null;
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.MINUTE,-10);
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        int day=calendar.get(Calendar.DATE);

        str=year+"-";
        if(month<10){
            str=str+"0";
        }
        str=str+month+"-";
        if(day<10){
            str=str+"0";
        }
        str=str+day+" 05:00:00";
        /*if(minute<=10 &&minute>5 && hour>5){
            hour=hour-1;
            str=str+hour+":55:00";
        }else if(minute<=5 && hour>5){
            hour=hour-1;
            str=str+hour+":50:00";
        }else{

        }*/

        return  stringToDate(str,"yyyy-MM-dd HH:mm:ss");
    }
    /**
     * @param date 2015-10-06
     * @return
     */
    public static List<Date> getHTimeLists(String date) {
        List<Date> list = new ArrayList<Date>();
        if (date.equals(dateToStr(new Date(), "yyyy-MM-dd"))) {
            int h = getCurrentHourNum();
            //int m = getCurrentMinuteNum() / 5;
            for (int i = 5; i <= h; i++) {
                String time = date + " " + i + ":00:00";
                Date d = stringToDate(time, "yyyy-MM-dd HH:mm:ss");

                Date dd=stringToDate(getLatestTimeStr(),"yyyy-MM-dd HH:mm:ss");
                if(dd.after(d)){
                    list.add(d);
                }else{
                    break;
                    //list.add(dd);
                }

                //list.add(d);
            }
            /*Date dd=new Date();
            Date ld=stringToDate(getLatestTime(), "yyyy-MM-dd HH:mm:ss");
            if(dd.after(ld)&&ld.after(list.get(list.size() - 1))){
                list.add(ld);
            }*/
        } else {
            for (int i = 5; i <= 22; i++) {
                String time = date + " " + i + ":00:00";
                Date d = stringToDate(time, "yyyy-MM-dd HH:mm:ss");
                list.add(d);
            }
        }
        return list;
    }
    public static int getCurrentDayNum(){
        Calendar calendar=Calendar.getInstance();
        int res=calendar.get(Calendar.DATE);
        return res;
    }
    public static int betweenDays(Date start,Date end){
        int res=0;
        if(start!=null && end!=null){
            long s=start.getTime();
            long e=end.getTime();

            res=(int)((e-s)/1000/3600/24);
            return res;
        }
        return res;
    }
    
    /**
     * 计算指定的时间到今天相差多少天
     * @param start
     * @return int
     */
	public static int betweenDaysToNow(Date start) {
		int res = 0;
		if (start != null) {
			long s = start.getTime();
			long e = System.currentTimeMillis();

			res = (int) ((e - s) / 1000 / 3600 / 24);
			return res;
		}
		return res;
	}
    public static List<Date> getDateLists(String year,String month){
        List<Date> list=new ArrayList<Date>();
        Calendar calendar=Calendar.getInstance();
        int y=calendar.get(Calendar.YEAR);
        int m=calendar.get(Calendar.MONTH)+1;

        if(Integer.parseInt(year)==y && Integer.parseInt(month)==m){
            for(int i=1;i<=getCurrentDayNum();i++){
                String date=year+"-"+month+"-"+i;
                Date d=stringToDate(date,"yyyy-MM-dd");
                list.add(d);
            }
        }else{
            for(int i=1;i<=getDaysOfMonth(year, month);i++){
                String date=year+"-"+month+"-"+i;
                Date d=stringToDate(date,"yyyy-MM-dd");
                list.add(d);
            }
        }

        return list;
    }
    public static List<Date> getDaysListOfMonth(String year,String month){
        List<Date> resList=new ArrayList<Date>();
        int num=getDaysOfMonth(year, month);
        for(int i=1;i<=num;i++){
            String date=year+"-"+month+"-";
            if(i<10){
                date=date+"0";
            }
            date=date+""+i;
            Date d=stringToDate(date,"yyyy-MM-dd");
            resList.add(d);
        }
        return resList;
    }
    public static int[] getCalendar(){
        int[] res=new int[3];
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        res[0]=year;
        int month=calendar.get(Calendar.MONTH ) + 1;
        res[1]=month;
        int day=calendar.get(Calendar.DATE);
        res[2]=day;

        return res;
    }

    public static int[] dateToInt(Date date){
        int[] res=new int[3];
        if(date!=null){
            String year=dateToStr(date,"yyyy");
            res[0]=year==null?0:Integer.parseInt(year);
            String month=dateToStr(date,"MM");
            res[1]=month==null?0:Integer.parseInt(month);
            String day=dateToStr(date,"dd");
            res[2]=day==null?0:Integer.parseInt(day);;
        }

        return res;
    }
    /**
     * 获取上一月
     * @return
     */
    public static int[] getPreCalendar(){
        int[] res=new int[3];
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.MONTH,-1);
        int year=calendar.get(Calendar.YEAR);
        res[0]=year;
        int month=calendar.get(Calendar.MONTH ) + 1;
        res[1]=month;
        int day=calendar.get(Calendar.DATE);
        res[2]=day;

        return res;
    }

    /**
     * 获取去年同月
     * @return
     */
    public static int[] getLasCalendar(){
        int[] res=new int[3];
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.YEAR,-1);
        int year=calendar.get(Calendar.YEAR);
        res[0]=year;
        int month=calendar.get(Calendar.MONTH ) + 1;
        res[1]=month;
        int day=calendar.get(Calendar.DATE);
        res[2]=day;

        return res;
    }

    public static Date getDate(int num){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(calendar.DATE,num);//把日期往后增加一天.整数往后推,负数往前移动
        return calendar.getTime();   //这个时间就是日期往后推一天的结果
    }


    private static String getString(String dateStatic, Date time1) {
        String dateStr;Calendar c = Calendar.getInstance();
        c.setTime(time1);
        Integer i = Integer.valueOf(c.get(Calendar.HOUR_OF_DAY));
        List<Integer> integers = Arrays.asList(arr);
        String s = String.valueOf(i);
        if(integers.contains(i)){
            dateStr=s+dateStatic;
        }else{
            String s1 = String.valueOf(i + 1);
            dateStr=s1+dateStatic;
        }
        return dateStr;
    }

    public static void main(String[] args) {
        System.out.println(dateToStr(new Date(), "yyyy-MM-dd"));
        System.out.println(getCurrentHourNum());
        System.out.println(getTimeLists("2015-10-07"));
        System.out.println(getTimeStrLists("2015-10-07"));
        System.out.println("###"+getHTimeLists("2015-11-04"));
        System.out.println(getDateLists("2015", "10"));
        System.out.println(getBeginOfMonth("2015", "04"));
        System.out.println("***** "+getLatestTime());
        System.out.println(getAllTimeLists("2015-10-15"));
        System.out.println(getAllTimeLists("2015-10-15").size());

        System.out.println(getAllTimeStringLists("2015-10-15").size());

        System.out.println(getHourStringHH());

        System.out.println(new Date());
        System.out.println();

        int a1[]=getCalendar();

        System.out.println(a1[0]+"-"+a1[1]+"-"+a1[2]);
        a1=getPreCalendar();
        System.out.println(a1[0]+"-"+a1[1]+"-"+a1[2]);
        a1=getLasCalendar();
        System.out.println(a1[0]+"-"+a1[1]+"-"+a1[2]);

        System.out.println(getAllDays(2016,2).length);

        System.out.println(getAllTimeLists(2016,1,29,0,0,30));

        System.out.println("**************:"+getTimeScale());

        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DATE,0);
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        int day=calendar.get(Calendar.DATE);

        System.out.println(year+"-"+month+"-"+day);


        //System.out.println(new Date().getTime()-stringToDate("2015-06-01","yyyy-MM-dd").getTime());

        System.out.println(betweenDays(stringToDate("2016-08-01","yyyy-MM-dd"),new Date()));
    }
}
