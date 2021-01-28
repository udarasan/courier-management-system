package controller;

import bo.BOFactory;
import bo.custom.CustomerBO;
import bo.custom.PlaceOrderBO;
import com.jfoenix.controls.JFXComboBox;
import db.DBConnection;
import dto.CustomDTO;
import dto.CustomerDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class OrderFormController {
    public JFXComboBox cmbCID;
    public TextField txtItemType;
    public TextField txtWeight;
    public TextField txtHeight;
    public TextField txtWidth;
    public TextField txtLength;
    public TextField txtBillNumber;
    public TextField txtAmount;
    public TextField txtCustomerName;
    public TextField txtDID;
    public TextField txtFirstName;
    public TextField txtSecondName;
    public TextField txtTelephoneNo;
    public TextField txtAddress;
    public DatePicker txtDate;
    public TextField cmbPaymentType;
    public TextField cmbOrderAction;
    public ComboBox cmbPType;
    public ComboBox cmbPayType;
    public AnchorPane root;
    CustomerBO customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
    PlaceOrderBO placeOrderBO = (PlaceOrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PO);


    public void generateBID() {
        try {
            int count = placeOrderBO.getNoOfBills();
            if (count == 0) {
                txtBillNumber.setText("B001");
            }
            if (count > 0 && count <= 8) {
                txtBillNumber.setText("B00" + (count + 1));
            }
            if (count >= 9 && count <= 98) {
                txtBillNumber.setText("B0" + (count + 1));
            }
            if (count >= 99) {
                txtBillNumber.setText("B" + (count + 1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void generateDID() {
        try {
            int count = placeOrderBO.getNoOfDeliveries();
            if (count == 0) {
                txtDID.setText("D001");
            }
            if (count > 0 && count <= 8) {
                txtDID.setText("D00" + (count + 1));
            }
            if (count >= 9 && count <= 98) {
                txtDID.setText("D0" + (count + 1));
            }
            if (count >= 99) {
                txtDID.setText("D" + (count + 1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void newCustomerOnAction(ActionEvent actionEvent) throws IOException {
        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.
                load(this.getClass().
                        getResource("/view/CustomerForm.fxml")));


    }

    public void calculateRateOnAction(ActionEvent actionEvent) {
        double weight = Double.parseDouble(txtWeight.getText());
        double height = Double.parseDouble(txtHeight.getText());
        double width = Double.parseDouble(txtWidth.getText());
        double length = Double.parseDouble(txtLength.getText());

        double area = width * height * length;
        //CALCULATE AMOUNT
        if (weight < 1) {
            if (area < 125000) {
                txtAmount.setText(String.valueOf(250.00));
            } else {
                txtAmount.setText(String.valueOf(300.00));
            }
        } else if (weight >= 1 && weight < 2) {
            if (area < 125000) {
                txtAmount.setText(String.valueOf(350.00));
            } else {
                txtAmount.setText(String.valueOf(400.00));
            }
        } else if (weight >= 2 && weight < 3) {
            if (area < 125000) {
                txtAmount.setText(String.valueOf(450.00));
            } else {
                txtAmount.setText(String.valueOf(500.00));
            }
        } else if (weight >= 3 && weight < 4) {
            if (area < 125000) {
                txtAmount.setText(String.valueOf(550.00));
            } else {
                txtAmount.setText(String.valueOf(600.00));
            }
        } else if (weight >= 4 && weight < 5) {
            if (area < 125000) {
                txtAmount.setText(String.valueOf(650.00));
            } else {
                txtAmount.setText(String.valueOf(700.00));
            }
        } else if (weight >= 5 && weight < 6) {
            if (area < 125000) {
                txtAmount.setText(String.valueOf(750.00));
            } else {
                txtAmount.setText(String.valueOf(800.00));
            }
        }
    }

    public void placeOrderOnAction(ActionEvent actionEvent) {
        //bill details
        String cid = cmbCID.getSelectionModel().getSelectedItem().toString();
        String bid = txtBillNumber.getText();
        String itemType = cmbPType.getSelectionModel().getSelectedItem().toString();
        String paymentType = cmbPayType.getSelectionModel().getSelectedItem().toString();
        double rates = Double.parseDouble(txtAmount.getText());
        String todayDate = LocalDate.now().toString();


        //delivery details
        String did = txtDID.getText();
        String fName = txtFirstName.getText();
        String sName = txtSecondName.getText();
        String telephoneNo = txtTelephoneNo.getText();
        String address = txtAddress.getText();
        String dueDate = txtDate.getValue().format(DateTimeFormatter.BASIC_ISO_DATE);
        String orderAction = cmbOrderAction.getText();

        CustomDTO dto = new CustomDTO(bid, cid, itemType, paymentType, rates, todayDate, did, fName, sName, telephoneNo, address, dueDate, orderAction);
        //BillDetailsDTO bDTO=new BillDetailsDTO(bid, cid, itemType, rates, paymentType);
        //DeliveryDetailsDTO dDTO=new DeliveryDetailsDTO(bid,did, fName, sName, telephoneNo, address, dueDate, orderAction);
        try {
            boolean isAdded = placeOrderBO.placeOrder(dto);//dto
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Order placed!", ButtonType.OK).show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Try Again !", ButtonType.OK).show();

        }


    }

    public void selectCIDOnAction(ActionEvent actionEvent) {
        try {
            CustomerDTO sDTO = customerBO.searchCustomer(cmbCID.getSelectionModel().getSelectedItem().toString());
            if (sDTO != null) {
                txtCustomerName.setText(sDTO.getFirstName());
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {

        }

    }

    public void setValuesToCmbCID() {
        try {
            ObservableList<CustomerDTO> customerList = customerBO.getAllCustomers();
            for (CustomerDTO c : customerList) {
                cmbCID.getItems().add(c.getCid());
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void setValuesToCMBItemType() {
        cmbPType.getItems().add("Electronic");
        cmbPType.getItems().add("Books");
        cmbPType.getItems().add("Glass");
        cmbPType.getItems().add("Computers");
        cmbPType.getItems().add("Mobile");

    }

    public void setValuesToCMBPayType() {
        cmbPayType.getItems().add("Cash");
        cmbPayType.getItems().add("Card");
        cmbPayType.getItems().add("Bank Transfer");
        cmbPayType.getItems().add("EzCash");

    }

    public void initialize() {
        setValuesToCMBPayType();
        generateDID();
        generateBID();
        setValuesToCmbCID();
        setValuesToCMBItemType();
    }


    public void printOnAction(ActionEvent actionEvent) {
        try {
            InputStream is=this.getClass().getResourceAsStream("/report/yu.jrxml");
            JasperReport jr=JasperCompileManager.compileReport(is);

            HashMap hs=new HashMap();
            hs.put("BID",txtBillNumber.getText());
            hs.put("FirstName",txtFirstName.getText());
            hs.put("Address",txtAddress.getText());
            hs.put("TP",txtTelephoneNo.getText());
            hs.put("Date",txtDate.getValue().format(DateTimeFormatter.BASIC_ISO_DATE));
            hs.put("CusName",txtCustomerName.getText());
            hs.put("CusID",cmbCID.getSelectionModel().getSelectedItem().toString());
            hs.put("ItemType",txtItemType.getText());
            hs.put("PayType",cmbPType.getSelectionModel().getSelectedItem().toString());
            hs.put("Amount",txtAmount.getText());


            JasperPrint jp=JasperFillManager.fillReport(jr,hs,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jp);

        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
