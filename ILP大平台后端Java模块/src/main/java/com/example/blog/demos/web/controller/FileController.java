package com.example.blog.demos.web.controller;
import com.example.blog.demos.web.Dao.FileRecordRepository;
import com.example.blog.demos.web.aspect.PointCut.TokenRequired;
import com.example.blog.demos.web.entity.FileRecord;
import com.example.blog.demos.web.service.serviceimpl.FileImpl;
import com.example.blog.demos.web.untils.UploadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
@RestController
@CrossOrigin(origins = "*")
public class FileController {
    @Autowired
    FileRecord fileRecord;
    @Autowired
    FileRecordRepository fileRecordRepository;
    @Autowired
    FileImpl fileImpl;
    Map<String,Object> result=new HashMap<>();
    @TokenRequired
    @PostMapping("/upload")
    public ResponseEntity<Map<String,Object>> upload(@RequestParam("file") MultipartFile file,@RequestParam("userId") Long userId,@RequestParam("fileName") String fileName,@RequestParam("major") String major){
           return ResponseEntity.ok().body(fileImpl.upload(file,userId,fileName,major));
    }

    @GetMapping("/download")
    public void download(@RequestParam("id") Long id, HttpServletResponse response) {
        try {
            fileRecord= fileRecordRepository.findById(id).get();
            String path=UploadUtils.path+"\\"+fileRecord.getFilePath();
            // path是指想要下载的文件的路径
            File file = new File(path);
            // 获取文件名
            String filename = file.getName();
            // 获取文件后缀名
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
            // 将文件写入输入流
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStream fis = new BufferedInputStream(fileInputStream);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();

            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            //Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
            //attachment表示以附件方式下载   inline表示在线打开   "Content-Disposition: inline; filename=文件名.mp3"
            // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
            // 告知浏览器文件的大小
            response.addHeader("Content-Length", "" + file.length());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
            outputStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @TokenRequired
    @PostMapping("deleteFile")
    public ResponseEntity<Map<String,Object>> deleteFile(@RequestBody Map<String,String> params){
            Long userId= Long.valueOf(params.get("userId"));
            Long id= Long.valueOf(params.get("id"));
            fileRecord= fileRecordRepository.findById(id).get();
            String path=UploadUtils.path+"\\"+fileRecord.getFilePath();
            if(userId==fileRecord.getUserId()) {
                FileSystemUtils.deleteRecursively(new File(path));
                fileRecordRepository.deleteById(id);
                result.put("code",0);
                return ResponseEntity.ok(result);
            }else {
                result.put("code",2);
                return ResponseEntity.ok(result);
            }
    }


    @TokenRequired
    @PostMapping("showFile")
    public ResponseEntity<Map<String,Object>> showFile(@RequestBody Map<String,String> params){
        Long userId= Long.valueOf(params.get("userId"));
        return ResponseEntity.ok().body(fileImpl.showFile(userId));
    }

}

