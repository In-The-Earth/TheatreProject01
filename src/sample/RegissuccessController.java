package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class RegissuccessController {
    @FXML
    private Button back_login;

    @FXML
    private ImageView popcorn;

    @FXML public void initialize(){
        popcorn.setStyle("-fx-image: url('/img/popcorn.png')");
    }

    @FXML public void handleGoBack_loginOnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Scene scene = new Scene(loader);
        Stage a = (Stage) back_login.getScene().getWindow();
        a.setScene(scene);
    }
}
