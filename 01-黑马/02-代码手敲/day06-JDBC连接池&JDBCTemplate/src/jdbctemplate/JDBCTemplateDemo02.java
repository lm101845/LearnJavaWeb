package jdbctemplate;

import domain.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utils.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ����
 * @date 2021��07��02�� 0:05
 */
public class JDBCTemplateDemo02 {
    //Junit��Ԫ���ԣ������÷�������ִ�� ������������������

    //1. ��ȡJDBCTemplate���󡪡�������ŵ���Ա���������������һЩ
    //����ÿ�������Ͳ��õ�����ȡtemplate��
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 1. �޸�1�����ݵ� salary Ϊ 10000
     */
    @Test
    public void test1(){
        //System.out.println("�ұ�ִ����");
        //int i = 3 / 0;

        //1. ��ȡJDBCTemplate����
        //JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //2. ����sql
        String sql = "update emp set salary = 10000 where id = 1001";
        //3. ִ��sql
        int count = template.update(sql);
        System.out.println(count);
    }

    /**
     * 2. ���һ����¼
     */
    @Test
    public void test2(){
        //String sql = "insert into emp(id,ename,dept_id) values (1015,'����',10)";
        //˫����ֻ��Ƕ�׵����ţ���������Ĺ��������ǵ�����
        String sql = "insert into emp(id,ename,dept_id) values(?,?,?)";
        int count = template.update(sql,1015,"guojing",10);
        System.out.println(count);
    }

    /**
     * 3.ɾ���ղ���ӵļ�¼
     */
    @Test
    public void test3(){
        String sql = "delete from emp where id = ?";
        int count = template.update(sql, 1015);
        System.out.println(count);
    }

    /**
     * 4.��ѯidΪ1001�ļ�¼�������װΪMap����
     * ע�⣺���������ѯ�Ľ��������ֻ����1
     */
    @Test
    public void test4(){
        String sql = "select * from emp where id = ? or id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1001,1002);
        System.out.println(map);
        //{id=1001, ename=�����, job_id=4, mgr=1004, joindate=2000-12-17, salary=10000.00, bonus=null, dept_id=20}

    }

    /**
     * 5. ��ѯ���м�¼�������װΪList
     */
    @Test
    public void test5(){
        String sql = "select * from emp";
        List<Map<String, Object>> list = template.queryForList(sql);

        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }

    /**
     * 6. ��ѯ���м�¼�������װΪEmp�����List����
     */

    @Test
    public void test6(){
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {

            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException, SQLException {
                Emp emp = new Emp();
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                return emp;
            }
        });


        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 6. ��ѯ���м�¼�������װΪEmp�����List����
     */

    @Test
    public void test6_2(){
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 7. ��ѯ�ܼ�¼��
     */

    @Test
    public void test7(){
        String sql = "select count(id) from emp";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}
