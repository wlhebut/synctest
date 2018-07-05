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
	private static int onlineCount=0;	//ͳ����������
	private static CopyOnWriteArraySet<ChatServer> webSocket=new CopyOnWriteArraySet<ChatServer>();//���ÿ��Server����Ϊ�̰߳�ȫ
	private Session session;
	private String openid;//�û�Id
	private HttpSession httpSession;
	private static List<UserFrontView> list= new ArrayList<>();//���ÿ���û�id(������ʾ���߻��߲�����)
	private static Map<String,Session> routetab= new HashMap<>();//���session
	@OnOpen
	public void onOpen(Session session,EndpointConfig config)//����ʱ���ô˺���
	{
		this.session=session;
		webSocket.add(this);         //��Ӵ�Server      
		addOnlineCount();	//����������1��
		this.httpSession=(HttpSession) config.getUserProperties().get(HttpSession.class.getName());//��ȡ��Server��httpSession
		this.openid =(String) httpSession.getAttribute("openid");//��ȡ�û�Id
		System.out.println("openid:"+ openid);

		insertList(list, openid);
		routetab.put(openid, session);//��session���û�Id��ŵ�map��
		String message=getMessage("[" + openid + "]����������,��ǰ��������Ϊ"+getOnlineCount()+"λ", "notice",  list);//��ȡ�㲥������ʽ
		broadcast(message);//�㲥��ʾ���


		//�������ߵ�������Ϣ�����͸��ٴε�¼���û���
		Set<String> setByKey = VCache.getSetByKey(openid);
		if(setByKey!=null&&setByKey.size()>0){
			for (String s : setByKey) {
				singleSend(s,(Session)routetab.get(openid));//������Ϣ��ָ���û�
			}
		}

	}

	private void insertList(List<UserFrontView> list, String openid) {

		Boolean hsUser=false;
		for (UserFrontView userFront : list) {
			if(userFront.getOpenid().equals(openid)){
				userFront.setOnLine("1");//����
				hsUser=true;
			}
		}
		if(!hsUser){
			UserFrontView userFront = new UserFrontView();
			userFront.setOnLine("1");//����
			userFront.setOpenid(openid);
			list.add(userFront);//��ӵ�list
		}

	}

	@OnClose
	public void onClose(){//�ر�ʱ����
		webSocket.remove(this);//�Ƴ���Server
		subOnlineCount();     //������һ
		updateList(list, openid);

//		list.update(openid);//�Ƴ����û�id
		routetab.remove(openid);//�Ƴ�MAP�еĴ��û�
		String message=getMessage("[" + openid +"]�뿪��������,��ǰ��������Ϊ"+getOnlineCount()+"λ", "notice", list);
		broadcast(message);//�㲥
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
	public void onMessage(String _message)//���ܵ�����ʱ����
	{
		JSONObject chat= JSONObject.parseObject(_message);//������JSONΪ����
		JSONObject message= JSONObject.parseObject(chat.get("message").toString());//��ȡmessage�е�����
		if(message.get("to")==null||message.get("to").toString().equals("")){//������͵���Ϊ�գ�����й㲥
			broadcast(_message);
		}else
		{
			String [] userlist=message.get("to").toString().split(",");//��ȡҪ���͵�����
			singleSend(_message,(Session)routetab.get(message.get("from")));//���͸��Լ�
			for(String user:userlist)//���û����з���
			{
				if(!user.equals(message.get("from")))
				{
					singleSend(_message,(Session)routetab.get(user));//������Ϣ��ָ���û�
				}
			}
		}
	}
	@OnError
	public void onError(Throwable error){
		System.out.println(error);
		error.printStackTrace();
	}
	public void broadcast(String message)//�㲥��Ϣ
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
	        		//���浽redis
					JSONObject chat= JSONObject.parseObject(message);//������JSONΪ����
					JSONObject message2= JSONObject.parseObject(chat.get("message").toString());//��ȡmessage�е�����
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
