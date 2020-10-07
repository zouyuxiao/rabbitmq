package com.example;

import com.example.user.bean.User;
import com.example.user.service.UserService;
import com.example.user.service.UserTestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@SpringBootTest
class ExampleAdminApplicationTests {

    @Autowired
    private UserTestService userTestService;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    public void test(){
        Long a = userTestService.test();
        System.out.println("a------>"+a);
        getFileName();
    }


    public static void getFileName() {
        String path = "D:/test"; // Â·¾¶
        File f = new File(path);
        if (!f.exists()) {
            System.out.println(path + " not exists");
            return;
        }

        File fa[] = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (fs.isDirectory()) {
                System.out.println(fs.getName() + " [Ä¿Â¼]");
            } else {
                System.out.println(fs.getName());
            }
        }
    }

    /**
     * Ð±¸Ü×ª»»
     */
    @Test
    public void demo() {
        String path = "D:/test";
        path = path.replaceAll("/", "\\\\");
        System.out.println(path);
    }

}
