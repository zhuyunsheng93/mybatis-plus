package com.example.practicecode.spi;

import java.util.List;

public class FileSearch implements Search {
    @Override
    public List<String> search(String keyValue) {
        System.out.println("文件搜索" + keyValue);
        return null;
    }
}
