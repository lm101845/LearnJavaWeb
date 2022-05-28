package dao.impl;

import domain.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

/**
 * @Author liming
 * @Date 2022/5/26 15:43
 **/
public class ProvinceDaoImpl implements ProvinceDao{
    //1.声明一个成员变量 jdbctemplate
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Province> findAll() {
        //1.定义sql
        String sql = "select * from province";
        //2.执行sql
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
