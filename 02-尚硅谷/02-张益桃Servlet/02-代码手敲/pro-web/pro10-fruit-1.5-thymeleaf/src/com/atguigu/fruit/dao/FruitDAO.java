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

    //根据fid获取特定的水果库存信息
    Fruit getFruitByFid(Integer fid);

    //修改指定的库存记录
    void updateFruit(Fruit fruit);

    //根据fid删除指定的库存记录
    void delFruit(Integer fid);

    //添加新库存记录
    void addFruit(Fruit fruit);
}
