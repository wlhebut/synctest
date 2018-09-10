package com.huntech.pvs.webSocket;

import com.alibaba.fastjson.JSONObject;
import com.huntech.pvs.common.redis.VCache;
import com.huntech.pvs.view.services.UserFrontView;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value="/chatServer",configurator=HttpSessionConfigurator.class)
public class ChatServer{
	private static int onlineCount=0;	//统计在线人数
	private static CopyOnWriteArraySet<ChatServer> webSocket= new CopyOnWriteArraySet<>();//存放每个Server设置为线程安全
	private Session session;
	private String openid;//用户Id
	private HttpSession httpSession;
	private static List<UserFrontView> list= new ArrayList<>();//存放每个用户id(可以显示在线或者不在线)
	private static Map<String,Session> routetab= new HashMap<>();//存放session
	@OnOpen
	public void onOpen(Session session,EndpointConfig config)//连接时调用此函数
	{
		this.session=session;
		webSocket.add(this);         //添加此Server      
		addOnlineCount();	//在线人数加1；
		this.httpSession=(HttpSession) config.getUserProperties().get(HttpSession.class.getName());//获取此Server的httpSession
		this.openid =(String) httpSession.getAttribute("openid");//获取用户Id
		System.out.println("openid:"+ openid);

		insertList(list, openid);
		routetab.put(openid, session);//把session按用户Id存放到map中
		String message=getMessage("[" + openid + "]加入聊天室,当前在线人数为"+getOnlineCount()+"位", "notice",  list);//获取广播的语句格式
		broadcast(message);//广播提示语句


		//遍历离线的所有消息，发送给再次登录的用户。
		Set<String> setByKey = VCache.getSetByKey(openid);
		if(setByKey!=null&&setByKey.size()>0){
			for (String s : setByKey) {
				singleSend(s,(Session)routetab.get(openid));//发送信息给指定用户
			}
		}

	}

	private void insertList(List<UserFrontView> list, String openid) {

		Boolean hsUser=false;
		for (UserFrontView userFront : list) {
			if(userFront.getOpenid().equals(openid)){
				userFront.setOnLine("1");//在线
				hsUser=true;
			}
		}
		if(!hsUser){
			UserFrontView userFront = new UserFrontView();
			userFront.setOnLine("1");//在线
			userFront.setOpenid(openid);
			list.add(userFront);//添加到list
		}

	}

	@OnClose
	public void onClose(){//关闭时调用
		webSocket.remove(this);//移除次Server
		subOnlineCount();     //人数减一
		updateList(list, openid);

//		list.update(openid);//移除次用户id
		routetab.remove(openid);//移除MAP中的次用户
		String message=getMessage("[" + openid +"]离开了聊天室,当前在线人数为"+getOnlineCount()+"位", "notice", list);
		broadcast(message);//广播
	}

	private void updateList(List<UserFrontView> list, String openid) {
		for (UserFrontView userFront : list) {
			String userid1 = userFront.getOpenid();
			if(openid.equals(userid1)){
				userFront.setOnLine("0");
			}
		}
	}

	@OnMessage
	public void onMessage(String _message)//接受到数据时调用
	{
		JSONObject chat= JSONObject.parseObject(_message);//解析次JSON为对象
		JSONObject message= JSONObject.parseObject(chat.get("message").toString());//获取message中的数据
		if(message.get("to")==null||message.get("to").toString().equals("")){//如果发送的人为空，则进行广播
			broadcast(_message);
		}else
		{
			String [] userlist=message.get("to").toString().split(",");//获取要发送的名称
			singleSend(_message,(Session)routetab.get(message.get("from")));//发送给自己
			for(String user:userlist)//按用户进行发送
			{
				if(!user.equals(message.get("from")))
				{
					singleSend(_message,(Session)routetab.get(user));//发送信息给指定用户
				}
			}
		}
	}
	@OnError
	public void onError(Throwable error){
		System.out.println(error);
		error.printStackTrace();
	}
	public void broadcast(String message)//广播信息
	{
		for(ChatServer chat:webSocket){
			try{
				  chat.session.getBasicRemote().sendText(message);
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	  public void singleSend(String message, Session session){
	        try {
	        	if(session!=null){
					session.getBasicRemote().sendText(message);
				}else{
	        		//保存到redis
					JSONObject chat= JSONObject.parseObject(message);//解析次JSON为对象
					JSONObject message2= JSONObject.parseObject(chat.get("message").toString());//获取message中的数据
					VCache.setVBySet((String)message2.get("to"),message);
				}
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	public String getMessage(String message,String type,List list)
	{
		JSONObject member=new JSONObject();
		member.put("message", message);
		member.put("type", type);
		member.put("list", list);
		return member.toString();
	}
	  public  int getOnlineCount() {
	        return onlineCount;
	    }

	    public  void addOnlineCount() {
	        ChatServer.onlineCount++;
	    }

	    public  void subOnlineCount() {
	        ChatServer.onlineCount--;
	    }
}
