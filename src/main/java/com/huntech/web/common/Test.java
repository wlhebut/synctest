package com.huntech.web.common;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.net.URLDecoder;
import java.util.List;import java.util.ArrayList;

/**
 * Created by JHT0701 on 2015/12/22.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpost = new HttpPost("http://tisp.utourworld.com/travel-web/upload/op/agentlinexml/OPL00002555.xml");  //172.16.2.4:8085
        HttpGet httpGet=new HttpGet("http://tisp.utourworld.com/travel-web/upload/op/agentlinexml/OPL00002555.xml");
        //List<NameValuePair> nvps = new ArrayList <NameValuePair>();
        //HttpEntity httpEntity=new UrlEncodedFormEntity(nvps,"GBK");httpEntity.getContentEncoding();
        //httpost.setEntity(httpEntity);//new UrlEncodedFormEntity(nvps).setContentEncoding("GBK")
        HttpResponse response = httpclient.execute(httpost);

        HttpEntity entity = response.getEntity();
        //System.out.println(entity.getContentEncoding().getName());
        String body =URLDecoder.decode(EntityUtils.toString(entity), HTTP.DEFAULT_CONTENT_CHARSET);
        System.out.println("body="+body);
    }
}
