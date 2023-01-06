package com.example.practicecode.spi;

import java.util.List;

public class DataSearch implements Search {
    @Override
    public List<String> search(String keyValue) {
        System.out.println("数据搜索" + keyValue);
        return null;
    }
}
