package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ConfirmBuyController {
    private String username;
    private String theatre;
    private String movie;
    private String time;
    private ArrayList<String> chair = new ArrayList<>();
    private String comingfrom;
    private String comingfromBefore;
    private String money;
    private ArrayList<String> tickets = new ArrayList<>();

    @FXML
    private Label user_txt;
    @FXML
    private Label t_txt;
    @FXML
    private Label movie_txt;
    @FXML
    private Label chair_txt;
    @FXML
    private Label time_txt;
    @FXML
    private ImageView poster_img;
    @FXML
    private Button cancel_btn;
    @FXML
    private Button confirm_btn;
    @FXML
    private Label price_txt;

    @FXML
    public void initialize(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if(movie.equals("Avenger")){
                    poster_img.setStyle("-fx-image: url('/img/avenger.jpg')");
                }else if(movie.equals("ToyStory")){
                    poster_img.setStyle("-fx-image: url('/img/toy.jpg')");
                }else if(movie.equals("LionKing")){
                    poster_img.setStyle("-fx-image: url('/img/lionking.jpg')");
                }else if(movie.equals("YourName")){
                    poster_img.setStyle("-fx-image: url('/img/yourname.jpg')");
                }
                user_txt.setText("Username: "+username);
                t_txt.setText(theatre);
                movie_txt.setText("Movie: "+movie);
                time_txt.setText("Round: "+time);
                chair_txt.setText("Chair: "+chairToString());
                price_txt.setText("Price: "+money+".-");
            }
        });
    }
    public String chairToString(){
        String result = "";
        for(String v : chair){
            result += v+" ";
        }
        return result;
    }

    public void setAll(String username, String theatre, String movie, String time, ArrayList<String> chair,String comingfrom,String comingfromBefore,String money,ArrayList<String> tickets) {
        this.username = username;
        this.theatre = theatre;
        this.movie = movie;
        this.time = time;
        this.chair = chair;
        this.comingfrom = comingfrom;
        this.comingfromBefore = comingfromBefore;
        this.money = money;
        this.tickets = tickets;
    }

    @FXML public void handleGoCancel_btnOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(comingfrom));
        Scene scene = new Scene(loader.load());
        Stage a = (Stage) cancel_btn.getScene().getWindow();
        a.setScene(scene);
        if (comingfrom.equals("theatre1.fxml")) {
            Theatre1Controller f = loader.getController();
            f.setAll(comingfromBefore, movie, time, username);
        } else if (comingfrom.equals("theatre2.fxml")) {
            Theatre2Controller f = loader.getController();
            f.setAll(comingfromBefore, movie, time, username);
        } else if (comingfrom.equals("theatre3.fxml")) {
            Theatre3Controller f = loader.getController();
            f.setAll(comingfromBefore, movie, time, username);
        } else if (comingfrom.equals("theatre4.fxml")) {
            Theatre4Controller f = loader.getController();
            f.setAll(comingfromBefore, movie, time, username);
        }
    }

    @FXML public void handleGoConfirm_btnOnAction(ActionEvent event) throws IOException {
        FileWriter fileWriter = null;
        try {
            String fs = File.separator;
            String dir = System.getProperty("user.dir") + fs + "resources";
            String filename = dir + fs + "BookingData.csv";
            fileWriter = new FileWriter(filename, true);
            BufferedWriter out = new BufferedWriter(fileWriter);
            for(String v : tickets){
                out.write(v);
                out.newLine();
            }
            out.flush();
        } catch (IOException e) {
            System.err.println("Error reading file");
        } finally {
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                System.err.println("Error closing file");
            }
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource(comingfrom));
        Scene scene = new Scene(loader.load());
        Stage a = (Stage) cancel_btn.getScene().getWindow();
        a.setScene(scene);
        if (comingfrom.equals("theatre1.fxml")) {
            Theatre1Controller f = loader.getController();
            f.setAll(comingfromBefore, movie, time, username);
        } else if (comingfrom.equals("theatre2.fxml")) {
            Theatre2Controller f = loader.getController();
            f.setAll(comingfromBefore, movie, time, username);
        } else if (comingfrom.equals("theatre3.fxml")) {
            Theatre3Controller f = loader.getController();
            f.setAll(comingfromBefore, movie, time, username);
        } else if (comingfrom.equals("theatre4.fxml")) {
            Theatre4Controller f = loader.getController();
            f.setAll(comingfromBefore, movie, time, username);
        }
    }

}
