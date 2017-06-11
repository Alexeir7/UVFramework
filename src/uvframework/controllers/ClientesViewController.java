/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import uvframework.models.ClientesModel;
import uvframework.models.entities.ClientesEntity;
import uvframework.tools.WindowsManager;


/**
 *
 * @author alexe
 */
public class ClientesViewController {
      
    @FXML private TextField txtIdentidad;
    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtDireccion;
    @FXML private TextField txtCorreo;
    
    @FXML
    private void RegresarBtnClick(){
        WindowsManager.getStage("/clientes").close();
        WindowsManager.getStage("/menu").show();
    }
    
    @FXML
    private void GuardarBtnClick(){
         ClientesEntity cliente = new ClientesEntity();
        
            cliente.identidad =  txtIdentidad.getText();
            cliente.nombre = txtNombre.getText();
            cliente.telefono = txtTelefono.getText();
            cliente.direccion = txtDireccion.getText();
            cliente.correo = txtCorreo.getText();
        
        if (ClientesModel.insertarClientes(cliente)) {
            
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
