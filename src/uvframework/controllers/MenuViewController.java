/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.controllers;

import javafx.fxml.FXML;
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
    }
    
}
