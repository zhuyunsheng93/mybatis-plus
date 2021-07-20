package com.example.mybatisplus.utils;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.*;
import java.util.List;
import java.util.Map;

/**
 *  *@Description          
 *  *@Author  zhuyunsheng       //作者
 *  *@Date 2021/7/17 13:58      //创建时间
 **/
@Slf4j
@Component
public class CustomizingExportFieldsUtils {
    /**
     *      * 修改fields上@Excel注解的name属性，不需要下载的列，name修改增加_ignore.
     *      * 保存原来的@Excel注解name属性值，本次生成后用来恢复
     *      * @Params
     *      *     headers：用户勾选，由前端传来的列名，列名的key必须和Model字段对应
     *      *     clazz：model实体类
     *      *     excelMap：用来记录原值的map，因为用到了递归，这里返回值作为参数传入
     *      * @return Map<String, String> 原实体类字段名和@Excel注解name属性值的映射关系<字段名，@Excel注解name属性值>
     *
     */
    public static Map<String, String> dynamicChangeAndSaveSourceAnnotation(List<String> headers, Class clazz, Map<String, String> excelMap) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // @Excel注解
            if (field.isAnnotationPresent(Excel.class)) {
                boolean flag = true;
                for (int i = 0; i < headers.size(); i++) {
                    String header = headers.get(i);
                    if (field.getName().equals(header)) {
                        Excel annotation = field.getAnnotation(Excel.class);
                        InvocationHandler handler = Proxy.getInvocationHandler(annotation);
                        changeAnnotationOrderNum(handler,i+"");
                        flag = false;
                        break;
                    }
                }
                // 下载列不包括该字段，进行隐藏，并记录原始值
                if (flag) {
                    Excel annotation = field.getAnnotation(Excel.class);
                    // 保存注解
                    excelMap.put(field.getName(), annotation.name());
                    InvocationHandler handler = Proxy.getInvocationHandler(annotation);
                    String value = annotation.name().toString();
                    changeAnnotationValue(handler, " ","0");
                }
            }
        }
        return excelMap;
    }

    // 改变注解属性值，抽取的公共方法
    private static void changeAnnotationValue(InvocationHandler handler, String propertyValue,String orderNum) {
        try {
            Field field = handler.getClass().getDeclaredField("memberValues");
            field.setAccessible(true);
            Map<String, Object> memberValues = (Map<String, Object>) field.get(handler);
            memberValues.put("name", propertyValue);
            memberValues.put("orderNum",orderNum);
        } catch (Exception e) {
            log.error("替换注解属性值出错！", e);
        }
    }

    //
    private static void changeAnnotationOrderNum(InvocationHandler handler,String orderNum){
        try {
            Field field = handler.getClass().getDeclaredField("memberValues");
            field.setAccessible(true);
            Map<String, Object> memberValues = (Map<String, Object>) field.get(handler);
            memberValues.put("orderNum",orderNum);
        } catch (Exception e) {
            log.error("替换注解属性值出错！", e);
        }
    }


    /**
     *      * 递归恢复@Excel原始的name属性
     *
     */
    public static void dynamicResetAnnotation(Class clazz, Map<String, String> excelMap) {
        if (excelMap.isEmpty()) {
            return;
        }
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                if (field.isAnnotationPresent(Excel.class)) {
                    Excel annotation = field.getAnnotation(Excel.class);
                    InvocationHandler handler = Proxy.getInvocationHandler(annotation);
                    if (excelMap.containsKey(field.getName())) {
                        String sourceName = excelMap.get(field.getName());
                        changeAnnotationValue(handler, sourceName,"0");
                    }else{
                        changeAnnotationOrderNum(handler,"0");
                    }
                }
            }
        } catch (Exception e) {
            log.error("解析动态表头，恢复注解属性值出错！", e);
        }
    }
}
