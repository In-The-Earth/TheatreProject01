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

public class RegisterPageController {
    @FXML
    private Button btn_back;

    @FXML
    private TextField name_text;

    @FXML
    private TextField email_text;

    @FXML
    private TextField username_text;

    @FXML
    private PasswordField pass_text;

    @FXML
    private PasswordField conpass_text;

    @FXML
    private Label pi_txt1;

    @FXML
    private Button register_btn;

    @FXML
    private Label ut_txt;

    @FXML
    private ImageView yr;

    @FXML
    private Label ci_txt;

    private ArrayList<AccountProfile> accountProfiles = new ArrayList<>();

    @FXML public void initialize(){
        yr.setStyle("-fx-image: url('/img/yellowarrow.png')");
        String fs = File.separator;
        String dir = System.getProperty("user.dir")+fs+"resources";
        String filename = dir+fs+"profileAccount.csv";
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

    public boolean checkUser(){
        String user = username_text.getText();
        for(AccountProfile v : accountProfiles){
            if(v.getUsername().equals(user)){
                return true;
            }
        }
        return false;
    }

    @FXML public void handleGoRegister_btnOnAction(ActionEvent event) throws IOException {
        ci_txt.setText("");
        ut_txt.setText("");
        pi_txt1.setText("");
        String name = name_text.getText();
        String email = email_text.getText();
        String username = username_text.getText();
        String password = pass_text.getText();
        String conpassword = conpass_text.getText();

        if(name.trim().equals("") || email.trim().equals("") || username.trim().equals("") || password.trim().equals("") || conpassword.trim().equals("")){
            ci_txt.setText("Complete information!!");
            return;
        }

        if(checkUser() == true){
            ut_txt.setText("this username is taken !");
            if (password.equals(conpassword) != true) {
                pi_txt1.setText("Incorrect Confirm !");
                return;
            }
            return;
        }
        else {
            if (password.equals(conpassword) != true) {
                pi_txt1.setText("Incorrect Confirm !");
                return;
            } else {
                FileWriter fileWriter = null;
                try {
                    String fs = File.separator;
                    String dir = System.getProperty("user.dir") + fs + "resources";
                    String filename = dir + fs + "profileAccount.csv";
                    fileWriter = new FileWriter(filename, true);
                    BufferedWriter out = new BufferedWriter(fileWriter);
                    out.write(name + "," + email + "," + username + "," + password);
                    out.newLine();
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
                Parent loader = FXMLLoader.load(getClass().getResource("regissuccess.fxml"));
                Scene scene = new Scene(loader);
                Stage a = (Stage) register_btn.getScene().getWindow();
                a.setScene(scene);
            }
        }

    }

    @FXML public void handleGoBtn_backOnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Scene scene = new Scene(loader);
        Stage a = (Stage) btn_back.getScene().getWindow();
        a.setScene(scene);
}

}
