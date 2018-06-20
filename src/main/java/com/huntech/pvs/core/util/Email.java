package com.huntech.pvs.core.util;

import com.huntech.pvs.dao.sys.UserMapper;
import com.huntech.pvs.dto.sys.User;
import com.huntech.pvs.dto.sys.UserExample;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 邮件发送
 * @author Administrator
 */
public class Email {

	private static final String dir = System.getProperty("catalina.home");
	private static final String separator = System.getProperty("file.separator");
	
	public static HSSFWorkbook demoHSSFWorkbook() throws Exception{
		HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("北京金鸿泰科技有限公司——电站员工排班表");
        
        BufferedImage bufferImg = null;
        String finalPath = dir + separator + "webapps" + separator + "logo" + separator + "projectLogo.png";
        File file=new File(finalPath);
        ByteArrayOutputStream byteArrayOut = null;
        if(file.exists()){
            bufferImg = ImageIO.read(file);
            byteArrayOut = new ByteArrayOutputStream();
            ImageIO.write(bufferImg, "jpg", byteArrayOut);
        }
        if(null != byteArrayOut){
            HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
            HSSFClientAnchor anchor = new HSSFClientAnchor(10, 55, 600, 250, (short) 0, 0, (short) 0, 0);
            anchor.setAnchorType(3);
            patriarch.createPicture(anchor, workbook.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
        }
        
        return workbook;
	}
	
	public synchronized static int send(ServletContext context, HSSFWorkbook workbook) throws IOException{
		FileOutputStream writeFile;
		try {
			String path = dir+separator+"运行日志.xls";
			File file = new File(path);
			if (file.exists()){
				file.delete();
			}
			writeFile = new FileOutputStream(path);
			workbook.write(writeFile);
			writeFile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return send(context);
	}
	
	/**
	 * 向 tbl_system_user 表中的用户发送运行日志邮件
	 * @return int 是否发送成功（0成功，1系统异常，2文件不存在，3无指定的用户）
	 */
	private static int send(ServletContext context) {
		File file = new File(dir+separator+"运行日志.xls");// 要发送的附件
		if (!file.exists()){
			return 2;
		}
		List<String> userList = getUserList(context);
		if (userList.isEmpty()){
			return 3;
		}
		
		MultiPartEmail email = new MultiPartEmail();	//如果要发送带附件的邮件，需使用这个类

		String eMailSmtp = String.valueOf(context.getAttribute("eMailSmtp"));	//"smtp.163.com";
		String eMailFrom = String.valueOf(context.getAttribute("eMailFrom"));	//"17080150778@163.com";
		String eMailFromPwd = String.valueOf(context.getAttribute("eMailFromPwd"));	//"tatzomencmmrflmg";
		
		email.setHostName(eMailSmtp);// 指定要使用的邮件服务器
		email.setAuthentication(eMailFrom, eMailFromPwd);// 使用163的邮件服务器需提供在163已注册的用户名、密码
		email.setCharset("UTF-8");
		try {
			email.setFrom(eMailFrom);	//设置发件人
			for(String user : userList){
				email.addTo(user);	//设置收件人
			}
			email.setSubject("运行日志");		//设置主题
			email.setMsg("请查收附件！");		//设置邮件内容

			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath(file.getPath());
			attachment.setName(file.getName());
			attachment.setDescription("运行日志");
			attachment.setDisposition(EmailAttachment.ATTACHMENT);// 附件的类型
			email.attach(attachment);
			
			email.send();
			System.out.println("邮件发送成功，发送人："+userList);
			return 0;
		} catch (EmailException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return 1;
	}
	
	/**
	 * 获取收件人列表
	 * @return List<String>
	 */
	private static List<String> getUserList(ServletContext context){
		ApplicationContext application = WebApplicationContextUtils.getWebApplicationContext(context);
		UserMapper mapper = application.getBean(UserMapper.class);
		UserExample example = new UserExample();
		example.createCriteria().andEnabledEqualTo("1");
		List<String> list = new ArrayList<String>();
		
		try {
			List<User> userList = mapper.selectByExample(example);
			if(null == userList){
				return list;
			}
			for(User user : userList){
				String email = "584529403@qq.com";
				if (checkEmail(email)){
					list.add(email);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 判断邮箱是否合法
	 * @param email String
	 * @return boolean
	 */
	private static boolean checkEmail(String email) {
		if (null == email){
			return false;
		}
		email = email.trim();
		if ("".equals(email)){
			return false;
		}
				
		boolean isExist = false;

		Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}");
		Matcher m = p.matcher(email);
		boolean b = m.matches();
		if (b) {
			isExist = true;
		} else {
			isExist = false;
		}
		return isExist;
	}
}