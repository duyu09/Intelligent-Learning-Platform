package com.example.blog.demos.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.blog.demos.web.Dao.SkillTestRepository;
import com.example.blog.demos.web.aspect.PointCut.TokenRequired;
import com.example.blog.demos.web.entity.AbilityTestRecord;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.example.blog.demos.web.untils.httpUtils.sendPostRequestToPython;

@RestController
@CrossOrigin(origins = "*")
public class SkillTestController {
    @Autowired
    AbilityTestRecord abilityTestRecord;
    @Autowired
    SkillTestRepository skillTestRepository;
    Map<String,Object> result=new HashMap<>();
    @TokenRequired
    @PostMapping("/skillTest")
    public ResponseEntity<Map<String,Object>> predictSalary(@RequestBody AbilityTestRecord abilityTestRecord) throws JsonProcessingException {
        // 将输入数据转为JSON格式并发送给Python的AI模块
        skillTestRepository.save(abilityTestRecord);
        JSONObject requestJson = new JSONObject();
        requestJson.put("skillTest",abilityTestRecord);
        String responseJson = sendPostRequestToPython(requestJson.toString());
        // 解析Python返回的JSON格式数据，获取预测的薪资
        ObjectMapper objectMapper=new ObjectMapper();

        if(abilityTestRecord.getWorkMode()==0){
            JsonNode  jsonNode= objectMapper.readTree(responseJson);
            Long salary=jsonNode.get("data").get("salary").asLong();
            String job=jsonNode.get("data").get("job").asText();
            result.put("code",0);
            result.put("salary",salary);
            result.put("job",job);
             return ResponseEntity.ok().body(result);
        }else{
            Map<String,Object> map=new HashMap<>();
            JsonNode jsonNode= objectMapper.readTree(responseJson);
            String diff=jsonNode.get("data").get("diff").asText();
            map.put("code",0);
            map.put("diff",diff);
            return ResponseEntity.ok().body(map);
        }
    }

    // 发送POST请求到Python的AI模块


}
