package com.example.blog.demos.web.untils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class httpUtils {
    public static String sendPostRequestToPython(String jsonStr) {
        try {
            // 创建连接
            URL url = new URL("http://127.0.0.1:5200/skillTest");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            // 发送请求
            connection.connect();
            OutputStream os = connection.getOutputStream();
            os.write(jsonStr.getBytes());
            os.flush();

            // 获取响应
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (connection.getInputStream())));
            String output;
            StringBuilder response = new StringBuilder();
            while ((output = br.readLine()) != null) {
                response.append(output);
            }

            // 关闭连接
            connection.disconnect();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
