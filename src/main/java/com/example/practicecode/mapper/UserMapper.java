package com.example.practicecode.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.practicecode.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
