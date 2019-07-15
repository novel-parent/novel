package com.yc.user.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016100100638754";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCEVY/J0OHM+hXSV5ZMyrPWJKLa25zWLPHhpmZjLqYGcTB0lXo+KHspgBdAjQ2D04JSUvKhhRbgNBV0ZF2/+ZSwoA3s9Bl2UPnp3l0BJvWJejzVh6OOzEF3j56Yxb7ExNPqScm7RG4xDsmcyLS+tnL2QN3xDaCE0eJwscpWAny+3DJ30REmju/jN/96i0PwgIxrUQdvE6iCK19Hjmo7Z1FBq6O0hnHh/IayJ8hfguEef1ViQOBTvjW5j7LuH1qiIUv9U9fu2HNFDTgvmYzNq2dwhjZWBi3FTthlMmzLINnDI68XG3vb9ej4l2416fcnzjpjHQJrfDUIXLTuwAHEqYRtAgMBAAECggEAU8J4PUwJ75yG/VjU2Awg4bTUo2QHlARkoOeavMJE8aTo/5GxCvDCa9UYYpIk8MCKJyM7UYKUpRoyTjZMpHsLYvQbfFRQXXQJir5k7ZrEJN0K7jhpDLQ557wurRHUmmTeoNdNaUt513E9qQ/cXy3J/BW4pJ90bz0NbzkJEYGHhaGdZRq4qMHoTJlXpkR1nmzM94qpDeWGWABWaR9YcmNL2012oCD+wjxw0tcIcw2Uv6ahD9JprMGdRnHK43QCrbIhkQ1rydlp8yyvgFTf36abbD28i0NDJXRbKm14RBF571QZexb4gMNnHURG2ESROrlZyeMqT/pWQltWqcKY0yd+oQKBgQDPUk4hgADxu1ootZenyEvIXQh4/46S2vlE6BXO+S+5b27YTnG8hz6XKcyBUJZwNm/8f5ZVZC0+Pf/YDWLVohYncGgGjddU7/dvjG7k1azPUEaynsJkqqU+74/8eJsdbLie0gsXAeSMZ35Jo82xkGDB7PJmXHLqBl15/nj3+nkOKQKBgQCjZ+qFIjv0ZtFtMJHOBG76q+S8ID/hzyulJHeHdLnvAiz7zFUoeFOuOvLEgX9PxsS/dYnt8B6zgmfcktJj+NxvbAby43TPh/DE4o7WOiAWJiDpT6WAqJ3COT4S07Sx0pHwYvsOL+U8cjhD2cigXcarlbcm5eldyiD+j+uV2OzEpQKBgB1MtnoJixier7k9ILe3mO4yJ7Zh95ZNmBji6+IaWWJNm066l1xbiL74S0yjRP+K0fzPU0GyLKq1PGkeSy+B/ruIKUtz1FDOsRt0r19ry0ZpQ/SOd06ex0fDt4eoy9M2wEjByotv2wr0vWZO3g0QKHx/ripFOoBUcfWBvzrcjSsxAoGAJjhrKWK9hUf7Wj/PCtIMp0NHiB0+8/FCMylZb+yEhPwMS4UashGa+Ri+qenkPmOup121ulq8w54P7w7EeS+/V6x735oGO3h/f33CjSchVCzs68V+X56Q79n1w++SxzkKe6CbOlFHnCDXOj+ZZrEog//LzCRgtlhN6Vz+bJlFoCUCgYASX3ypSYCUU65bwt7s6VxhpixFzNcFGeMhGFhIR++RuEMqF2KSjzPqyLQuP2J4pjgBX3RxlVXIXbPVuXag+Ga4VSCPU+iD+reMhrEHDuHEKcvoNx3qZWkpYjirimLa5SDoRnCzmG1kWY/YwB67Uigqq/IQxw/qpxDlvXDsPYIkSg==";
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAynxt0EUXPBc6jfDok9RxMuRJ+y6Manqdv3qE8nBNjhlGsr5jabw1PoClEMNLt8M9hvzUfjKGPBAWn8j8knVjPcg/MolqxsWLhhcN/FXBx+Xl0n3OBXGpvTBbaj+xhLY/EADO+gZdCpQrxvpPYRHrIYLcvE93fmGFX9q+7ureFAbiQnGM0MKAsF/FVOAT1gQrX53RcM9b3ecVUmQ1bta3zJgcIgK7gSTeV4yy2vAM9rrMNQgQWnGCPhrjEO5Vl//5kLNKmVMmpQ1x+q0nTKtNRTccxxOHZjrlG46tjif2n0H8ZaMYQbVbLbqSziLrBXTKftwAVH610x+9fUwdu+DXYwIDAQAB";
	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "106.14.162.109:8080/chongzhihou.u";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "106.14.162.109:8080/chongzhihou.u";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

