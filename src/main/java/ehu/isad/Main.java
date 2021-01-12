package ehu.isad;

import ehu.isad.controllers.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  private Parent checksumUI;

  private Stage stage;

  private MenuController menuController;

  @Override
  public void start(Stage primaryStage) throws Exception {
    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("AZTERKETA 2020/2021");
    stage.setScene(new Scene(checksumUI));
    stage.show();
  }

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderKirolari = new FXMLLoader(getClass().getResource("/menu.fxml"));
    checksumUI = (Parent) loaderKirolari.load();
    menuController = loaderKirolari.getController();
    menuController.setMainApp(this);
  }
}
