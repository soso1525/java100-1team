package java100.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataSource {
    
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    
    private ArrayList<Connection> list = new ArrayList<>();
    
    synchronized public Connection getConnection() 
            throws SQLException, ClassNotFoundException {
        
        if (list.size() > 0) {
            return list.remove(0);
        }
        
        Class.forName(this.driverClassName);
        // => com.mysql.jdbc.Driver �겢�옒�뒪瑜� 濡쒕뵫�븳�떎.
        //    �떒 �븳 踰� 濡쒕뵫�맂 �겢�옒�뒪�뒗 �떎�떆 濡쒕뵫�븯吏� �븡�뒗�떎.
        // => Driver �겢�옒�뒪 �궡遺��뿉 �꽑�뼵�맂 static {} 釉붾줉�쓣 �닔�뻾�븳�떎.
        //    => Driver �씤�뒪�꽩�뒪瑜� �깮�꽦�븳�떎.
        //    => DriverManager�뿉 洹� �씤�뒪�꽩�뒪瑜� �벑濡앺븳�떎.
        
        // �뾾�떎硫� �깉濡� 留뚮뱾�뼱 鍮뚮젮以��떎.
        return DriverManager.getConnection(
                this.url, this.username, this.password);
    }
    
    synchronized public void returnConnection(Connection con) {
        try {
            if (con == null) return;
            if (con.isClosed()) return;
            list.add(con);
            
        } catch (Exception e) {}
    }
    
    synchronized public void close() {
        for (Connection con : list) {
            try {con.close();} catch (Exception e) {}
        }
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}






