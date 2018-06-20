package com.huntech.web.common;

import java.text.DecimalFormat;

/**
 * Created by jht0701 on 2016/6/2.
 */
public class NumberUtils {
	
	/**
	 * 生成随机整数
	 * @param n
	 * @return
	 */
	public static int generateRandomNumber(int n) {
		int r = 0;
		double d = Math.random() * Math.pow(10, n) + 100;
		r = (int) d;
		return r;
	}

	public static int generateRandomNumber(double m, int n) {
		int r = 0;
		double d = Math.pow(m, n);
		r = (int) d;
		return r;
	}

	/**
	 * 格式化double数值，保留小数点后两位
	 * @param value double
	 * @return String
	 */
	public static double pointTwo(Double value) {
		if (null == value){
			return 0.0;
		}
		DecimalFormat df = new DecimalFormat("######0.00");
		return Double.valueOf(df.format(value));
	}


    public static double pointTwo(Double value,int divisor){
        if(null==value){
            return 0;
        }
        DecimalFormat df = new DecimalFormat("######0.0000");
        return Double.valueOf(df.format(value / divisor));
    }

	/**
	 * 格式化double数值，保留小数点后四位
	 * @param value double
	 * @param divisor int 除数
	 * @return double
	 */
	public static double pointFour(Double value, int divisor) {
		if (null == value){
			return 0;
		}
		DecimalFormat df = new DecimalFormat("######0.0000");
		return Double.valueOf(df.format(value / divisor));
	}
	
	/**
	 * 比较数值
	 * @param value double
	 * @return String
	 */
	public static double compare(Double value, double compare, double trueVal, Double falseVal) {
		if (null == value){
			return 0;
		}
		return  value > compare ? trueVal : falseVal;
	}
	
	/**
	 * 格式化double数值，保留小数点后四位
	 * @param value double
	 * @return String
	 */
	public static double pointFour(Double value) {
		if (null == value){
			return 0.0;
		}
		DecimalFormat df = new DecimalFormat("######0.0000");
		return Double.valueOf(df.format(value));
	}
	
	/**
	 * 处理两数相除，小数点保留指定位数
	 * @param molecule double
	 * @param denominator double
	 * @return double
	 */
	public static double divideVal(double molecule, double denominator, int decimals){
		if (denominator == 0){
			return 0;
		}
		double number = molecule / denominator;
		int value = 1;
		for(int i=0; i<decimals; i++){
			value = value * 10;
		}
		int result = (int)(number * value);
		double res = (double)result / value;
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(generateRandomNumber(14));
		System.out.println(generateRandomNumber(1.22, 2));

		int i = 0;
		double d = 2.5;
		i = (int) Math.pow(d, 2);
		System.out.println(i);
	}
}
