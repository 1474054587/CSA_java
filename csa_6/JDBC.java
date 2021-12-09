package csa_6;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

//JDBC工具类
public class JDBC {
    //静态代码块读取配置文件
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    static {
        try {
            Properties pro = new Properties();
            ClassLoader classLoader = JDBC.class.getClassLoader();
            String path = classLoader.getResource("csa_6/jdbc.properties").getPath();
            pro.load(new FileReader(path));
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    //释放资源
    public static void close(Statement stmt,Connection conn){
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(ResultSet rs,Statement stmt, Connection conn){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //mysql 增删改方法 (insert delete update)
    public boolean set(String sql){
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            int rs = stmt.executeUpdate(sql);
            System.out.println(rs);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(stmt,conn);
        }
        return false;
    }

    //mysql 查询方法 (select)
    public boolean get(String sql){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Student stu = new Student();
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                stu.setSNO(rs.getString("SNO"));
                stu.setName(rs.getString("Name"));
                stu.setAge(rs.getInt("age"));
                stu.setCollege(rs.getString("College"));
                System.out.println(stu.toString());
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs,stmt,conn);
        }
        return false;
    }
    public boolean getAll() {
        return get("select * from student;");
    }
}
