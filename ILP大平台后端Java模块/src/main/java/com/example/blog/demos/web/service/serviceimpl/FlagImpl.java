package com.example.blog.demos.web.service.serviceimpl;

import com.example.blog.demos.web.Dao.AimRepository;
import com.example.blog.demos.web.entity.UserAimTable;
import com.example.blog.demos.web.service.Flag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FlagImpl implements Flag {
    @Autowired
    AimRepository aimRepository;
    @Autowired
    UserAimTable aimTable;

    @Override
    public void addFlag(Long userId,String context) {
        aimTable.setUserId(userId);
         aimTable.setAim(context);
         aimRepository.save(aimTable);
    }

    @Override
    public Map<String,Object> showFlag(Long userId) {
//        Long userId=useId;
//        List<UserAimTable> flags=aimRepository.findUserAimTableByUserId(userId);
//        List<Map> list=new ArrayList<>();
//        Map<String,Object> map=new HashMap<>();
//        for (UserAimTable flag:flags) {
//            map.put("id",flag.getId());
//            map.put("context",flag.getAim());
//            map.put("time",flag.getAimSetTime());
//            list.add(map);
//        }
//
//        return
//    }
        Map<String, Object> result = new HashMap<>();
        List<UserAimTable> flagList = aimRepository.findByUserId(userId);
        Map<String, Object> data = new HashMap<>();
        int count=1;
        for (UserAimTable flag:flagList) {
            Map<String, Object> flagMap = new HashMap<>();
            flagMap.put("id", flag.getId());
            flagMap.put("context", flag.getAim());
            flagMap.put("time", flag.getAimSetTime());
            data.put("flag"+count, flagMap);
            count++;
        }
        result.put("code", 0);
        result.put("data", data);
        return result;
    }

    @Override
    public Map<String,Object> deleteFlag(Long userId) {
        aimRepository.deleteById(userId);
        Map<String,Object> result=new HashMap<>();
        result.put("code",0);
        return result;
    }
}
