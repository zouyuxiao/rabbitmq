package com.demo.excel.bean;

import java.io.Serializable;
import java.util.List;
/**
 * @Description Excel实体类
 * @Author zouyuxiao
 * @Date 2020-10-07 15:59
 */

public class ExcelData implements Serializable {
    private static final long serialVersionUID = 4444017239100620999L;

    // 表头
    private List<String> titles;

    // 数据
    private List<List<Object>> rows;

    // 页签名称
    private String name;

    public List<String> getTitles() {
        return titles;
    }
    public void setTitles(List<String> titles) {
        this.titles = titles;
    }
    public List<List<Object>> getRows() {
        return rows;
    }
    public void setRows(List<List<Object>> rows) {
        this.rows = rows;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
