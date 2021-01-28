package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;
    public AnchorPane root;
    String getUserName1 = "udara";
    String getPassword1 = "1234";
    String getUserName2 = "shanaya";
    String getPassword2 = "4321";

    public void loginButtonOnAction(ActionEvent actionEvent) throws IOException {
        String userName = txtUserName.getText().trim();
        String password = txtPassword.getText().trim();
        if (userName.length() > 0 && password.length() > 0) {
            if (userName.equalsIgnoreCase(getUserName1)
                    && password.equals(getPassword1)) {
                /*start mLogin */

                Stage window = (Stage) this.root.getScene().getWindow();
                window.setScene(new Scene(FXMLLoader.load(this.getClass()
                        .getResource("/view/DashBoardForm.fxml"))));
                window.centerOnScreen();


            } else if (userName.equalsIgnoreCase(getUserName2)
                    && password.equals(getPassword2)) {
                Stage window = (Stage) this.root.getScene().getWindow();
                window.setScene(new Scene(FXMLLoader.load(this.getClass()
                        .getResource("/view/DashBoardForm.fxml"))));
                window.centerOnScreen();
                /*End mLogin */
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again!",
                        ButtonType.OK).show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING,
                    "User Name Or Password Empty!",
                    ButtonType.OK).show();
        }


    }
}
