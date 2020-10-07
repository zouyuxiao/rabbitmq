package com.example.admin.controller;

import com.example.commom.utils.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-29 11:48
 */

@Controller
public class FileUploadController {

    FileUtil fileUtil = new FileUtil();

    /**
     * 实现文件上传
     * */
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("fileName") MultipartFile file){
        System.out.println("test-->"+fileUtil.folderMethod("D:\\test"));
        return fileUtil.fileUpload(file);
    }

    /**
     * 实现多文件上传
     * **public @ResponseBody String multifileUpload(@RequestParam("fileName")
     List<MultipartFile> files) */
    @RequestMapping(value="multifileUpload",method= RequestMethod.POST)
    @ResponseBody
    public String multifileUpload(HttpServletRequest request){
       return fileUtil.multifileUpload(request);
    }




}