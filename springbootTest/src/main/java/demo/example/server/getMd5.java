package com.course.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import springfox.documentation.spring.web.json.Json;

public class getMd5 {

    public static void main(String args[]) throws ClientProtocolException, IOException {

        String url = "https://udesk-rd-bj-05.s2.udesk.cn/open_api/callcenter/agent_work_way?";
        String key = "d42b1d7a57a7e6101fddd3be9f358cac";
        long curtime=System.currentTimeMillis();
        Date date = new Date(curtime);              
        SimpleDateFormat smd=new SimpleDateFormat("yyyyMMddHHmmss");
        String l=smd.format(date);
        System.out.println(l);
        String str = "agent_email=bai@udesk.cn&timestamp=" + l +"&"+ key;
        System.out.println(str);
        String md5str = getMd5.getMD5(str);
        System.out.println(md5str);
        String email = "bai@udesk.cn";
        String screct = "agent_email=" + email + "&timestamp=" + l + "&sign="+md5str;
        System.out.print(screct);
        
        String uri=url+str+"&"+screct;
        System.out.print(uri);
        
        
        CloseableHttpClient hc=HttpClients.createDefault();
        HttpGet hg=new HttpGet(uri);
        HttpResponse httpResponse=hc.execute(hg);
        HttpEntity he=httpResponse.getEntity();
        //System.out.print(EntityUtils.toString(he));
        String responseString=EntityUtils.toString(he);
        JSONObject responsejson=JSON.parseObject(responseString);
        System.out.println(responsejson);
        //hc.close();
        

        
        
        

    }

    public static String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            // 一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
}