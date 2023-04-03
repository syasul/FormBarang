/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author T470s
 */
public class Koneksi {
    static Connection Kon;
    
    public static Connection connection() {
        if (Kon == null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("toko");
            data.setUser("root");
            data.setPassword("");
            try {
                Kon = data.getConnection();
                System.out.println("Sudah Konek");
            } catch (SQLException ex) {
                System.out.println("Tidak Konek");
            }
        }
        return Kon;
    }
}
