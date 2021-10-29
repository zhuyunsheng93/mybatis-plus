package com.example.practicecode.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User {
    @Excel(name = "用户id")
    private Long id;
    @Excel(name = "用户姓名")
    private String name;
    @Excel(name = "用户年龄")
    private Integer age;
    @Excel(name = "邮件地址")
    private String userEmail;

}

