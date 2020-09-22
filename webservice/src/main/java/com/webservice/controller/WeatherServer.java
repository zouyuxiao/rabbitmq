package com.webservice.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-22 14:06
 */

public class WeatherServer {
    public static void main(String[] args) throws IOException {
        Map<String, String> map=new HashMap<String, String>();
        map.put("北京", "天气晴");
        map.put("成都", "小雨");
        map.put("深圳", "阴天");

        //创建Socket
        ServerSocket serverSocket=new ServerSocket(8027);
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
}
