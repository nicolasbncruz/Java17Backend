package edu.cibertec.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpere
 */
@Repository
public class Conexion {
    private static Connection conn = null;

    public static Connection obtenerConexion() {
        try {
            if (conn == null) {
                String driver = "com.mysql.cj.jdbc.Driver";
                String bd="sysventa";//Nombre del esquema o BD 
                String url = "jdbc:mysql://localhost:3306/"+bd+"?serverTimezone=UTC";
                String user = "root"; //El usuario de la BD
                String pwd = "Oracle25."; //La contraseña de la BD
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, pwd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }


    public static void cerrarConexion(Connection cn) {
        try {
            if (cn != null) {
                cn.close();
                cn = null;
                if(conn!=null){
                    conn.close();
                    conn=null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
     public static void cerrarConexionRs( ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     public static void cerrarConexionPs(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
                ps = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     public static void cerrarConexionSt(Statement st) {
        try {
            if (st != null) {
                st.close();
                st = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
