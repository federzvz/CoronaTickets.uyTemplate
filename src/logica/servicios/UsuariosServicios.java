/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.servicios;

import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import logica.Clases.Usuario;

/**
 *
 * @author LucasCiceri
 */
public class UsuariosServicios {

    public UsuariosServicios() {
    }
    private Connection conexion = new ConexionDB().getConexion();

    public Map<String, Usuario> getUsers() {
        Map<String, Usuario> resultado = new HashMap<>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs = status.executeQuery();

            while (rs.next()) {
                resultado.put(rs.getString("nombre"), new Usuario(rs.getString("nombre"), rs.getString("apellido")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return resultado;
    }

}
