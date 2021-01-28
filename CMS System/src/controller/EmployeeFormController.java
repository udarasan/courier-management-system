package controller;

import bo.BOFactory;
import bo.custom.EmployeeBO;
import com.jfoenix.controls.JFXTextField;
import dto.EmployeeDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class EmployeeFormController {


    public TableColumn colEID;
    public TableColumn colFName;
    public TableColumn colSName;
    public TableColumn colTP;
    public TableColumn colAddress;
    public TableColumn colEmail;
    public JFXTextField txtEID;
    public JFXTextField txtFirstName;
    public JFXTextField txtSecondName;
    public JFXTextField txtTelephoneNo;
    public JFXTextField txtAddress;
    public JFXTextField txtEmail;
    public TableView tblEmp;
    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.EMPLOYEE);

    public void initialize() throws SQLException, ClassNotFoundException {
        loadAllEmployee();
        colEID.setCellValueFactory(new PropertyValueFactory<>("eid"));
        colFName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colSName.setCellValueFactory(new PropertyValueFactory<>("secondName"));
        colTP.setCellValueFactory(new PropertyValueFactory<>("telephoneNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));


    }

    public void loadAllEmployee() throws SQLException, ClassNotFoundException {

        ObservableList<EmployeeDTO> allCustomers = employeeBO.getAllEmployee();
        tblEmp.setItems(allCustomers);


    }

    public void saveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String eid = txtEID.getText();
        String fName = txtFirstName.getText();
        String sName = txtSecondName.getText();
        String tp = txtTelephoneNo.getText();
        String address = txtAddress.getText();
        String email = txtEmail.getText();

        EmployeeDTO newEmployee = new EmployeeDTO(eid, fName, sName, tp, address, email);
        try {
            boolean isAdded = employeeBO.addEmployee(newEmployee);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Emplyoee Is Added!", ButtonType.OK).show();
                loadAllEmployee();
            }
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, "Emplyoee Is Added Fail!", ButtonType.OK).show();
            loadAllEmployee();
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void updateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String eid = txtEID.getText();
        String fName = txtFirstName.getText();
        String sName = txtSecondName.getText();
        String tp = txtTelephoneNo.getText();
        String address = txtAddress.getText();
        String email = txtEmail.getText();

        EmployeeDTO employeeDTO = new EmployeeDTO(eid, fName, sName, tp, address, email);
        try {
            boolean isAdded = employeeBO.updateEmployee(employeeDTO);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Update Completed!", ButtonType.OK).show();
                loadAllEmployee();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Update Is Not Completed!", ButtonType.OK).show();
            loadAllEmployee();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public void deleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String eid = txtEID.getText();
        try {
            boolean isDeleted = employeeBO.deleteEmployee(eid);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Removed Employee", ButtonType.OK).show();
                loadAllEmployee();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Try Again!", ButtonType.OK).show();
            loadAllEmployee();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public void txtEmailOnAction(ActionEvent actionEvent) {
    }


    public void rowOnAction(MouseEvent mouseEvent) {
        EmployeeDTO employeeDTO = (EmployeeDTO) tblEmp.getSelectionModel().getSelectedItem();
        txtEID.setText(employeeDTO.getEid());
        txtFirstName.setText(employeeDTO.getFirstName());
        txtSecondName.setText(employeeDTO.getSecondName());
        txtTelephoneNo.setText(employeeDTO.getTelephoneNo());
        txtAddress.setText(employeeDTO.getAddress());
        txtEmail.setText(employeeDTO.getEmail());
    }


    public void eidOnAction(ActionEvent actionEvent) {
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


}
