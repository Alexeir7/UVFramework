/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import uvframework.models.UsuariosModel;
import uvframework.models.entities.UsuarioEntity;
import uvframework.tools.WindowsManager;

/**
 *
 * @author alexe
 */
public class UsuariosViewController {
    
    @FXML private TextField txtUsuario;
    @FXML private TextField txtNombre;
    @FXML private PasswordField txtContraseña;
    
    @FXML
    private void RegresarBtnClick(){
        
        WindowsManager.getStage("/usuarios").close();
        WindowsManager.getStage("/menu").show();
    }
    
    @FXML
    private void GuardarBtnClick(){
        
        UsuarioEntity usuario = new UsuarioEntity();
        
        usuario.UsrUsr = txtUsuario.getText();
        usuario.UsrNom = txtNombre.getText();
        usuario.UsrPwd = txtContraseña.getText();
        
        if (UsuariosModel.insertarUsuario(usuario)) {
            
            System.out.println("guardado exitoso!");
            
        } else {
            System.out.println("error al guardar!");
        }
    }
    
    @FXML
    private void ListarBtnClick(){
        System.out.println("listar");
    }
    
}
