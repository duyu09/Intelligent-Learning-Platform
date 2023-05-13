package com.example.blog.demos.web.service.serviceimpl;

import com.example.blog.demos.web.Dao.StudyRepository;
import com.example.blog.demos.web.entity.ParRecord;
import com.example.blog.demos.web.entity.StudyRoom;
import com.example.blog.demos.web.service.StudyRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
@Service
public class StudyRoomImpl implements StudyRoomService {
    @Autowired
    StudyRepository studyRepository;
    @Autowired
    StudyRoom studyRoomNew;
    private Long length= Long.valueOf(0);
    private Long startTime= Long.valueOf(0);
    private Long floor= Long.valueOf(0);
    private Long site= Long.valueOf(0);

    Map<String,Object> result=new HashMap<>();


    @Override
    public Map<String, Object> readStudyRoom(Long floor) {
        List<StudyRoom> StudyRoomList=studyRepository.findAllByFloor(floor);
        Map<String,Object> data=new HashMap<>();
        int count=1;
        for (StudyRoom studyRoom:StudyRoomList){
            data.put("site"+count,studyRoom);
            count++;
        }
        result.put("code",0);
        result.put("data",data);
        return result;
    }

    @Override
    public Map<String, Object> startStudy(StudyRoom studyRoom) {
        this.length= studyRoom.getLength();
        this.startTime=studyRoom.getStartTime();
        this.floor=studyRoom.getFloor();
        this.site=studyRoom.getSite();
        studyRoomNew= studyRepository.findByFloorAndSite(studyRoom.getFloor(),studyRoom.getSite());
        if(studyRoomNew.getUserId()==null){
       studyRoomNew.setUserId(studyRoom.getUserId());
       studyRoomNew.setStartTime(studyRoom.getStartTime());
       studyRoomNew.setLength(studyRoom.getLength());
       studyRoomNew.setContext(studyRoom.getContext());
       studyRoomNew.setEncourage(studyRoom.getEncourage());
       studyRepository.save(studyRoomNew);
       result.put("code",0);
        }else {
            result.put("code",2);
        }
        return result;
    }
    @Transactional
    @Override
    public Map<String, Object> readStudyStatus(Long userId, Long operation) {
        Long floorNew=studyRoomNew.getFloor();
        Long siteNew=studyRoomNew.getSite();
       if (operation==0){
           studyRoomNew=studyRepository.findByUserId(userId);
           if (studyRoomNew==null){
               result.put("code",0);
               result.put("result",0);
               return result;
           }else {
               Map<String,Object> resultNew=new HashMap<>();
               resultNew.put("code",0);
               resultNew.put("result",1);
               resultNew.put("data",studyRoomNew);
               return resultNew;
           }
       }else if (operation==1) {
           studyRepository.updata(floorNew, siteNew);
           result.put("code", 0);
           result.put("result", 0);
           return result;
       }else {
                result.put("code",0);
                result.put("result",1);
               return result;
       }

}      @Transactional
       @Scheduled(fixedDelay = 1000)
       public Map<String,Object> deleteStudy(){
        if (System.currentTimeMillis()>=startTime+length){
        studyRepository.updata(floor,site);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("result",3);
        return map;
        }else{
            return null;
        }
    }

}
