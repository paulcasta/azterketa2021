package ehu.isad.controllers;

import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ehu.isad.Main;
import ehu.isad.db.ChecksumKud;
import ehu.isad.db.DBKudeatzaile;
import ehu.isad.utils.Checksum;
import ehu.isad.utils.Lag;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class MenuController {
    private Main main;
    private List<Checksum> lagList;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Lag> taulaId;

    @FXML
    private TableColumn<?, ?> urlId;

    @FXML
    private TableColumn<?, ?> md5Id;

    @FXML
    private TableColumn<?, ?> versionId;

    @FXML
    private TextField textId;

    @FXML
    private Button checkId;

    @FXML
    private Text textu1Id;

    @FXML
    private Text textu2ID;



    @FXML
    void checkEgin(ActionEvent event) {
        String aux = textId.getText();
        System.out.println(aux);
        String lag = aux + "/README";
        String md5 = this.MD5(lag);
        if (ChecksumKud.getInstance().badago(md5)){
            textu1Id.setVisible(true);

        }
        else{
            Lag l = new Lag(aux, md5, "-");
            taulaId.getItems().add(l);
            textu2ID.setVisible(true);

        }


    }

    @FXML
    void initialize() {
        textu2ID.setVisible(false);
        textu1Id.setVisible(false);
        lagList = ChecksumKud.getInstance().lortuChecksum();
        urlId.setCellValueFactory(new PropertyValueFactory<>("url"));
        md5Id.setCellValueFactory(new PropertyValueFactory<>("md5"));
        versionId.setCellValueFactory(new PropertyValueFactory<>("version"));


    }



    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

    public void setMainApp(Main main) {
        this.main = main;
    }
}
