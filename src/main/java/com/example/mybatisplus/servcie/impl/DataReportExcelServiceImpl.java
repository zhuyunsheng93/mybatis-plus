package com.example.mybatisplus.servcie.impl;

import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.model.WellCondition;
import com.example.mybatisplus.servcie.DataReportExcelService;
import com.example.mybatisplus.servcie.UserService;
import com.example.mybatisplus.utils.CustomizingExportFieldsUtils;
import com.example.mybatisplus.utils.EasyPoiExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2021/7/17 14:06      //创建时间
 **/
@Service
public class DataReportExcelServiceImpl implements DataReportExcelService {
    @Autowired
    UserService userService;
    @Override
    public void excel(HttpServletResponse response, WellCondition wellCondition) throws Exception {
        Map<String, String> excelMap=new HashMap<>();
        Map<String, String> stringStringMap =null;
        List<User> userList = this.userService.list();
        //修改注解 @Excel中的name值，
        stringStringMap= CustomizingExportFieldsUtils.dynamicChangeAndSaveSourceAnnotation(wellCondition.getExport(), User.class, excelMap);
        //导出excel
        EasyPoiExcelUtil.exportExcel(userList, "测试自定义下载字段", "用户", User.class, "用户列表"+".xlsx", response);
        //导出完成恢复注解的原始值
        CustomizingExportFieldsUtils.dynamicResetAnnotation( User.class,stringStringMap);
    }
}
