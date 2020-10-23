package com.redis;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Ignore
class RedisApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("测试");
        String str="";
        long starTime=System.currentTimeMillis();
        //计算循环10000的时间
        for(int i=0;i<10000;i++){
            str=str+i;
        }
        long endTime=System.currentTimeMillis();
        long Time=endTime-starTime;
        System.out.println(Time);
        StringBuilder bulider=new StringBuilder("");
        starTime=System.currentTimeMillis();
        for(int j=0;j<10000;j++){
            bulider.append(j);
        }
        endTime=System.currentTimeMillis();
        Time=endTime-starTime;
        System.out.println(Time);
    }



}
