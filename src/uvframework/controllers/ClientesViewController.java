/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        txtIdentidad.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtCorreo.setText("");
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
         try {
            ResultSet rs=ClientesModel.listarClientes();
            while(rs.next()){
                System.out.println(rs.getString("nombreCliente"));
                System.out.println(rs.getString("telefono"));
                System.out.println(rs.getString("correo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientesViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
