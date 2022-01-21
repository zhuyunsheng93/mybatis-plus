package com.example.practicecode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Test
    void contextLoads() {
        List<Entity> entities = new ArrayList<>();
        Entity entity = new Entity();
        entity.setMaxValue(10);
        entity.setMinValue(1);
        entities.add(entity);
        Entity entity1 = new Entity();
        entity1.setMaxValue(5);
        entity1.setMinValue(2);
        entities.add(entity1);
        entities.stream().sorted(Comparator.comparing(Entity::getMinValue))
                .reduce((a, b) -> {
                    if (a.getMaxValue() >= b.getMinValue()) {
                        System.out.println("有重复区间");
                    }
                    return b;
                });
    }

}
class Entity{
    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    private int minValue;
    private int maxValue;

}
