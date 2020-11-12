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

public class ProducerProfileController {
    @FXML
    private Button btn_back;
    @FXML
    private ImageView ya;
    @FXML
    private ImageView p_img;
    @FXML public void initialize(){
        p_img.setStyle("-fx-image: url('/img/profile.png')");
        ya.setStyle("-fx-image: url('/img/yellowarrow.png')");
    }

    @FXML
    public void handleGoBtn_backOnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Scene scene = new Scene(loader);
        Stage a = (Stage) btn_back.getScene().getWindow();
        a.setScene(scene);

    }
}
