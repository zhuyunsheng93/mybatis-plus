package com.example.mybatisplus.mapper;


import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.servcie.UserService;
import com.example.mybatisplus.thread.MyThread;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
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
        User user1 = new User(2L,"",1,"aa");
        User user2 = new User(2L,"",1,"aa");
        User user4 = new User(3L,"",2,"bb");
        User user3 = new User(3L, "", 2, "bb");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        Map<Long,Map<Integer, Set<String>>> map = userList.stream().collect(Collectors.groupingBy(User::getId, Collectors.groupingBy(User::getAge,Collectors.mapping(User::getUserEmail, Collectors.toSet()))));
        System.out.println(map);
        Map<Long,List<Integer>> result = userList.stream().filter(e->e.getAge()!=null).collect(Collectors.groupingBy(User::getId, Collectors.mapping(User::getAge, Collectors.toList())));
        System.out.println(result);
        System.out.println("hhahaha "+LocalDateTime.now().plusDays(1).plusSeconds(60));
        Map<String,Object> temp = new HashMap<>();
        temp.forEach((k,v)->{
            System.out.println("test");
        });
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        System.out.println("用户表：" + userMapper.selectList(Wrappers.<User>lambdaQuery()
                .select(User::getId, User::getAge, User::getName, User::getId)
                .and(wrapper -> wrapper.in(CollectionUtil.isNotEmpty(ids), User::getId, ids).or().eq(User::getId, null))
                .eq(User::getAge,12)
                .in(StringUtils.isNotBlank("test"),User::getUserEmail, "")));
    }


}