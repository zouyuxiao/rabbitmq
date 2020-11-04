package com.example.admin.controller;

import com.example.commom.utils.StringUtils;
import com.example.user.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-10-26 17:13
 */

@CrossOrigin
@RestController
@RequestMapping("/file")
public class UploadFileController {
    @Autowired
    private UploadService uploadService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Object upload(MultipartFile fileUpload) {
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = UUID.randomUUID() + suffixName;
        //指定本地文件夹存储图片
        String filePath = "D:\\log";
        try {
            //将图片保存到static文件夹里
            fileUpload.transferTo(new File(filePath + fileName));
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failure";
        }
    }

    @PostMapping("/image")
    public ResponseEntity<String> uploadImage(@RequestParam("file")MultipartFile file){
        String url = this.uploadService.uploadImage(file);
        if (StringUtils.isBlank(url)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(url);
    }
}
