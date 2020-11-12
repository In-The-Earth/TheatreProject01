package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Theatre1Controller {
    private int money =0;
    private String username;
    private String movie;
    private String comingfrom;
    private String round;
    private String theatre = "t1";
    private ArrayList<Ticket> tickets = new ArrayList<>();
    private ArrayList<Ticket> removeTickets = new ArrayList<>();

    private ArrayList<String> ticketsCheck = new ArrayList<>();
    private ArrayList<String> arrayChairs = new ArrayList<>();

    @FXML
    private Label price_num;

    @FXML
    private Button btn_back;
    @FXML
    private ImageView ya;
    @FXML
    private ImageView cr;
    @FXML
    private ImageView sc_img;
    @FXML
    private Button buy_btn;
    @FXML
    Button A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,D1,D2,D3,D4,D5,D6,D7,D8,D9,D10;

    @FXML public void initialize(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                String fs = File.separator;
                String dir = System.getProperty("user.dir")+fs+"resources";
                String filename = dir+fs+"BookingData.csv";
                try {
                    FileReader fileReader = new FileReader(filename);
                    BufferedReader buffer = new BufferedReader(fileReader);

                    String line = null;
                    while((line = buffer.readLine()) != null){
                        String[] data = line.split(",");
                        String user = data[0].trim();
                        String theatre = data[1].trim();
                        String time = data[2].trim();
                        String chair = data[3].trim();
                        String movie = data[4].trim();
                        Ticket s = new Ticket(user,theatre,time,chair,movie);
                        tickets.add(s);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Button[] btns = {A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,D1,D2,D3,D4,D5,D6,D7,D8,D9,D10};
                if(checkTicket() == false){
                    for(int i=0; i<40;i++){
                        btns[i].setStyle("-fx-background-image: url('/img/chair.png')");
                    }
                }else {
                    for(Ticket v : tickets){
                        if(v.getTheatre().equals(theatre)){
                            if(v.getMovie().equals(movie)){
                                if(v.getTime().equals(round)){
                                    for(int i=0; i<40;i++){
                                        if(v.getChair().equals(btns[i].getId())){
                                            if(v.getUser().equals(username)) {
                                                btns[i].setStyle("-fx-background-image: url('/img/chairbooked2.png')");
                                            }else{
                                                btns[i].setStyle("-fx-background-image: url('/img/reserved.png')");
                                                btns[i].setDisable(true);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    for(int i=0;i<40;i++){
                        if(btns[i].getStyle() != "-fx-background-image: url('/img/chairbooked2.png')" && btns[i].getStyle() != "-fx-background-image: url('/img/reserved.png')"){
                            btns[i].setStyle("-fx-background-image: url('/img/chair.png')");
                        }
                    }
                }
            }
        });
        price_num.setText("0");
        buy_btn.setDisable(true);
        cr.setStyle("-fx-image: url('/img/chair.png')");
        ya.setStyle("-fx-image: url('/img/yellowarrow.png')");
        sc_img.setStyle("-fx-image: url('/img/screen.png')");
    }

    public boolean checkTicket(){
        for(Ticket v : tickets){
            if(v.getTheatre().equals(theatre)){
                if(v.getMovie().equals(movie)){
                    if(v.getTime().equals(round)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void setAll(String comingfrom,String movie,String round,String username){
        this.comingfrom = comingfrom;
        this.movie = movie;
        this.round = round;
        this.username = username;
    }

    @FXML public void handleGoBtn_backOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(comingfrom));
        Scene scene = new Scene(loader.load());
        Stage a = (Stage) btn_back.getScene().getWindow();
        a.setScene(scene);
        if(comingfrom.equals("chooseTime1.fxml")){
            ChooseTime1Controller f = loader.getController();
            f.setUsername(username);
        }else if(comingfrom.equals("chooseTime2.fxml")){
            ChooseTime2Controller f = loader.getController();
            f.setUsername(username);
        }else if(comingfrom.equals("chooseTime3.fxml")){
            ChooseTime3Controller f = loader.getController();
            f.setUsername(username);
        }else if(comingfrom.equals("chooseTime4.fxml")){
            ChooseTime4Controller f = loader.getController();
            f.setUsername(username);
        }

    }

    @FXML public void handleSelectOnAction(ActionEvent event) throws IOException {
        Button b =(Button)event.getSource();
        if(b.getStyle() == "-fx-background-image: url('/img/chair.png')"){
            b.setStyle("-fx-background-image: url('/img/chaircheck.png')");
            ticketsCheck.add(username+","+theatre+","+round+","+b.getId()+","+movie);
            arrayChairs.add(b.getId());
            money += 220;
            price_num.setText(String.valueOf(money));
        }
        else if(b.getStyle() == "-fx-background-image: url('/img/chaircheck.png')"){
            b.setStyle("-fx-background-image: url('/img/chair.png')");
            ticketsCheck.remove(username+","+theatre+","+round+","+b.getId()+","+movie);
            arrayChairs.remove(b.getId());
            money -= 220;
            price_num.setText(String.valueOf(money));
        }
        else if(b.getStyle() == "-fx-background-image: url('/img/chairbooked2.png')"){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure want to remove this seat?", ButtonType.YES,ButtonType.NO);
            alert.showAndWait();
            if(alert.getResult() == ButtonType.NO){
                return;
            }else {
                for(int i=0; i<tickets.size();i++){
                    if(tickets.get(i).toString().equals(username + "," + theatre + "," + round + "," + b.getId() + "," + movie)){
                        tickets.remove(i);
                    }
                }
                FileWriter fileWriter = null;
                try {
                    String fs = File.separator;
                    String dir = System.getProperty("user.dir") + fs + "resources";
                    String filename = dir + fs + "BookingData.csv";
                    fileWriter = new FileWriter(filename);
                    BufferedWriter out = new BufferedWriter(fileWriter);
                    for(Ticket v : tickets){
                        out.write(v.toString());
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
                b.setStyle("-fx-background-image: url('/img/chair.png')");
            }
        }
        if(money <= 0){
            buy_btn.setDisable(true);
        }else
            buy_btn.setDisable(false);
        System.out.println(ticketsCheck);
        System.out.println(arrayChairs);
    }

    @FXML public void handleGoBuy_btnOnAction(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("confirmBuy.fxml"));
        Scene scene = new Scene(loader.load());
        Stage a = (Stage) buy_btn.getScene().getWindow();
        a.setScene(scene);
        ConfirmBuyController c = loader.getController();
        c.setAll(username,"theatre 1",movie,round,arrayChairs,"theatre1.fxml",comingfrom,String.valueOf(money),ticketsCheck);
        a.show();

    }

}
