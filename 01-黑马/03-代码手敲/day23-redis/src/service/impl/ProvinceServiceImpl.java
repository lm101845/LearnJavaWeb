package service.impl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.impl.ProvinceDao;
import dao.impl.ProvinceDaoImpl;
import domain.Province;
import jedis.util.JedisPoolUtils;
import redis.clients.jedis.Jedis;
import service.ProvinceService;

import java.util.List;

/**
 * @Author liming
 * @Date 2022/5/26 15:47
 **/
public class ProvinceServiceImpl implements ProvinceService {
    //声明dao
    private ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    /**
     * 使用redis缓存
     * @return
     */
    @Override
    public String findAllJson() {
        //先从redis中查询数据
        //1.1 获取redis的客户端连接
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");
        //2.判断province_json是否为null
        if(province_json == null || province_json.length() == 0){
            //redis中没有数据
            System.out.println("redis has not data,use database");
            //2.1从数据库中查询
            List<Province> ps = dao.findAll();
            //2.2将list序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //2.3 将json数据存入redis中
            jedis.set("province",province_json);
            //归还连接
            jedis.close();
        }else{
            System.out.println("redis has data,do not need  database");
        }
        return province_json;
    }
}
