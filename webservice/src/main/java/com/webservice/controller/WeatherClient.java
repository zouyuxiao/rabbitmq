package com.webservice.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-22 13:36
 */

public class WeatherClient {
    public static void main(String[] args) throws IOException {
        System.out.print("请输入要查询的城市:");
        Scanner input=new Scanner(System.in);
        String city = input.next();

        Socket socket=new Socket("127.0.0.1",8027);
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
