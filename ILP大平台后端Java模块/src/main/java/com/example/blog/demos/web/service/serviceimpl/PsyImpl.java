package com.example.blog.demos.web.service.serviceimpl;

import com.example.blog.demos.web.Dao.PsyRepository;
import com.example.blog.demos.web.entity.ParRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PsyImpl {
    @Autowired
    PsyRepository psyRepository;
    Map<String,Object> result=new HashMap<>();
    @Autowired
    ParRecord parRecord;
//    public Map<String,Object> dredgePsy(){
//        parRecord.setUserId(userId);
//        parRecord.setParMode(mode);
//        parRecord.setInputContext(context);
//        parRecord.setParTime(System.currentTimeMillis());
//        psyRepository.save(parRecord);
//        result.put("code",0);
//        return result;
//    }
    public Map<String,Object> showPsy(Long userId){
        List<ParRecord> records=psyRepository.findAllByUserId(userId);
        Map<String,Object> data=new HashMap<>();
        int count=1;
        for (ParRecord record:records){
            data.put("rec"+count,record);
                    count++;
        }
        result.put("code",0);
        result.put("data",data);
        return result;
    }
    public static String sendPostRequestToPython(String jsonStr) {
        try {
            // 创建连接
            URL url = new URL("http://127.0.0.1:8000/");
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
