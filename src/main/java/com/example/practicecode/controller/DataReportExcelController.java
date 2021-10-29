package com.example.practicecode.controller;

import com.example.practicecode.model.WellCondition;
import com.example.practicecode.servcie.DataReportExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2021/7/17 14:05      //创建时间
 **/
@RestController
@RequestMapping("/report")
public class DataReportExcelController {
    @Autowired
    private DataReportExcelService dataReportExcelService;

    /**
     * 根据传入的表头信息灵活导出
     *
     * @param response
     */
    @RequestMapping("/excel")
    public void excel(HttpServletResponse response ,@RequestParam("exportField") List<String> exportField) throws Exception {
        WellCondition condition = new WellCondition();
        condition.setExport(exportField);
        dataReportExcelService.excel(response,condition);
    }

}
