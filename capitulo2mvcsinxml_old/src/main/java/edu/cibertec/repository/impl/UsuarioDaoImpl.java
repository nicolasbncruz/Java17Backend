package edu.cibertec.repository.impl;

import edu.cibertec.dto.UsuarioDTO;
import edu.cibertec.repository.Conexion;
import edu.cibertec.repository.UsuarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
}
