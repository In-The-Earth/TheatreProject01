package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class LoginPageController {
    @FXML
    private Button register_btn;

    @FXML
    private TextField user_txt;

    @FXML
    private PasswordField pw_txt;

    @FXML
    private Label uw_txt;

    @FXML
    private Label paw_txt;

    @FXML
    private Button pdc_btn;
    @FXML
    private ImageView bar_img;

    @FXML
    private Button login_btn;
    private ArrayList<AccountProfile> accountProfiles = new ArrayList<>();

    @FXML public void initialize(){
        bar_img.setStyle("-fx-image: url('/img/bar.png')");
        String fs = File.separator;
        String dir = System.getProperty("user.dir")+fs+"resources";
        String filename = dir+fs+"profileAccount.csv";
        String filename2 = dir+fs+"BookingData.csv";
        File file = new File(dir);
        BufferedWriter bufferedWriter = null;
        try{
            if(!file.exists()){
                file.mkdirs();
                File myFile = new File(filename);
                File myFile2 = new File(filename2);
                myFile.createNewFile();
                myFile2.createNewFile();
                bufferedWriter = new BufferedWriter(new FileWriter(filename));
                bufferedWriter.write("test1,test@ku.th,testuser,12345");
                bufferedWriter.newLine();
                bufferedWriter.write("player,player@ku.th,playeruser,playerpass");
                bufferedWriter.newLine();
                bufferedWriter.flush();

                if(bufferedWriter != null) bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader buffer = new BufferedReader(fileReader);

            String line = null;
            while((line = buffer.readLine()) != null){
                String[] data = line.split(",");
                String name = data[0].trim();
                String email = data[1].trim();
                String username = data[2].trim();
                String password = data[3].trim();
                AccountProfile s = new AccountProfile(name,email,username,password);
                accountProfiles.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void handleGoPdc_btnOnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("producerProfile.fxml"));
        Scene scene = new Scene(loader);
        Stage a = (Stage) pdc_btn.getScene().getWindow();
        a.setScene(scene);
    }

    @FXML public void handleGoRegister_btnOnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("registerPage.fxml"));
        Scene scene = new Scene(loader);
        Stage a = (Stage) register_btn.getScene().getWindow();
        a.setScene(scene);
    }

    @FXML public void handleGoLogin_btnOnAction(ActionEvent event) throws IOException {
        uw_txt.setText("");
        paw_txt.setText("");
        if(checkUser() == true) {
            for (AccountProfile v : accountProfiles) {
                if ((v.getUsername()).equals(user_txt.getText())) {
                    if ((v.getPassword()).equals(pw_txt.getText())) {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
                        Scene scene = new Scene(loader.load());
                        Stage a = (Stage) login_btn.getScene().getWindow();
                        a.setScene(scene);
                        Controller c = loader.getController();
                        String user = v.getUsername();
                        c.setUsername(user);
                    } else {
                        paw_txt.setText("Incorrect Password");
                    }
                }
            }
        }else {
            uw_txt.setText("Incorrect Username");
        }

    }
    public boolean checkUser(){
        String user = user_txt.getText();
        for(AccountProfile v : accountProfiles){
            if(v.getUsername().equals(user)){
                return true;
            }
        }
        return false;
    }
}
