package com.yc.service;

import com.yc.util.DBHelper;
import com.yc.util.HttpUtil;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LX
 * @date 2019/7/18 - 17:21
 */
public class Handle {

    public Map<String,String> orderMap = new HashMap<>();

    public Map<String,String> novel = new HashMap<>();

    public Handle(){

        novel.put("斗破苍穹", "33846");
        novel.put("斗罗大陆","29616");
        novel.put("最强神医混都市","8836" );
        novel.put("最佳女婿","12126" );

        initOrderMap();
    }

    public String searchHandler(String key ,String message){

        String value = orderMap.get(key) + message;

        return value;
    }

    public String updateChapter(String key ,String message){


        String result = "null";

        String s = novel.get(message);

        if(s == null){
            return "null";
        }

        try {
            CloseableHttpResponse get = new  HttpUtil().Get("http://47.106.110.16/novelChapters.n?nid="+s);

            InputStream inputStream = get.getEntity().getContent();

            byte [] b = new byte[1024];
            int length ;

            StringBuffer stringBuffer = new StringBuffer();

            while ((length = inputStream.read(b))!=-1){

                stringBuffer.append(new String(b,0,length,"utf-8"));
            }

            String title = stringBuffer.toString().substring(stringBuffer.toString().lastIndexOf("title"));

            title = title.replace("\"", "").replace("\\", "").replace("}", "").replace("]", "").replace(" ", "").replace(":","," );

            System.out.println(title);
            String[] strings = title.split(",");

            String value = orderMap.get(key);

            result = strings[1] + ":" + value + s + "&cid="+strings[3];

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String open(String key, String message) {

        String value = orderMap.get(message);
        if(value == null){
            return "null";
        }
        return value;
    }



    public void initOrderMap(){
        //   跳转 页面是 前台进行 跳转   后台只 进行  url 的 派发
        //   前台需要对 派发出的url  要 再 进行处理
        orderMap.put("搜索", "/search.html?page=1&key=");

        orderMap.put("最新", "/read.html?nid=");

        orderMap.put("打开", "/read.html?");

        orderMap.put("我的书架", "/userbooks.html?");

        orderMap.put("会员信息", "/userinfo.html?");

        orderMap.put("个人中心", "/userinfo.html?");

        orderMap.put("修改资料", "/useredit.html?");

        orderMap.put("修改密码", "/passedit.html?");

    }


    public String others(String message) {

        System.out.println(message);
        String result = orderMap.get(message);

        if( result == null ){
            return "null";
        }

        return result ;
    }
}
