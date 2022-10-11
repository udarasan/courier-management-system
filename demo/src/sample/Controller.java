package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    public TextField textInput1;
    public Label lable1;

    public void changeTxt(ActionEvent actionEvent) {
        String text=textInput1.getText();
        lable1.setText(text);
    }
}
