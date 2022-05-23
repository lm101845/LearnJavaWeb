package fruit.dao;

import fruit.pojo.Fruit;

import java.util.List;

/**
 * @Author liming
 * @Date 2022/5/21 13:05
 **/
public interface FruitDAO {
    //1.查询库存列表
    List<Fruit> getFruitList() throws ClassNotFoundException;
    //2.新增库存
    boolean addFruit(Fruit fruit);
    //修改库存
    boolean updateFruit(Fruit fruit);
    //根据名称查询特定库存
    Fruit getFruitByFname(String fname);
    //删除特定库存记录
    boolean delFruit(String fname);
}
