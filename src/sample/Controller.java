package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    private Button btn_m_1;

    @FXML
    private Button btn_m_2;

    @FXML
    private Button btn_m_3;

    @FXML
    private Button btn_m_4;

    @FXML
    private Button btn_logout;

    @FXML
    private ImageView ra;

    @FXML
    private ImageView pc_img;

    @FXML
    private ImageView avenger_img;

    @FXML
    private ImageView toy_img;

    @FXML
    private ImageView lion_img;

    @FXML
    private ImageView yn_img;

    private String username;

    @FXML public void initialize(){
        pc_img.setStyle("-fx-image: url('/img/popcorn.png')");
        ra.setStyle("-fx-image: url('/img/redarrow.png')");
        avenger_img.setStyle("-fx-image: url('/img/avenger.jpg')");
        toy_img.setStyle("-fx-image: url('/img/toy.jpg')");
        lion_img.setStyle("-fx-image: url('/img/lionking.jpg')");
        yn_img.setStyle("-fx-image: url('/img/yourname.jpg')");

    }

    public void setUsername(String username) {
        this.username = username;
    }

    @FXML public void handleGoBtn_logoutOnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Scene scene = new Scene(loader);
        Stage a = (Stage) btn_logout.getScene().getWindow();
        a.setScene(scene);
    }

    @FXML public void handleGoBtn_m_1OnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chooseTime1.fxml"));
        Scene scene = new Scene(loader.load());
        Stage a = (Stage) btn_m_1.getScene().getWindow();
        a.setScene(scene);
        ChooseTime1Controller c1 = loader.getController();
        c1.setUsername(username);

    }

    @FXML public void handleGoBtn_m_2OnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chooseTime2.fxml"));
        Scene scene = new Scene(loader.load());
        Stage a = (Stage) btn_m_2.getScene().getWindow();
        a.setScene(scene);
        ChooseTime2Controller c2 = loader.getController();
        c2.setUsername(username);

    }

    @FXML public void handleGoBtn_m_3OnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chooseTime3.fxml"));
        Scene scene = new Scene(loader.load());
        Stage a = (Stage) btn_m_3.getScene().getWindow();
        a.setScene(scene);
        ChooseTime3Controller c3 = loader.getController();
        c3.setUsername(username);

    }

    @FXML public void handleGoBtn_m_4OnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chooseTime4.fxml"));
        Scene scene = new Scene(loader.load());
        Stage a = (Stage) btn_m_4.getScene().getWindow();
        a.setScene(scene);
        ChooseTime4Controller c4 = loader.getController();
        c4.setUsername(username);

    }
}