package controller;

import bo.BOFactory;
import bo.custom.ReturnBO;
import dto.ReturnDetailsDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class ReturnFormController {
    public TextField txtRID;
    public TextField txtOID;
    public DatePicker txtDate;
    public TextField txtReason;
    public TableView returnTable;
    public TableColumn colRID;
    public TableColumn colBID;
    public TableColumn colReason;
    public TableColumn colReturnDate;

    ReturnBO returnBO= (ReturnBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RETURN);

    public void generateRID(){
        try {
            int count=returnBO.getNoOfReturn();
            if (count==0){
                txtRID.setText("R001");
            }
            if (count>0 && count<=8){
                txtRID.setText("R00"+(count+1));
            }
            if (count>=9 && count<=98){
                txtRID.setText("R0"+(count+1));
            }
            if (count>=99){
                txtRID.setText("R"+(count+1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void reportOnAction(ActionEvent actionEvent) {
        String bid=txtOID.getText();
        String date=txtDate.getValue().format(DateTimeFormatter.BASIC_ISO_DATE);
        String rid=txtRID.getText();
        String reason=txtReason.getText();
        ReturnDetailsDTO newReturnDetails=new ReturnDetailsDTO(rid,bid,reason,date);
        try {
            boolean isAdded=returnBO.addReturn(newReturnDetails);
            loadAllReturn();
            if (isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Return Is Accepted!", ButtonType.OK).show();
                loadAllReturn();
            }
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR,"Return Is Not Accepted!", ButtonType.OK).show();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void initialize() throws SQLException, ClassNotFoundException {
        generateRID();
        loadAllReturn();
        colRID.setCellValueFactory(new PropertyValueFactory<>("RID"));
        colBID.setCellValueFactory(new PropertyValueFactory<>("BID"));
        colReason.setCellValueFactory(new PropertyValueFactory<>("reason"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));


    }
    public void loadAllReturn() throws SQLException, ClassNotFoundException {
        ObservableList<ReturnDetailsDTO>allReturnDetails=returnBO.getAllReturnDetails();
        returnTable.setItems(allReturnDetails);
    }
}
