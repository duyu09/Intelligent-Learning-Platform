package com.example.blog.demos.web.service.serviceimpl;

import com.example.blog.demos.web.Dao.FileRecordRepository;
import com.example.blog.demos.web.entity.FileRecord;
import com.example.blog.demos.web.entity.ForumRecord;
import com.example.blog.demos.web.service.File;
import com.example.blog.demos.web.untils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class FileImpl implements File {
    @Autowired
    FileRecordRepository fileRecordRepository;
    @Autowired
    FileRecord fileRecordNew;
    Map<String,Object> result=new HashMap<>();
    @Override
    public Map<String, Object> upload(MultipartFile file,Long userId,String fileName,String major) {
        String path=UploadUtils.upload(file);
        fileRecordNew.setFilePath(path);
        fileRecordNew.setUserId(userId);
        fileRecordNew.setFileName(fileName);
        fileRecordNew.setMajor(major);
        fileRecordRepository.save(fileRecordNew);
        result.put("id",fileRecordRepository.findByFilePath(path).getId());
        result.put("code",0);
        return result;
    }

    public Map<String, Object> showFile(Long userId)
    {
        List<FileRecord> records=fileRecordRepository.findAll();
        Map<String, Object> data = new HashMap<>();
        int count=1;
        for (FileRecord record:records) {
            Map<String, Object> recordMap = new HashMap<>();
            recordMap.put("id", record.getId());
            recordMap.put("userId",record.getUserId());
            recordMap.put("fileName",record.getFileName());
            recordMap.put("major",record.getMajor());
            data.put("item"+count, recordMap);
            count++;
        }
        result.put("code", 0);
        result.put("data", data);
        return result;
    }
}
