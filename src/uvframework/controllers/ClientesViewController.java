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
public class ClientesViewController {
    
    @FXML
    private void RegresarBtnClick(){
        WindowsManager.getStage("/clientes").close();
        WindowsManager.getStage("/menu").show();
    }
    
    @FXML
    private void GuardarBtnClick(){
        System.out.println("guardar");
    }
    
    @FXML
    private void ListarBtnClick(){
        System.out.println("listar");
    }
    
}
