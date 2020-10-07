package com.example.admin.controller;

import com.example.commom.bean.Folder;
import com.example.commom.controller.BaseApiController;
import com.example.commom.utils.FileUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-30 08:51
 */

@RestController
@RequestMapping("/download")
public class DownloadController extends BaseApiController {
    FileUtil fileUtil = new FileUtil();

    @GetMapping("/lookup")
    public Map<String, Object> test(){
        Folder folder = new Folder();
        String path = "D:/test";
        List folderPath = fileUtil.folderMethod(path);
        List folderName = fileUtil.getFileName(path);
        folder.setPath(folderPath);
        folder.setName(folderName);
        System.out.println("folderPath--"+folderPath);
        System.out.println("folderName--"+folderName);
        System.out.println("folder--"+folder);
        return onDataResp(folder);
    }

    @GetMapping("/download")
    private String downloadFile(HttpServletResponse response,String filePath,
                                String fileName){
        /*filePath = "D:\\test\\ERP系统.docx";//被下载的文件在服务器中的路径,
        fileName = "ERP系统.docx";//被下载文件的名称*/

        // File file = new File(downloadFilePath);
        System.out.println(fileName+"---"+filePath);
        File file = new File(filePath);
        if (file.exists()) {
            response.setContentType("text/html;charset=UTF-8");
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                return "下载失败";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "下载成功";
    }
}
