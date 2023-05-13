package com.example.blog.demos.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.blog.demos.web.Dao.PsyRepository;
import com.example.blog.demos.web.aspect.PointCut.TokenRequired;
import com.example.blog.demos.web.entity.ParRecord;
import com.example.blog.demos.web.service.serviceimpl.PsyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.example.blog.demos.web.untils.httpUtils.sendPostRequestToPython;

@RestController
@CrossOrigin(origins = "*")
public class PsyController {
    Map<String,Object> result=new HashMap<>();
    @Autowired
    ParRecord parRecord;
    @Autowired
    PsyRepository psyRepository;
    @Autowired
    PsyImpl psyimpl;
    @TokenRequired
    @PostMapping("dredgePsy")
    public ResponseEntity<Map<String,Object>> dredgePsy(@RequestBody ParRecord parRecord){
        // 将输入数据转为JSON格式并发送给Python的AI模块
        parRecord.setParTime(System.currentTimeMillis());
        psyRepository.save(parRecord);
        JSONObject requestJson = new JSONObject();
        requestJson.put("prompt",parRecord.getInputContext());
        String responseJsonStr = PsyImpl.sendPostRequestToPython(requestJson.toString()); //修改过
        System.out.println(responseJsonStr);

        JSONObject responseJson = JSONObject.parseObject(responseJsonStr);
        String response= (String) responseJson.get("response");
        result.put("code",0);
        result.put("response",response);
        return ResponseEntity.ok(result);
    }
    @TokenRequired
    @PostMapping("showPsy")
    public ResponseEntity<Map<String,Object>> showPsy(@RequestBody Map<String,String> params){
        Long userId= Long.valueOf(params.get("userId"));
        return ResponseEntity.ok().body(psyimpl.showPsy(userId));

    }
}
