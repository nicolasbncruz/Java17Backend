package edu.cibertec.repository.impl;

import edu.cibertec.dto.UsuarioDTO;
import edu.cibertec.repository.Conexion;
import edu.cibertec.repository.UsuarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpere
 */
@Repository
public class UsuarioDaoImpl implements UsuarioDao{
    @Autowired
    private Conexion conecta;
    @Override
    public UsuarioDTO validarLogin(UsuarioDTO usuario) {
    UsuarioDTO resultUsuario = null;
        String sql = "SELECT "
                + "idusuario,"
                + "usuario,"
                + "clave,"
                + "nombreApellido "
                + "FROM usuario WHERE usuario=? and clave=?";

        Connection cn = conecta.obtenerConexion();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, usuario.getUsuario());
                ps.setString(2, usuario.getClave());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    resultUsuario = new UsuarioDTO();

                    resultUsuario.setUsuario(rs.getString(1));
                    resultUsuario.setClave(rs.getString(2));
                    resultUsuario.setNombreApellido(rs.getString(3));
                }
                conecta.cerrarConexion(cn);
                conecta.cerrarConexionPs(ps);
                conecta.cerrarConexionRs(rs);
            } catch (SQLException e) {
                System.out.println("");
            } 
        }
        return resultUsuario;
    }

    @Override
    public void insertarUsuario(UsuarioDTO usuario) {
       String result = null;
        String sql = "INSERT INTO usuario("
                + "usuario,"
                + "clave,"
                + "nombreApellido"
                + ") VALUES(?,?,?)";

        Connection cn = conecta.obtenerConexion();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, usuario.getUsuario());
                ps.setString(2, usuario.getClave());
                ps.setString(3, usuario.getNombreApellido());

                int ctos = ps.executeUpdate();
                if (ctos == 0) {
                    throw new SQLException("0 filas afectadas");
                }
                conecta.cerrarConexion(cn);
                conecta.cerrarConexionPs(ps);
            } catch (SQLException e) {
                result = e.getMessage();
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    result = e.getMessage();
                }
            }
        }
        //return result; 
    }

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        List<UsuarioDTO> list = null;
        String sql = "SELECT "
                + "idusuario "
                + "usuario,"
                + "clave,"
                + "nombreApellido, "
                + "foto "
                + "FROM usuario";

        Connection cn = conecta.obtenerConexion();
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);

                list = new ArrayList<>();

                while (rs.next()) {
                    UsuarioDTO u = new UsuarioDTO();
                   u.setIdUsuario(rs.getInt(1));
                   u.setUsuario(rs.getString(2));
                   u.setClave(rs.getString(3));
                   u.setNombreApellido(rs.getString(4));
                   u.setFoto(rs.getBytes(5));
                    list.add(u);
                }
                conecta.cerrarConexion(cn);
                conecta.cerrarConexionSt(st);
                conecta.cerrarConexionRs(rs);
            } catch (SQLException e) {
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return list;
    }
    
    @Override
    public UsuarioDTO getUsuario(Integer idUsuario) {
        UsuarioDTO u = new UsuarioDTO();
        String sql = "SELECT "
                + "idusuario,"
                + "usuario,"
                + "clave,"
                + "nombreApellido, "
                + "foto "
                + "FROM usuario "
                + "where usuario="+idUsuario;
        Connection cn = conecta.obtenerConexion();
        
        if (cn != null) {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while (rs.next()) {   
                   u.setIdUsuario(rs.getInt(1));
                   u.setUsuario(rs.getString(2));
                   u.setClave(rs.getString(3));
                   u.setNombreApellido(rs.getString(4));
                   u.setFoto(rs.getBytes(5));
                }
                conecta.cerrarConexion(cn);
                conecta.cerrarConexionSt(st);
                conecta.cerrarConexionRs(rs);
            } catch (SQLException e) {
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return u;
    }
    
    
    @Override
    public void subirFoto(UsuarioDTO usuario) {
       String result = null;
        String sql = "UPDATE usuario SET foto=? WHERE idusuario=?";

        Connection cn = conecta.obtenerConexion();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setBytes(1, usuario.getFoto());
                ps.setInt(2, usuario.getIdUsuario());
                ps.setString(3, usuario.getNombreApellido());

                int ctos = ps.executeUpdate();
                if (ctos == 0) {
                    throw new SQLException("0 filas afectadas");
                }
                conecta.cerrarConexion(cn);
                conecta.cerrarConexionPs(ps);
            } catch (SQLException e) {
                result = e.getMessage();
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    result = e.getMessage();
                }
            }
        }
        //return result; 
    }
    
    
}
