package com.webservice;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class WebserviceApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(123);
    }

    @Test
    public void weatherServer() throws IOException {
        Map<String, String> map=new HashMap<String, String>();
        map.put("北京", "天气晴");
        map.put("成都", "小雨");
        map.put("深圳", "阴天");

        //创建Socket
        ServerSocket serverSocket=new ServerSocket(8888);
        System.out.println("服务器端开始启动...监听端口:8888");
        while(true){
            //接收客户端的请求,accept为阻塞方法
            Socket socket=serverSocket.accept();
            //接收客户端数据
            DataInputStream inputStream=new DataInputStream(socket.getInputStream());
            //响应客户端数据
            DataOutputStream outputStream=new DataOutputStream(socket.getOutputStream());
            String city = inputStream.readUTF();
            System.out.println("正在查询城市数据："+city);
            String result=map.get(city);
            outputStream.writeUTF(result);
        }
    }

    @Test
    public void weatherClient() throws IOException {
        Scanner input=new Scanner(System.in);
        System.out.print("请输入要查询的城市:");
        String city = input.next();

        Socket socket=new Socket("localhost",8888);
        //发送数据到服务器
        DataOutputStream outputStream=new DataOutputStream(socket.getOutputStream());
        //接收服务器发送的数据
        DataInputStream inputStream=new DataInputStream(socket.getInputStream());
        outputStream.writeUTF(city);
        //readUTF也是一个阻塞的方法，输出查询结果
        String result = inputStream.readUTF();
        System.out.println("查询结果:"+result);
    }

}
