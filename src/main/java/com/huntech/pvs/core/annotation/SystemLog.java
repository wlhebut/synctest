package com.huntech.pvs.core.annotation;

import java.lang.annotation.*;

/** 
 *自定义注解 拦截Controller 记录系统日志
 * Created by JHT0701 on 2015/12/4.
 */  
  
@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public  @interface SystemLog {  
  
	String module()  default "";  //模块名称 系统管理-用户管理－列表页面
	String methods()  default "";  //新增用户
	String content()  default ""; //内容
    String description()  default "";  //
  
  
}  
  
