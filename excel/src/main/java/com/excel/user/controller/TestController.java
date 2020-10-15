package com.excel.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.excel.common.BaseApiController;
import com.excel.common.CommonController;
import com.excel.core.domain.AjaxResult;
import com.excel.exception.BusinessException;
import com.excel.user.bean.User;
import com.excel.user.service.UserService;
import com.excel.util.StringUtils;
import com.excel.util.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-25 16:28
 */
@RestController
@RequestMapping("/user")
public class TestController extends BaseApiController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String test(){
        System.out.println("<=====================>");
        return "user/user";
    }

    // 导出数据
    @GetMapping(value = "/export",headers = "Accept=application/json")
    public Map<String, Object> export(HttpServletResponse response, HttpServletRequest request)
    {
        response.addHeader("Content-Type", "application/json;charset=UTF-8");
        List<User> users = userService.list();
        System.out.println("users-->"+users);
        List<User> list = new ArrayList<User>(users);
        ExcelUtil<User> util = new ExcelUtil<User>(User.class);
        AjaxResult jsonStr =  util.exportExcel(list, "用户数据");
        JSONObject jsonObj = new JSONObject(jsonStr);
        String fileName = jsonObj.getString("msg");
        System.out.println(fileName);
        CommonController commonController = new CommonController();
        commonController.fileDownload(String.valueOf(fileName), true, response, request );
        return onSuccessRep("成功");
    }

    /**
     * 下载模板
     * @return
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public Map<String, Object> importTemplate(HttpServletResponse response, HttpServletRequest request)
    {
        ExcelUtil<User> util = new ExcelUtil<User>(User.class);
        AjaxResult jsonStr =  util.importTemplateExcel("用户数据");
        JSONObject jsonObj = new JSONObject(jsonStr);
        String fileName = jsonObj.getString("msg");
        System.out.println(fileName);
        CommonController commonController = new CommonController();
        commonController.fileDownload(String.valueOf(fileName), true, response, request );
        return onSuccessRep("成功");
    }

    /**
     * 导入数据
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<User> util = new ExcelUtil<User>(User.class);
        List<User> userList = util.importExcel(file.getInputStream());

        /*
        *  bug
        * userList 无法获取regTime
        * */

        String message = importUser(userList, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 导入用户数据
     *
     * @param userList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    public String importUser(List<User> userList, Boolean isUpdateSupport)
    {
        System.out.println("userList----->"+userList);
        final Map<Integer, User> users = new LinkedHashMap<Integer, User>();

        if (StringUtils.isNull(userList) || userList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (User user : userList)
        {
            try
            {
                // 验证是否存在这个用户
                boolean userFlag = false;
                for (Map.Entry<Integer, User> entry : users.entrySet())
                {
                    if (entry.getValue().getUsername().equals(user.getUsername()))
                    {
                        userFlag = true;
                        break;
                    }
                }
                if (!userFlag)
                {
                    Integer userId = users.size() + 1;
                    user.setId(Long.valueOf(userId));
                    users.put(userId, user);
                    System.out.println("user--->"+user);
                    userService.insert(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、用户 " + user.getUsername() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    users.put(Math.toIntExact(user.getId()), user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、用户 " + user.getUsername() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、用户 " + user.getUsername() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + user.getUsername() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }


    /**
     * 根据id批量删除
     * @param ids
     */
    @RequestMapping("/batchDelete")
    public Map<String,Object> batchDelete(String ids) {
        String[] gpIds = ids.split(",");
        List<Long> list = new ArrayList<>();
        for(String str:gpIds){
            list.add(Long.parseLong(str));
        }
        userService.deleteAll(list);
        return onSuccessRep("ojbk");
    }


    /**
     * 根据id批量查询
     * @param ids
     */
    @RequestMapping("/batchList")
    public Map<String,Object> batchList(String ids) {
        /*String[] gpIds = ids.split(",");
        List<Long> list = new ArrayList<>();
        for(String str:gpIds){
            list.add(Long.parseLong(str));
        }*/
//        List<User> users = userService.findAllById(list);
        List<Long> list = batchListUtil(ids);
        return onDataResp(userService.findAllById(list));
    }

    public List<Long> batchListUtil(String ids){
        String[] gpIds = ids.split(",");
        List<Long> list = new ArrayList<>();
        for(String str:gpIds){
            list.add(Long.parseLong(str));
        }
        return list;
    }

    // 根据id导出指定数据
    @PostMapping("/exportBatchList")
    public Map<String, Object> exportBatchList(HttpServletResponse response, HttpServletRequest request,String ids)
    {
        List<Long> listIds = batchListUtil(ids);
        List<User> users = userService.findAllById(listIds);
        System.out.println("users-->"+users);
        List<User> list = new ArrayList<User>(users);
        ExcelUtil<User> util = new ExcelUtil<User>(User.class);
        AjaxResult jsonStr =  util.exportExcel(list, "用户数据");
        JSONObject jsonObj = new JSONObject(jsonStr);
        String fileName = jsonObj.getString("msg");
        System.out.println(fileName);
        CommonController commonController = new CommonController();
        commonController.fileDownload(String.valueOf(fileName), true, response, request );
        return onSuccessRep("成功");
    }

}
