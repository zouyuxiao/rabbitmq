package com.webservice.service;

import javax.jws.WebService;

/**
 * @Description 访问路径 http://localhost:8028/demo/api?wsdl
 * @Author zouyuxiao
 * @Date 2020-09-22 15:02
 */

/*
*
* @WebService

   1、serviceName： 对外发布的服务名，指定 Web Service 的服务名称：wsdl:service。缺省值为 Java 类的简单名称 + Service。（字符串）

   2、endpointInterface： 服务接口全路径, 指定做SEI（Service EndPoint Interface）服务端点接口

   3、name：此属性的值包含XML Web Service的名称。在默认情况下，该值是实现XML Web Service的类的名称，wsdl:portType 的名称。缺省值为 Java 类或接口的非限定名称。（字符串

   4、portName：  wsdl:portName。缺省值为 WebService.name+Port。

   5、targetNamespace：指定你想要的名称空间，认是使用接口实现类的包名的反缀

   6、wsdlLocation：指定用于定义 Web Service 的 WSDL 文档的 Web 地址。Web 地址可以是相对路径或绝对路径。（字符串）

   注意：实现类上可以不添加Webservice注解
* */

@WebService(name = "DemoService", // 暴露服务名称
        targetNamespace = "http://service.webservice.com"// 命名空间,一般是接口的包名倒序
)
public interface DemoService {

    public String sayHello(String user);
}


