/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import uvframework.models.UsuariosModel;
import uvframework.models.entities.UsuarioEntity;

/**
 *
 * @author Rafael Maldonado
 */
public class LoginViewController implements Initializable {

    @FXML
    private TextField User;
    @FXML
    private TextField Password;

    @FXML
    private void LoginBtnClick() {

        UsuarioEntity user = new UsuarioEntity();
        user.UsrUsr = User.getText();
        user.UsrPwd = Password.getText();

        UsuarioEntity dbuser = UsuariosModel.Login(user);

        if (dbuser != null) {
            System.out.println("Usuario Valido!");
            System.out.println("Bienvenido " + dbuser.UsrNom + "!");
        } else {
            System.out.println("Usuario no Valido!");
        }

    }

    @FXML
    private void ListarBtnClick() {
        try {
            ResultSet rs = UsuariosModel.ImprimirUsuarios();

            while (rs.next()) {
                System.out.println(rs.getString("UsrUsr"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
