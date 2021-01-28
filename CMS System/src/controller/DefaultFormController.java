package controller;

import bo.BOFactory;
import bo.custom.BillDetailsBO;
import bo.custom.DeliveryDetailsBO;
import bo.custom.ReturnBO;
import dto.DeliveryDetailsDTO;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.time.LocalDate;

public class DefaultFormController {
    public TableView tblOrderDetails;
    public TableColumn colDueDate;
    public TableColumn colBID;
    public TableColumn colDID;
    public TableColumn colProcessUpdate;
    public TableColumn colaAddress;
    public Label lblIncome;
    public Label lblReturnCount;
    public Label lblBillCount;

    DeliveryDetailsBO deliveryDetailsBO= (DeliveryDetailsBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.DELIVERY);
    BillDetailsBO billDetailsBO= (BillDetailsBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.BILL);
    ReturnBO returnBO= (ReturnBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RETURN);
    String date= LocalDate.now().toString();

    public void initialize(){
        loadDeliveryDetails();
        setCountToReturnCount();
        setCountTODailyBillCounts();
        setDailyIncome();
        colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        colBID.setCellValueFactory(new PropertyValueFactory<>("BID"));
        colDID.setCellValueFactory(new PropertyValueFactory<>("DID"));
        colaAddress.setCellValueFactory(new PropertyValueFactory<>("dAddress"));
        colProcessUpdate.setCellValueFactory(new PropertyValueFactory<>("orderAction"));



    }
    public void setDailyIncome(){
        try {
            lblIncome.setText(String.valueOf(billDetailsBO.getDailyIncome(date))+"0");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void setCountToReturnCount(){
        try {
            lblReturnCount.setText("00"+String.valueOf(returnBO.getDailyReturnCount(date)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void setCountTODailyBillCounts(){
        try {
            lblBillCount.setText("00"+String.valueOf(billDetailsBO.getDailyBillCount(date)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private void loadDeliveryDetails() {
        try {
            ObservableList<DeliveryDetailsDTO>allDeliveryDetails=deliveryDetailsBO.getAllDeliveryDetails();
            tblOrderDetails.setItems(allDeliveryDetails);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
