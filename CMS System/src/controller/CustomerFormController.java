package controller;

import bo.BOFactory;
import bo.custom.CustomerBO;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import dto.CustomerDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.regex.Pattern;


public class CustomerFormController {

    public TableView tblCustomer;
    public TableColumn colCID;
    public TableColumn colFName;
    public TableColumn colLName;
    public TableColumn colTP;
    public TableColumn colAddress;
    public TableColumn colEmail;
    public Label lblCID;
    public JFXTextField txtCID;
    public JFXTextField txtFirstName;
    public JFXTextField txtSecondName;
    public JFXTextField txtTelephoneNo;
    public JFXTextField txtAddress;
    public JFXTextField txtEmail;


    CustomerBO customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);


    public void saveOnAction(ActionEvent actionEvent) {
        String cid = txtCID.getText();
        String fName = txtFirstName.getText();
        String sName = txtSecondName.getText();
        String telephone = txtTelephoneNo.getText();
        String address = txtAddress.getText();
        String email = txtEmail.getText();

        //VALIDATION CUSTOMER FIELDS-->
        //if (Pattern.compile("^(C0)[0-9]{1,}$").matcher(cid).matches()) {

            CustomerDTO newCustomer = new CustomerDTO(cid, fName, sName, telephone, address, email);
            try {
                boolean isAdded = customerBO.addCustomer(newCustomer);
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Added Successful!", ButtonType.OK).show();
                loadAllCustomer();
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Customer Added Not Successful!", ButtonType.OK).show();
            }

        //} else {
            //txtCID.setFocusColor(Paint.valueOf("red"));
            //txtCID.requestFocus();

       // }


    }

    public void updateOnAction(ActionEvent actionEvent) {
        String cid = txtCID.getText();
        String fName = txtFirstName.getText();
        String sName = txtSecondName.getText();
        String telephone = txtTelephoneNo.getText();
        String address = txtAddress.getText();
        String email = txtEmail.getText();


        CustomerDTO newCustomer = new CustomerDTO(cid, fName, sName, telephone, address, email);
        try {
            boolean isAdded = customerBO.updateCustomer(newCustomer);
            new Alert(Alert.AlertType.CONFIRMATION, "Customer Update Successful!", ButtonType.OK).show();
            loadAllCustomer();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Customer Update Not Successful!", ButtonType.OK).show();
        }


    }

    public void deleteOnAction(ActionEvent actionEvent) {
        String cid = txtCID.getText();
        try {
            boolean deleteCustomer = customerBO.deleteCustomer(cid);
            new Alert(Alert.AlertType.CONFIRMATION, "Delete Is Ok", ButtonType.OK).show();
            loadAllCustomer();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.CONFIRMATION, "Delete Not Ok", ButtonType.OK).show();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void loadAllCustomer() throws SQLException, ClassNotFoundException {
        ObservableList<CustomerDTO> allCustomers = customerBO.getAllCustomers();
        tblCustomer.setItems(allCustomers);

    }

    public void rowSelectOnAction(MouseEvent mouseEvent) {
        CustomerDTO customerDTO = (CustomerDTO) tblCustomer.getSelectionModel().getSelectedItem();
        txtCID.setText(customerDTO.getCid());
        txtFirstName.setText(customerDTO.getFirstName());
        txtSecondName.setText(customerDTO.getSecondName());
        txtTelephoneNo.setText(customerDTO.getTelephoneNo());
        txtAddress.setText(customerDTO.getAddress());
        txtEmail.setText(customerDTO.getEmail());
    }

    public void initialize() throws SQLException, ClassNotFoundException {
        loadAllCustomer();
        colCID.setCellValueFactory(new PropertyValueFactory<>("cid"));
        colFName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLName.setCellValueFactory(new PropertyValueFactory<>("secondName"));
        colTP.setCellValueFactory(new PropertyValueFactory<>("telephoneNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));


    }


    public void cidOnAction(ActionEvent actionEvent) {
        txtFirstName.requestFocus();
    }

    public void fNameOnAction(ActionEvent actionEvent) {
        txtSecondName.requestFocus();
    }

    public void sNameOnAction(ActionEvent actionEvent) {
        txtTelephoneNo.requestFocus();
    }

    public void tpOnAction(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }

    public void addressOnAction(ActionEvent actionEvent) {
        txtEmail.requestFocus();
    }

    public void printOnAction(ActionEvent actionEvent) {
        try {
            InputStream is=this.getClass().getResourceAsStream("/report/CR.jrxml");
            JasperReport jr= JasperCompileManager.compileReport(is);
            JasperPrint js= JasperFillManager.fillReport(jr,null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(js);
            //JasperPrintManager.printReport(js,true);
        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    


}
