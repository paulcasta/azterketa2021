package ehu.isad.controllers;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField txtErabiltzaile;

    @FXML
    private PasswordField txtPasahitza;

    @FXML
    private Button kautotuBotoia;

    @FXML
    void onClick(ActionEvent event) {
        System.out.println(txtErabiltzaile.getText() + ":" + txtPasahitza.getText());
    }


}
