package service;

import domain.Province;

import java.util.List;

/**
 * @Author liming
 * @Date 2022/5/26 15:44
 **/
public interface ProvinceService {
    public List<Province> findAll();

    public String findAllJson();
}
