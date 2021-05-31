package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("id",2);
        hashMap.put("id",1);
        List<User> userList = userMapper.selectList(new QueryWrapper<User>().allEq(hashMap));
        userList.forEach(System.out::println);
    }
}