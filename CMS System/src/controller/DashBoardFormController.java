package controller;

import bo.BOFactory;
import bo.custom.MessageBO;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DashBoardFormController {

    public Pane context;
    public JFXTextField txtDate;
    public JFXTextField txtTime;
    public Text txtMessageArea;
    public AnchorPane dashBordRoot;
    MessageBO messageBO= (MessageBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.MESSAGE);

    public void loadDailyMessages() throws SQLException, ClassNotFoundException {
        txtMessageArea.setText(messageBO.getMessage());


    }

    public void initialize() throws IOException, SQLException, ClassNotFoundException {
        loadDailyMessages();
        generateDateTime();
        loadDefault();

    }
    public void generateDateTime(){
        txtDate.setText(LocalDate.now().toString());
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e->{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
            txtTime.setText(LocalDateTime.now().format(formatter));
        }),new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void loadDefault() throws IOException {
        setUi("DefaultForm");
    }

    private void setUi(String location) throws IOException {
        context.getChildren().clear();
        context.getChildren().add(FXMLLoader.
                load(this.getClass().
                        getResource("/view/" + location +
                                ".fxml")));
    }

    public void dashBoardOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DefaultForm");
    }

    public void customerOnAction(ActionEvent actionEvent) throws IOException {
        setUi("CustomerForm");
    }

    public void ordersOnAction(ActionEvent actionEvent) throws IOException {
        setUi("OrderForm");
    }

    public void returnOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ReturnForm");
    }

    public void reportsOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ReportForm");
    }

    public void deliveryOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DeliveryForm");
    }

    public void trackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("TrackingFrom");
    }

    public void employeeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("EmployeeForm");
    }

    public void msgOnAction(ActionEvent actionEvent) throws IOException {
        setUi("MessageForm");
    }
    public void logOutOnAction(MouseEvent mouseEvent) throws IOException {
        Stage window = (Stage) this.dashBordRoot.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(this.getClass()
                .getResource("/view/MainForm.fxml"))));
        window.centerOnScreen();
    }


}
