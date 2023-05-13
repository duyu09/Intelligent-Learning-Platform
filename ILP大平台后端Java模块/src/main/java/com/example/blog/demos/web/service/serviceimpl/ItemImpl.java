package com.example.blog.demos.web.service.serviceimpl;

import com.example.blog.demos.web.Dao.ForumRecordRepository;
import com.example.blog.demos.web.entity.ForumRecord;
import com.example.blog.demos.web.service.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
     public class ItemImpl implements Item{
    Map<String,Object> result=new HashMap<>();
    @Autowired
    ForumRecordRepository forumRecordRepository;
    @Autowired
    ForumRecord forumRecord;
    @Override
     public Map<String, Object> releaseItem(Long userId,Long forumId, String context) {
      List<ForumRecord> records=forumRecordRepository.findAllByForumId(forumId);
      Integer floor=records.size()+1;
//      Date date=new Date();
//      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:SSS");
//        String publishTime=simpleDateFormat.format(date);

      Long publishTime= System.currentTimeMillis();
      forumRecord.setPublishUserId(userId);
      forumRecord.setForumId(forumId);
      forumRecord.setItemContext(context);
      forumRecord.setPublishTime(publishTime);
      forumRecord.setFloor(floor);
      forumRecord.setUpvote(0);
      forumRecordRepository.save(forumRecord);
      result.put("code",0);
      result.put("floor",floor);
      return result;

    }

    @Override
    public Map<String, Object> showItem(Long forumId) {
        List<ForumRecord> records=forumRecordRepository.findAllByForumId(forumId);
        Map<String, Object> data = new HashMap<>();
        int count=1;
        for (ForumRecord record:records) {
            Map<String, Object> recordMap = new HashMap<>();
            recordMap.put("id", record.getId());
            recordMap.put("floor",record.getFloor());
            recordMap.put("publishUser",record.getPublishUserId());
            recordMap.put("context",record.getItemContext());
            recordMap.put("time",record.getPublishTime());
            recordMap.put("upvote",record.getUpvote());
            data.put("item"+count, recordMap);
            count++;
        }
        result.put("code", 0);
        result.put("data", data);
        return result;

    }

    @Override
    public Map<String, Object> deleteItem(long id, Long userId) {
     ForumRecord record=  forumRecordRepository.findById(id);
     Long aimUserId=record.getPublishUserId();
     if (aimUserId.equals(userId)){
         forumRecordRepository.deleteById(Long.valueOf(id));
         result.put("code",0);
         return result;
     }else {
         result.put("code",1);
         return result;
     }
    }

    @Override
    public Map<String, Object> upvote(Long id) {
            ForumRecord record= forumRecordRepository.findById(id).get();
            long count= record.getUpvote();
            count++;
            record.setUpvote(count);
            forumRecordRepository.save(record);
            result.put("code",0);
            return result;
    }
}
