package com.webservice.service.impl;

import com.webservice.service.DemoService;

import javax.jws.WebService;
import java.util.Date;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-22 15:03
 */

/*@WebService(serviceName = "DemoService", // 与接口中指定的name一致
        targetNamespace = "http://service.webservice.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.webservice.service"// 接口地址
)*/
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String user) {
        return user+"，现在时间："+"("+new Date()+")";
    }


}
