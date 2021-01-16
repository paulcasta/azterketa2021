package ehu.isad.controllers;

import ehu.isad.Main;
import ehu.isad.db.ChecksumKud;
import ehu.isad.utils.Checksum;
import ehu.isad.utils.Lag;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import org.apache.commons.codec.binary.Hex;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ResourceBundle;

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
    void checkEgin(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        versionId.setEditable(true);
        String aux = textId.getText();
        String md5 = this.md5(aux);
        List<Lag>  laglist2 = ChecksumKud.getInstance().lortuLagak(aux, md5);
        if (ChecksumKud.getInstance().badago(md5)){
            Lag lag1 = laglist2.get(0);
            taulaId.getItems().add(lag1);
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



    public  String md5(String aux) throws NoSuchAlgorithmException, FileNotFoundException, IOException {

        URL url = new URL(aux + "/README");
        InputStream is = url.openStream();
        MessageDigest md = MessageDigest.getInstance("MD5");
        String digest = getDigest(is, md, 2048);

        System.out.println("MD5 Digest:" + digest);
        return digest;

    }

    public  String getDigest(InputStream is, MessageDigest md, int byteArraySize)
            throws NoSuchAlgorithmException, IOException {

        md.reset();
        byte[] bytes = new byte[byteArraySize];
        int numBytes;
        while ((numBytes = is.read(bytes)) != -1) {
            md.update(bytes, 0, numBytes);
        }
        byte[] digest = md.digest();
        String result = new String(Hex.encodeHex(digest));
        return result;
    }

    public void setMainApp(Main main) {
        this.main = main;
    }
}
