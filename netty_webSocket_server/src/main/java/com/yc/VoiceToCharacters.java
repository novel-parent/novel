package com.yc;

import com.baidu.aip.speech.AipSpeech;
import org.json.JSONObject;

/**
 * @author LX
 * @date 2019/7/8 - 20:52
 */
public class VoiceToCharacters {


    //设置APPID/AK/SK
    public static final String APP_ID = "16736316";
    public static final String API_KEY = "qo6vRb2k1Wkh9BhGhNdaLc6v";
    public static final String SECRET_KEY = "lwGxeyVszaolNSlXbqAbDup89tZ2fiWS";

    public static void main(String[] args) {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

            // 调用接口
        JSONObject res = client.asr("netty_webSocket_server/16k.wav", "wav", 16000, null);
        System.out.println(res.toString(2));

    }
}
