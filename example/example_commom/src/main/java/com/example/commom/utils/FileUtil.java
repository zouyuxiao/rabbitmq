package com.example.commom.utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 文件上传，下载
 * @Author zouyuxiao
 * @Date 2020-09-29 14:00
 */

public class FileUtil {
    String path = "D:/test";

    /**
     * @Description 单个上传
     * @param file 上传文件
     * @return java.lang.String
     * @author zouyuxiao
     * @date 2020-09-29 14:17
     */
    public String fileUpload(MultipartFile file) {
        if(file.isEmpty()){
            return "false";
        }
        String fileName = file.getOriginalFilename(); // 文件名
        int size = (int) file.getSize(); // 文件大小
        File dest = new File(path + "/" + fileName); // 保存路径
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            System.out.println("保存路径-->"+dest);
            return "true";
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "false";
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
    }

    /**
     * @Description 多文件上传
     * @param request 文件
     * @return java.lang.String
     * @author zouyuxiao
     * @date 2020-09-29 14:26
     */
    public String multifileUpload(HttpServletRequest request){
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("fileName");

        if(files.isEmpty()){
            return "false";
        }

        String path = "D:/test" ;

        for(MultipartFile file:files){
            String fileName = file.getOriginalFilename();
            int size = (int) file.getSize();
            // System.out.println(fileName + "-->" + size);

            if(file.isEmpty()){
                return "false";
            }else{
                File dest = new File(path + "/" + fileName);
                if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
                    dest.getParentFile().mkdir();
                }
                try {
                    file.transferTo(dest);
                    System.out.println("保存路径-->"+dest);
                }catch (Exception e) {
                    e.printStackTrace();
                    return "false";
                }
            }
        }
        return "true";
    }

    /**
     * 遍历文件路径
     * @param path 文件路径
     * @return
     */
    public List folderMethod(String path) {
        File file = new File(path);
        List folderPath = new ArrayList();
        File[] files = new File[0];
        if (file.exists()) {
            files= file.listFiles();
            // System.out.println("flies--->"+files.length);
            if (null != files) {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        // System.out.println("文件夹:" + file2.getAbsolutePath());
                        folderMethod(file2.getAbsolutePath());
                    } else {
                        // System.out.println("文件:" + file2.getAbsolutePath());
                        folderPath.add(file2.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
            folderPath.add("文件不存在");
            return folderPath;
        }
        return folderPath;
    }

    /**
     * @Description 获取目录下文件名
     * @param path 路径
     * @return java.util.List 文件名集合
     * @author zouyuxiao
     * @date 2020-09-30 11:42
     */
    public List getFileName(String path) {
        File f = new File(path);
        List fileName = new ArrayList();
        if (!f.exists()) {
            System.out.println(path + " not exists");
            fileName.add("没有文件");
            return fileName;
        }

        File fa[] = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (fs.isDirectory()) {
                System.out.println(fs.getName() + " [目录]");
            } else {
                fileName.add(fs.getName());
                // System.out.println(fs.getName());
            }
        }
        return fileName;
    }


}
