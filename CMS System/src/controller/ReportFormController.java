package controller;

import bo.BOFactory;
import bo.custom.BillDetailsBO;
import bo.custom.ReturnBO;
import dao.custom.BillDetailsDAO;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportFormController {
    public Label lblDailyIncome;
    public Label lblMonthlyIncome;
    public Label lblYearlyIncome;
    public Label lblMonthlyOrderCount;
    public Label lblMonthlyReturnCount;
    String date=LocalDate.now().toString();

    BillDetailsBO billDetailsBO= (BillDetailsBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.BILL);
    ReturnBO returnBO= (ReturnBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RETURN);

    public void initialize(){
        setValueToLabels();
    }

    public void setValueToLabels(){
        try {
            lblDailyIncome.setText(String.valueOf(billDetailsBO.getDailyIncome(date))+"0");
            lblMonthlyIncome.setText(String.valueOf(billDetailsBO.getMonthlyIncome())+"0");
            lblYearlyIncome.setText(String.valueOf(billDetailsBO.getYearlyIncome(date))+"0");
            lblMonthlyOrderCount.setText("0"+String.valueOf(billDetailsBO.getMonthlyBillCount()));
            lblMonthlyReturnCount.setText("0"+String.valueOf(returnBO.getMonthlyReturnCount()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
