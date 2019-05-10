package com.example.demo.face;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.baidu.aip.util.Base64Util;
import com.baidu.aip.util.Util;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "16223524";
    public static final String API_KEY = "7DFkKXBNV0iyUmUB8Vqqjnyi";
    public static final String SECRET_KEY = "uZ6IpwaQsLnfEr6R001mWYAlzg9WyU5N";

    //如果使用代理设置端口为本机的8080
    private static String proxy_host = "localhost";
    private static int proxy_port = 8090;


    public static void main(String[] args) throws IOException {
        // 初始化一个AipFace
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

//        // 调用接口
        testFace(client);
        sample(client);
    }
    public static void testFace(AipFace client)throws IOException{
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("face_field", "age");
        options.put("max_face_num", "2");
        options.put("face_type", "LIVE");
        String imageType = "BASE64";
        String image = Base64Util. encode(Util.readFileByBytes("E:\\test.jpg"));
        // 人脸检测
        JSONObject res = client.detect(image,imageType,options);
        System.out.println(res.toString(2));
    }
    public static void sample(AipFace client)throws IOException {
        String image1 = Base64Util.encode(Util.readFileByBytes("E:\\test.jpg"));
        String image2 = Base64Util.encode(Util.readFileByBytes("E:\\test2.jpg"));

        // image1/image2也可以为url或facetoken, 相应的imageType参数需要与之对应。
        MatchRequest req1 = new MatchRequest(image1, "BASE64");
        MatchRequest req2 = new MatchRequest(image2, "BASE64");
        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
        requests.add(req1);
        requests.add(req2);

        JSONObject res = client.match(requests);
        System.out.println(res.toString(2));
    }
}