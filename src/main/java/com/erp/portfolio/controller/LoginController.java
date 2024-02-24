package com.erp.portfolio.controller;

import com.erp.portfolio.entity.ResponseQuery;
import com.erp.portfolio.model.User;
import com.erp.portfolio.repository.LoginDAO;
import com.erp.portfolio.service.LoginService;
import com.erp.portfolio.service.ProjectService;
import com.mysql.cj.log.Log;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class LoginController implements Initializable {

    private final LoginService loginService;

    public LoginController(LoginService loginService)
    {
        this.loginService = loginService;
    }
    @FXML
    private Button btnIngresar;

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField pssPassword;

    public void verifyUser()
    {
        if(txtUsername!= null && !txtUsername.getText().isEmpty() && this.pssPassword!=null && !this.pssPassword.getText().isEmpty())
        {
            String username = txtUsername.getText();
            String password = pssPassword.getText();
            ResponseQuery responseQuery = loginService.verifyUser(User.builder().username(username).password(password).build());

            if(responseQuery.getStatus().equals(0))
            {
               //TODO: LLAMAR METODO PARA PASAR A LA SIGUIENTE ESCENA
            }else {
               //TODO: LANZAR UN MENSAJE DE ERROR EN FXML
            }

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }
}
