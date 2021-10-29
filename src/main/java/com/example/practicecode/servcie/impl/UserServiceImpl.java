package com.example.practicecode.servcie.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.practicecode.entity.User;
import com.example.practicecode.mapper.UserMapper;
import com.example.practicecode.servcie.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
}
