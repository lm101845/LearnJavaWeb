package jedis.test;

/**
 * @Author liming
 * @Date 2022/5/25 22:39
 **/

import jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * jedis的测试类
 */
public class JedisTest {
    /**
     * 快速入门
     */
    @Test
    public void test1(){
        //1.获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2.操作
        jedis.set("username","zhangsan");
        //3.关闭连接
        jedis.close();
    }

    /**
     * 字符串数据结构操作
     */
    @Test
    public void test2(){
        //1.获取连接
//        Jedis jedis = new Jedis("localhost", 6379);
        Jedis jedis = new Jedis();  //如果使用空参构造，默认值为localhost和6379
        //2.操作
        //存储
        jedis.set("username","zhangsan");
        //获取
        String username = jedis.get("username");
        System.out.println(username);
        //可以使用setex()方法存储可以指定过期时间的key,value
        jedis.setex("activecode",20,"hehe");  //将activecode,hehe键值对存入redis,并且20秒后自动删除该键值对
        //可以存入有时效的激活码，验证码等
        //3.关闭连接
        jedis.close();
    }

    /**
     * hash数据结构操作
     */
    @Test
    public void test3(){
        //1.获取连接
//        Jedis jedis = new Jedis("localhost", 6379);
        Jedis jedis = new Jedis();  //如果使用空参构造，默认值为localhost和6379
        //2.操作
        //存储hash
        jedis.hset("user","name","lisi");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","male");
        //获取hash
        String name = jedis.hget("user", "name");
        System.out.println(name);

        //获取hash的所有map中的数据
        Map<String, String> user = jedis.hgetAll("user");
        //keyset
        Set<String> keySet = user.keySet();
        for(String key:keySet){
            //获取key
            String value = user.get(key);
            System.out.println(key + ":" + value);
        }
        //3.关闭连接
        jedis.close();
    }

    /**
     * list数据结构操作
     */
    @Test
    public void test4(){
        //1.获取连接
//        Jedis jedis = new Jedis("localhost", 6379);
        Jedis jedis = new Jedis();  //如果使用空参构造，默认值为localhost和6379
        //2.操作
        //存储list
        jedis.lpush("mylist","a","b","c");  //从左边存
        jedis.rpush("mylist","a","b","c");  //从右边存
        //获取list
        List<String> mylist = jedis.lrange("mylist", 0, -1);  //-1表明获取所有
        System.out.println(mylist);

        //list弹出
        String element1 = jedis.lpop("mulist");
        System.out.println(element1);

        String element2 = jedis.rpop("mylist");
        System.out.println(element2);

        List<String> mylist2 = jedis.lrange("mylist",0,-1);
        System.out.println(mylist2);
        //3.关闭连接
        jedis.close();
    }


    /**
     * set数据结构操作
     */
    @Test
    public void test5(){
        //1.获取连接
        Jedis jedis = new Jedis();  //如果使用空参构造，默认值为localhost和6379
        //2.操作
        //存储set
        jedis.sadd("myset","c","java","js");  //从左边存
        //获取set
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);
        //3.关闭连接
        jedis.close();
    }

    /**
     * sortedset数据结构操作
     */
    @Test
    public void test6(){
        //1.获取连接
        Jedis jedis = new Jedis();  //如果使用空参构造，默认值为localhost和6379
        //2.操作
        //存储sortedset
        jedis.zadd("mysortedset",3,"亚瑟");
        jedis.zadd("mysortedset",30,"孙悟空");
        jedis.zadd("mysortedset",20,"吕布");
        jedis.zadd("mysortedset",100,"鲁班七号");
        //获取sortedset
        Set<String> mysortedset = jedis.zrange("mysortedset",0,-1);
        System.out.println(mysortedset);
        //3.关闭连接
        jedis.close();
    }


    /**
     * jedis连接池的使用
     */
    @Test
    public void test7(){
        //0.创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        //1.创建jedis连接池对象
        //JedisPool jedisPool = new JedisPool();
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);
        //2.获取连接
        Jedis jedis = jedisPool.getResource();
        //3.使用
        jedis.set("hehe","haha");
        //4.关闭——不是真正的关闭，而是归还到连接池中
        jedis.close();
    }

    /**
     * jedis连接池工具类的使用
     */
    @Test
    public void test8(){
        //通过连接池工具类获取
        //1.获取
        Jedis jedis = JedisPoolUtils.getJedis();
        //2.使用
        jedis.set("huohuo","lala");
        //3.关闭
        jedis.close();
    }
}
