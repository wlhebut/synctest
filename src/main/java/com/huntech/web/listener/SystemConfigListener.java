package com.huntech.web.listener;

import com.huntech.pvs.dao.sys.SysInformationMapper;
import com.huntech.pvs.model.sys.SysInformation;
import com.huntech.pvs.model.sys.SysInformationExample;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * 初始化系统常量等
 * Created by JHT0701 on 2016/5/12.
 */
public class SystemConfigListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		SysInformationMapper sysInformationMapper = applicationContext.getBean(SysInformationMapper.class);
		SysInformationExample sysInformationExample = new SysInformationExample();
		sysInformationExample.createCriteria().andEnabledEqualTo("1");
		List<SysInformation> sysInformationList = sysInformationMapper.selectByExample(sysInformationExample);

        if(sysInformationList!=null && sysInformationList.size()>0){
            for(SysInformation sysInformation:sysInformationList){
                servletContext.setAttribute(sysInformation.getInfoSign(),sysInformation.getInfoValue());
                System.out.println(sysInformation.getInfoSign()+" >>> "+sysInformation.getInfoValue());
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext=servletContextEvent.getServletContext();
        servletContext.removeAttribute("customer_type");
        servletContext.removeAttribute("customer_name");
        servletContext.removeAttribute("customer_logo");
        servletContext.removeAttribute("system_name");
        servletContext.removeAttribute("cropyright_name");
    }
}
