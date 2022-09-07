package com.atguigu.fruit.dao.impl;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @Author liming
 * @Date 2022/9/7 11:16
 **/
//TODO:一定要记得这里写泛型啊！BaseDAO<Fruit>这样写，只写BaseDAO会报错。。。。。。
public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
    @Override
    public List<Fruit> getFruitList() {
        return super.executeQuery("select * from t_fruit");
    }
}
