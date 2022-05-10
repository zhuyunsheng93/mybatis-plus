package com.example.practicecode.mapper;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.practicecode.entity.User;
import com.example.practicecode.servcie.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Resource
    private UserService userService;

    @Test
    public void testSelect() {
        Map<String,Object> map1 = new HashMap<>();
        map1.put("address_name","ab");
        System.out.println(entityValueMap(map1));

}
    public Map<String, Object> entityValueMap(Map<String, Object> entityMap) {
        Pattern linePattern =  Pattern.compile("_(\\w)");
        Map<String, Object> transMap = new HashMap<>();
        Set<String> keyList = entityMap.keySet();
        keyList.forEach(str -> {
            Object value = entityMap.get(str);
            str = str.toLowerCase();
            Matcher matcher = linePattern.matcher(str);
            StringBuffer sb = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
            }
            matcher.appendTail(sb);
            transMap.put(sb.toString(), value);
        });
        return transMap;
    }

}