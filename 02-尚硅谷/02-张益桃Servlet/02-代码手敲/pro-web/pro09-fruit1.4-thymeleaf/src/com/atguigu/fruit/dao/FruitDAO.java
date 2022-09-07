package com.atguigu.fruit.dao;

import com.atguigu.fruit.pojo.Fruit;

import java.util.List;

/**
 * @Author liming
 * @Date 2022/9/7 11:11
 **/
public interface FruitDAO {
    //获取所有的库存列表信息
    List<Fruit> getFruitList();
}
