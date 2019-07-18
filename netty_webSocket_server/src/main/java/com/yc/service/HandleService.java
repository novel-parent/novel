package com.yc.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LX
 * @date 2019/7/18 - 13:08
 */
public class HandleService {


    public List<String> replaceList = new ArrayList<>();

    public Handle handle ;

    public HandleService(){

        handle = new Handle();

        initReplaceList();
    }


    public void initReplaceList(){

        BufferedReader br = null;
        try {
            InputStreamReader is = new InputStreamReader(new FileInputStream("netty_webSocket_server/replaceKey.txt"),"utf-8");

            br  = new BufferedReader(is);

            String line = null;

            while ( ( line = br.readLine() ) !=null){

                replaceList.add(line);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                if(br!=null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public String distribution(String message){

        message = initMessage(message);

        if(message.length()<=2){
            return "null";
        }

        String result = "null" ;

        String key = "搜索";
        int index = message.indexOf( key );
        if(  index >= 0 ){

            message = message.substring(index + 2 );

            result = handle.searchHandler(key, message);
            return result;
        }
        key = "更新";
        index = message.indexOf(key);
        if(index >=0 ){

            message = message.substring( 0, index );
            result = handle.updateChapter(key, message);
            return result;
        }

        key = "打开" ;
        index = message.indexOf(key);
        if( index>=0 ){
            message = message.substring(index + 2 );
            result = handle.open(key, message);
            return result;
        }

        result = handle.others(message);

        return result;

    }

    public String initMessage(String message){

        int size = replaceList.size();

        for( int i = 0 ; i < size ; i++ ){

            message = message.replace(replaceList.get(i), "");
        }
        return message;
    }



}
