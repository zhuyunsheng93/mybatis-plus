package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.servcie.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Resource
    private UserService userService;

    @Test
    public void testSelect() {
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("id",2);
        hashMap.put("id",1);
        List<User> userList = userMapper.selectList(new QueryWrapper<User>().allEq(hashMap));
        System.out.println("test1");
        userList.forEach(System.out::println);
        List<Map<String,Object>> selectMaps = userMapper.selectMaps(new QueryWrapper<User>().allEq(hashMap));

        System.out.println("test");
        System.out.println(selectMaps);

        System.out.println(userMapper.selectByMap(hashMap));
        System.out.println("test1");
        System.out.println(userService.lambdaQuery().select(User::getAge,User::getEmail).eq(User::getAge,18).list()); ;
    }
}