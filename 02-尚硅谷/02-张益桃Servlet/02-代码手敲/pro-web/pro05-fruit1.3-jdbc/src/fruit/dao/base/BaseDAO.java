package fruit.dao.base;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author liming
 * @Date 2022/5/22 12:50
 **/
public abstract class BaseDAO<T> {
    //�����࣬����ֱ��new����Ҫ���ã��͵ü̳�
    //�������������й��췽�������ǲ�������ֱ��new
    public final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public final String URL = "jdbc:mysql://localhost:3306/fruitdb?useSSL=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
    public final String USER = "root";
    public final String PASSWORD = "123456";

    protected Connection conn = null;
    protected PreparedStatement psmt = null;
    protected ResultSet rs = null;

    //T��Class����
    private Class entityClass;

    public BaseDAO(){
        //getClass��ʾ��ȡClass���󣬵�ǰ����ִ�е���new FruitDAOImpl(),��������FruitDAOImpl��ʵ��
        //��ô���๹�췽���ڲ����Ȼ���ø��ࣨBaseDAO�����޲ι��췽��
        //��˴˴���getClass()�ᱻִ�У�����getClass��ȡ����FruitDAOImpl��Class
        //����getGenericSuperclass()��ȡ������BaseDAO��Class
        Type genericType = getClass().getGenericSuperclass();
        //����������
        Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
        //��������ֻд��һ������T����������ȡ��һ��
        //��ȡ����<T>�е���ʵ������
        Type acctualType = actualTypeArguments[0];
        try {
            entityClass = Class.forName(acctualType.getTypeName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println(acctualType.getTypeName());
    }

    //��ȡ����
    protected Connection getConn() {
        try {
            //1.��������
            Class.forName(DRIVER);
            //2.ͨ��������������ȡ���Ӷ���
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //�ͷ���Դ
    protected void close(ResultSet rs, PreparedStatement psmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (psmt != null) {
                psmt.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //��Ԥ��������������ò���
    private void setParams(PreparedStatement psmt,Object ...params) throws SQLException {
        if(params != null && params.length > 0){
            for (int i = 0; i < params.length; i++) {
                psmt.setObject(i+1,params[i]);
            }
        }
    }

    //ִ�и��£�����Ӱ������
    protected int executeUpdate(String sql, Object... params) {
        boolean isInsertFlag = false;
        isInsertFlag = sql.trim().toUpperCase().startsWith("INSERT");
        try {
            conn = getConn();
            if(isInsertFlag){
                psmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            }else{
                psmt = conn.prepareStatement(sql);
            }
            setParams(psmt,params);
            int count =  psmt.executeUpdate();
            rs = psmt.getGeneratedKeys();
            if(rs.next()){
                return ((Long)rs.getLong(1)).intValue();
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, psmt, conn);
        }
        return 0;
    }

    //ͨ�����似����obj�����property���Ը�propertyValueֵ
    private void setValue(Object obj,String property,Object propertyValue){
        Class<?> clazz = obj.getClass();
        try {
            //��ȡproperty����ַ�����Ӧ�������������� "fid"  ȥ�� obj�����е� fid ����
            Field field = clazz.getDeclaredField(property);
            if(field != null){
                field.setAccessible(true);
                field.set(obj,propertyValue);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //ִ�и��Ӳ�ѯ����������ͳ�ƽ��
    protected Object[] executeComplexQuery(String sql,Object ...params){
        try {
            conn = getConn() ;
            psmt = conn.prepareStatement(sql);
            setParams(psmt,params);
            rs = psmt.executeQuery();

            //ͨ��rs���Ի�ȡ�������Ԫ����
            //Ԫ���ݣ�������������ݵ����� , �򵥽�������������������Щ�У�ʲô���͵ȵ�

            ResultSetMetaData rsmd = rs.getMetaData();
            //��ȡ�����������
            int columnCount = rsmd.getColumnCount();
            Object[] columnValueArr = new Object[columnCount];
            //6.����rs
            if(rs.next()){
                for(int i = 0 ; i<columnCount;i++){
                    Object columnValue = rs.getObject(i+1);     //33    ƻ��      5
                    columnValueArr[i]=columnValue;
                }
                return columnValueArr ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs,psmt,conn);
        }
        return null ;
    }
    //ִ�в�ѯ�����ص���ʵ�����
    protected T load(String sql,Object ...params){
        List<T> list = new ArrayList<>();
        try {
            conn = getConn();
            psmt = conn.prepareStatement(sql);
            setParams(psmt,params);
            rs =  psmt.executeQuery();
            //ͨ��rs���Ի�ȡ�������Ԫ����
            //Ԫ���ݣ�������������ݵ����ݣ��򵥽�������������������Щ�У�ʲô���͵ȵ�
            ResultSetMetaData rsmd = rs.getMetaData();
            //��ȡ�����������
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                T entity = (T)entityClass.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    String columnName = rsmd.getColumnName(i + 1);
                    Object columnValue = rs.getObject(i + 1);
                    setValue(entity,columnName,columnValue);
                }
                return entity;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs,psmt,conn);
        }
        return null;
    }

    //ִ�в�ѯ������List
    protected List<T> executeQuery(String sql,Object ...params){
        List<T> list = new ArrayList<>();
        try {
            conn = getConn();
            psmt = conn.prepareStatement(sql);
            setParams(psmt,params);
            rs =  psmt.executeQuery();
            //ͨ��rs���Ի�ȡ�������Ԫ����
            //Ԫ���ݣ�������������ݵ����ݣ��򵥽�������������������Щ�У�ʲô���͵ȵ�
            ResultSetMetaData rsmd = rs.getMetaData();
            //��ȡ�����������
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                T entity = (T)entityClass.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    String columnName = rsmd.getColumnName(i + 1);
                    Object columnValue = rs.getObject(i + 1);
                    setValue(entity,columnName,columnValue);
                }
                list.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs,psmt,conn);
        }
        return list;
    }
}
