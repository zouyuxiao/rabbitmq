package com.swagger.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-10-08 10:46
 */

@ApiModel(description= "返回响应数据")
public class RestMessage implements Serializable {
    @ApiModelProperty(value = "是否成功")
    private boolean success=true;
    @ApiModelProperty(value = "返回对象")
    private Object data;
    @ApiModelProperty(value = "错误编号")
    private Integer errCode;
    @ApiModelProperty(value = "错误信息")
    private String message;
    /* getter/setter 略 */
}
