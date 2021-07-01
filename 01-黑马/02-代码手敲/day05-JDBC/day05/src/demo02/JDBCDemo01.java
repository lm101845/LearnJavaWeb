package demo02;

/**
 * @author ����
 * @date 2021��06��23�� 18:51
 */


import util.JDBCUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * ��ϰ��
 * 		* ����
 * 			1. ͨ������¼���û���������
 * 			2. �ж��û��Ƿ��¼�ɹ�
 */

public class JDBCDemo01 {
    public static void main(String[]args){
        //1.����¼�룬�����û���������
        Scanner sc = new Scanner(System.in);

        System.out.println("�������û�����");
        String username = sc.nextLine();

        System.out.println("���������룺");
        String password = sc.nextLine();
        //2.���÷��������ز���
        boolean flag = new JDBCDemo01().login(username,password);
        //3.�жϽ���������ͬ���
        if(flag){
            //��½�ɹ�
            System.out.println("��½�ɹ�");
        }else{
            System.out.println("�û������������");
        }
    }

    /**
     * ��¼����
     */
    public boolean login(String username,String password){
        if(username == null || password == null){
            return false;
        }
        //�������ݿ��ж��Ƿ��½�ɹ�

        //1.��ȡ����
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtils.getConnection();
            //2.����sql
            String sql = "select * from user where username = '"+username + "' and password = '"+password + "'";
            System.out.println(sql);

            //3.��ȡִ��sql�Ķ���
            stmt = conn.createStatement();

            //4.ִ�в�ѯ
            rs = stmt.executeQuery(sql);

            //5.�ж�
            //�������һ�У��򷵻�true
//            if(rs.next()){
//                return true;
//            }else{
//                return false;
//            }
            return rs.next();
            //��������д�������
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return false;
    }
}
