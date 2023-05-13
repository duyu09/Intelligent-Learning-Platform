package com.example.blog.demos.web.service.serviceimpl;

import com.example.blog.demos.web.Dao.SignRepository;
import com.example.blog.demos.web.entity.SignInRecord;
import com.example.blog.demos.web.service.Sign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class SignImpl implements Sign {
    @Autowired
    SignRepository signRepository;
    @Autowired
    SignInRecord signInRecord;
    Map<String,Object> result=new HashMap<>();
    @Override
    public Map<String, Object> signIn(Long userId, String context) {
        signInRecord.setUserId(userId);
        signInRecord.setEncourageContext(context);
        signInRecord.setSignInTime(System.currentTimeMillis());
        signRepository.save(signInRecord);
        result.put("code",0);
        return result;
    }
    public Map<String,Object> readSignContext(Long userId) {
        SignInRecord record = signRepository.findByUserId(userId);
        result.put("code",0);
        if(record == null){
            result.put("context",0);
        }else {
            result.put("context",record.getEncourageContext());
        }return result;
        }

    @Scheduled(cron ="0 0 2 * * ? " )
    @Override
    public void deleteSign() {
        signRepository.deleteAll();
        System.out.println("删除成功");
    }


}
