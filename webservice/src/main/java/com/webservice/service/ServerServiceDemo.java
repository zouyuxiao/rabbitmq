package com.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-22 17:32
 */

@WebService(name = "ServerServiceDemo", targetNamespace = "http://service.webservice.com")
public interface ServerServiceDemo {
    @WebMethod
    String emrService(@WebParam String data);

}
