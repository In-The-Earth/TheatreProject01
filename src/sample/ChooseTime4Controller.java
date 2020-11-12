package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class ChooseTime4Controller {
    @FXML
    private Button btn_t_2;

    @FXML
    private Button btn_t_3;

    @FXML
    private Button btn_t_4;

    @FXML
    private Button btn_t_1;

    @FXML
    private Button btn_back;

    private String username;
    @FXML
    private ImageView sound1_img;
    @FXML
    private ImageView sound2_img;
    @FXML
    private ImageView sound3_img;
    @FXML
    private ImageView sound4_img;
    @FXML
    private ImageView ya;
    @FXML
    private ImageView dx_img;
    @FXML
    private ImageView imax_img;
    @FXML
    private ImageView ps_img;
    @FXML
    private Label des_txt;
    @FXML
    MediaView tl_media;
    @FXML
    MediaPlayer mediaPlayer;


    @FXML public void initialize(){
        ps_img.setStyle("-fx-image: url('/img/yourname.jpg')");
        sound1_img.setStyle("-fx-image: url('/img/sound.png')");
        sound2_img.setStyle("-fx-image: url('/img/sound.png')");
        sound3_img.setStyle("-fx-image: url('/img/sound.png')");
        sound4_img.setStyle("-fx-image: url('/img/sound.png')");
        ya.setStyle("-fx-image: url('/img/yellowarrow.png')");
        dx_img.setStyle("-fx-image: url('/img/4dx.png')");
        imax_img.setStyle("-fx-image: url('/img/imax.png')");
        des_txt.setText("High school girl Mitsuha Miyamizu \nlives in the fictional town of Itomori \nin Japan's mountainous Hida region. \nShe is bored with the country life,\n and wishes to be a handsome boy \nin her next life. She begins switching \nbodies intermittently with Taki Tachibana,\n a high school boy in Tokyo");
        try {
            mediaPlayer = new MediaPlayer(new Media(getClass().getResource("/trailer/yourname.mp4").toURI().toString()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        tl_media.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @FXML public void handleGoBtn_backOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(loader.load());
        Stage a = (Stage) btn_back.getScene().getWindow();
        a.setScene(scene);
        Controller c = loader.getController();
        c.setUsername(username);
        tl_media.getMediaPlayer().stop();
    }

    @FXML public void handleGoBtn_t_1OnAction(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("theatre1.fxml"));
        Scene scene = new Scene(loader.load());
        Stage a = (Stage) btn_t_1.getScene().getWindow();
        a.setScene(scene);
        Theatre1Controller t1 = loader.getController();
        String round = b.getText();
        t1.setAll("chooseTime4.fxml","YourName",round,username);
        tl_media.getMediaPlayer().stop();
        a.show();

    }

    @FXML public void handleGoBtn_t_2OnAction(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("theatre2.fxml"));
        Scene scene = new Scene(loader.load());
        Stage a = (Stage) btn_t_2.getScene().getWindow();
        a.setScene(scene);
        Theatre2Controller t2 = loader.getController();
        String round = b.getText();
        t2.setAll("chooseTime4.fxml","YourName",round,username);
        tl_media.getMediaPlayer().stop();
        a.show();

    }

    @FXML public void handleGoBtn_t_3OnAction(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("theatre3.fxml"));
        Scene scene = new Scene(loader.load());
        Stage a = (Stage) btn_t_3.getScene().getWindow();
        a.setScene(scene);
        Theatre3Controller t3 = loader.getController();
        String round = b.getText();
        t3.setAll("chooseTime4.fxml","YourName",round,username);
        tl_media.getMediaPlayer().stop();
        a.show();

    }

    @FXML public void handleGoBtn_t_4OnAction(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("theatre4.fxml"));
        Scene scene = new Scene(loader.load());
        Stage a = (Stage) btn_t_4.getScene().getWindow();
        a.setScene(scene);
        Theatre4Controller t4 = loader.getController();
        String round = b.getText();
        t4.setAll("chooseTime4.fxml","YourName",round,username);
        tl_media.getMediaPlayer().stop();
        a.show();

    }
}
