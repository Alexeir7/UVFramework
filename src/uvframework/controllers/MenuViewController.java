/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.controllers;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import uvframework.tools.MySQLConn;
import uvframework.tools.WindowsManager;

/**
 *
 * @author alexe
 */
public class MenuViewController {
    
    @FXML
    private void ClientesBtnClick(){
        WindowsManager.getStage("/menu").close();
        WindowsManager.getStage("/clientes").show();
    }
    
    @FXML
    private void UsuariosBtnClick(){
        WindowsManager.getStage("/menu").close();
        WindowsManager.getStage("/usuarios").show();
    }
    
    @FXML
    private void SalirBtnClick(){
        WindowsManager.getStage("/menu").close();
        WindowsManager.getStage("/login").show();
        try {
            MySQLConn.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MenuViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
