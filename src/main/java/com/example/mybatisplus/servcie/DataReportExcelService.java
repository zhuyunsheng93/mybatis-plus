package com.example.mybatisplus.servcie;

import com.example.mybatisplus.model.WellCondition;

import javax.servlet.http.HttpServletResponse;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2021/7/17 14:06      //创建时间
 **/
public interface DataReportExcelService {
    void excel(HttpServletResponse response, WellCondition wellCondition) throws Exception;
}
