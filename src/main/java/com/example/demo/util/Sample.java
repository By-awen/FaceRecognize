package com.example.demo.util;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.baidu.aip.util.Base64Util;
import com.baidu.aip.util.Util;
import org.json.JSONObject;

import javax.swing.*;
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

    public static void main(String[] args) {
        try{
            sample("E://image//test.jpg","E://下载//1557835952298.jpg");
            testFace("E://image//test.jpg");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testFace(String pic)throws IOException{
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("face_field", "age");
        options.put("max_face_num", "2");
        options.put("face_type", "LIVE");
        String imageType = "BASE64";
        String image = Base64Util. encode(Util.readFileByBytes(pic));

        // 人脸检测
        JSONObject res = client.detect(image,imageType,options);
        System.out.println(res.toString(2));
        JSONObject jsonObject = (JSONObject)res.get("result");
        JOptionPane.showMessageDialog(null, jsonObject.toString(5));
    }
    public static Double sample(String img1,String img2)throws IOException {
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // image1/image2也可以为url或facetoken, 相应的imageType参数需要与之对应。
        //传过来的是路径需要转化程图片
        img1 = Base64Util.encode(Util.readFileByBytes(img1));
        img2 = Base64Util.encode(Util.readFileByBytes(img2));
        MatchRequest req1 = new MatchRequest(img1, "BASE64");
        MatchRequest req2 = new MatchRequest(img2, "BASE64");
        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
        requests.add(req1);
        requests.add(req2);

        JSONObject res = client.match(requests);
        System.out.println(res.toString(2));
        JSONObject jsonObject = (JSONObject) res.get("result");
        System.out.println(jsonObject.getDouble("score"));
        return jsonObject.getDouble("score");
    }

}