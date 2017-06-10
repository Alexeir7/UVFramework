/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.net.www.content.text.plain;
import uvframework.models.entities.ClientesEntity;
import uvframework.tools.MySQLConn;

/**
 *
 * @author alexe
 */
public class ClientesModel {
    
    public static Boolean insertarClientes( ClientesEntity cliente){
        
        try {
            String sqlInsert = "insert into clientes identidad, nombreCliente, telefono, direccion, correo values (?,?,?,?,?);";
            PreparedStatement ps = MySQLConn.conn.prepareStatement(sqlInsert);
            ps.setString(1, cliente.identidad);
            ps.setString(2, cliente.nombre);
            ps.setString(3, cliente.telefono);
            ps.setString(4, cliente.direccion);
            ps.setString(5, cliente.correo);
            
            ResultSet rs = ps.executeQuery(sqlInsert);
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static ResultSet listarClientes (){
        
        try {
            String sqlSelect = "select * from clientes;";
            PreparedStatement ps = MySQLConn.conn.prepareStatement(sqlSelect);
            ResultSet rs = ps.executeQuery(sqlSelect);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
