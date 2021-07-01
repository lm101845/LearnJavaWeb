package util;

/**
 * @author ����
 * @date 2021��06��23�� 14:37
 */

import domain.Emp;
import util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * * ����һ����������ѯemp������ݽ����װΪ����Ȼ��װ�ؼ��ϣ����ء�
 */
public class Demo01 {
    public static void main(String[] args) {
        List<Emp> list = null;
        try {
            list = new Demo01().findAll2();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(list);
        System.out.println(list.size());
    }
    /**
     * ��ʾJDBC�Ĺ�����
     * @return java.util.List<domain.Emp>
    */
    public List<Emp> findAll2() throws SQLException {
        //�����ĳ�ȡ
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        List<Emp> list = null;
        try {
//            //1.ע������
//            Class.forName("com.mysql.jdbc.Driver");
//
//            //2.��ȡ����
//            conn = DriverManager.getConnection("jdbc:mysql:///db4", "root", "123456");

//            conn = JDBCUtils.getConnection("jdbc:mysql:///db4", "root", "123456");
            conn = JDBCUtils.getConnection();

            //3.����sql
            String sql = "select * from emp";

            //4.��ȡִ��sql�Ķ���
            stmt = conn.createStatement();
            
            //5.ִ��sql
            rs = stmt.executeQuery(sql);

            //6.�������������װ����װ�ؼ���
            Emp emp = null;
            list = new ArrayList<Emp>();
            while(rs.next()){
                //��ȡ����
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                // ����emp����,����ֵ
                emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                //װ�ؼ���
                list.add(emp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
//            if(rs != null){
//              try{
//                  rs.close();
//              }catch (SQLException e){
//                  e.printStackTrace();
//              }
//            }
//
//            if(stmt != null){
//                try{
//                    stmt.close();
//                }catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }
//
//            if(conn != null){
//                try{
//                    conn.close();
//                }catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }

            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }
}
