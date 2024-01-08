
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLBaglantisi implements VeritabaniPlatformu{
    
    private Connection con = null;
    
    @Override
    public void baglantiyiYapilandir() {
        String url = "jdbc:mysql://"+VeritabaniBilgileri.host+":"+VeritabaniBilgileri.port+"/"+VeritabaniBilgileri.dbName+"?useUnicode=true&characterEncoding=utf8";
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");   
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver is not found!");
        }
        
        try {
            con=(Connection) DriverManager.getConnection(url,VeritabaniBilgileri.username,VeritabaniBilgileri.password);
                        
            System.out.println("Connection is successful!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }

    }
    
    @Override
    public Connection baglantiyiGetir(){
        
        return this.con;
    }
    
}
