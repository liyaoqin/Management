package com.science.admin.controller;

import com.science.admin.model.MgUser;
import com.science.admin.model.UserDto;
import com.science.admin.util.ExcelUtil;
import com.science.admin.util.ExcelUtil2;
import com.science.common.util.JsonUtils;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PoiController {
    @RequestMapping(value = "/doExport")
    public void exportExcelData(HttpServletRequest request, HttpServletResponse response) {

        ExcelUtil<UserDto> excelUtil = new ExcelUtil<>(UserDto.class);
        List<UserDto> userDtos = new ArrayList<>();
        UserDto userDto1 = new UserDto();
        userDto1.setId("aa");
        userDto1.setPassword("wang");
        userDto1.setUsername("xia");
        userDtos.add(userDto1);
        UserDto userDto2 = new UserDto();
        userDto2.setId("bb");
        userDto2.setPassword("111");
        userDto2.setUsername("222");
        userDtos.add(userDto2);
        excelUtil.exportExcelToWeb(userDtos, "用户信息表", response);
    }
    @RequestMapping(value = "/doExport2")
    public void exportExcelData(HttpServletRequest request, HttpServletResponse response, @RequestParam String userList){
        List<MgUser> mgUsers = JsonUtils.jsonToList(userList,MgUser.class);

        // ReturnResult returnResult = new ReturnResult();
        // 定义表的标题
        String title = "用户列表";
        //定义表的列名
        String[] rowsName = new String[] { "序号", "用户名", "密码", "性别", "昵称", "出生年月" };
        //定义表的内容
        ExcelUtil2 excelUtil = new ExcelUtil2();

       List<Object[]> dataList = new ArrayList<Object[]>();

        for (int i=0;i<mgUsers.size();i++){
            Object[] objects = new Object[rowsName.length];
            objects[0] = mgUsers.get(i).getId();
            objects[1] = mgUsers.get(i).getName();
            objects[2] = mgUsers.get(i).getPassword();
            objects[3] = mgUsers.get(i).getGender();
            objects[4] = mgUsers.get(i).getNichen();
            objects[5] = mgUsers.get(i).getBirthday();
            dataList.add(objects);
        }
        try {
            String fileName= new String("用户数据表.xls".getBytes("UTF-8"),"iso-8859-1");    //生成word文件的文件名
            excelUtil.exportExcel(title,rowsName,dataList,fileName,response);
            //returnInfo.setResult(true);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
