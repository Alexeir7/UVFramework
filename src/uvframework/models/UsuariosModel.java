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
import uvframework.models.entities.UsuarioEntity;
import uvframework.tools.MySQLConn;

/**
 *
 * @author Rafael Maldonado
 */
public class UsuariosModel {

    public static UsuarioEntity Login(UsuarioEntity user) {

        try {

            String qry = "SELECT * FROM usuario where UsrUsr = ? AND UsrPwd= ?; ";

            PreparedStatement pst = MySQLConn.conn.prepareStatement(qry);

            pst.setString(1, user.UsrUsr);
            pst.setString(2, user.UsrPwd);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                UsuarioEntity dbuser = new UsuarioEntity();
                dbuser.UsrNom = rs.getString("UsrNom");
                dbuser.UsrUsr = rs.getString("UsrUsr");
                dbuser.UsrPwd = rs.getString("UsrPwd");
                return dbuser;
            }else{
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static ResultSet ImprimirUsuarios(){
        
        try {
            String qry = "SELECT UsrUsr, UsrNom FROM usuario;";
            
            PreparedStatement ps =  MySQLConn.conn.prepareStatement(qry);
            
            ResultSet rs = ps.executeQuery();
            
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static Boolean insertarUsuario(UsuarioEntity usuario){
        
        try {
            String sqlInsert = "INSERT INTO usuario (UsrUsr, UsrNom, UsrPwd) VALUES ( ?, ?, ?);";
            
            PreparedStatement ps = MySQLConn.conn.prepareStatement(sqlInsert);
            
            ps.setString(1, usuario.UsrUsr);
            ps.setString(2, usuario.UsrNom);
            ps.setString(3, usuario.UsrPwd);
            
            ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            
        }
    }
}
