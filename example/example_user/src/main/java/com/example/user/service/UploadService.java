package com.example.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-10-26 17:30
 */

@Service
public class UploadService {

    // 制作文件的白名单,使用Arrays.asList列出一个常量的字符串
    private static final List<String> CONTENT_TYPES = Arrays.asList("image/gif","image/jpeg","image/png");
    // 定义输出错误日志
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadService.class);

    public String uploadImage(MultipartFile file) {

        // 获取文件类型
        String originalFilename = file.getOriginalFilename();

        try {
            // 校验文件类型
            // 列出所有文件合法类型
            String contentType = file.getContentType();
            if (!CONTENT_TYPES.contains(contentType)){
                LOGGER.info("文件类型不合法：{}",originalFilename);
                return null;
            }

            // 校验文件的内容，ImageIO读取文件内容
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            if (bufferedImage == null) {
                LOGGER.info("文件内容不合法：{}",originalFilename);
                return null;
            }

            // 保存到服务器
            file.transferTo(new File("D:\\log" + originalFilename));

            // 返回url，进行回显
            return "http://image.xxx.com/" + originalFilename;

        } catch (IOException e) {
            LOGGER.info("服务器内部错误：" + originalFilename);
            e.printStackTrace();
        }
        return null;
    }
}
