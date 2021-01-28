package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.DeliveryDetailsDAO;
import entity.Customer;
import entity.DeliveryDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryDetailsDAOImpl implements DeliveryDetailsDAO {
    @Override
    public boolean add(DeliveryDetails d) throws ClassNotFoundException, SQLException {
        String sql="INSERT INTO DeliveryDetails VALUES (?,?,?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,d.getDID(),d.getBID(),d.getDFirstName(),
                d.getDSecondName(),d.getDTelephoneNO(),d.getDAddress(),d.getDueDate(),d.getOrderAction());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(DeliveryDetails d) throws ClassNotFoundException, SQLException {
        String sql = "update DeliveryDetails set BID=?,dFirstName=?,dSecondName=?,dTelephoneNO=?,dAddress=?,DueDate=? ,OrderAction=?  where DID=?";
        return CrudUtil.executeUpdate(sql,d.getBID(),d.getDFirstName(),d.getDSecondName(),d.getDTelephoneNO(),
                d.getDAddress(),d.getDueDate(),d.getOrderAction(),d.getDID());
    }

    @Override
    public DeliveryDetails search(String id) throws ClassNotFoundException, SQLException {
        String sql = "select * from DeliveryDetails where did=?";
        ResultSet rst = CrudUtil.executeQuery(sql, id);
        if (rst.next()) {
            return new DeliveryDetails(rst.getString("DID"),rst.getString("BID"),rst.getString("dFirstName"),
                    rst.getString("dSecondName"),rst.getString("dTelephoneNO"),rst.getString("dAddress"),
                    rst.getString("DueDate"),rst.getString("OrderAction"));
        }
        return null;
    }

    @Override
    public ObservableList<DeliveryDetails> getAll() throws ClassNotFoundException, SQLException {
        String SQL = "SELECT * FROM DeliveryDetails";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        ObservableList<DeliveryDetails>all = FXCollections.observableArrayList();
        while (rst.next()){
            all.add(new DeliveryDetails(rst.getString("DID"),rst.getString("BID"),rst.getString("dFirstName"),
                    rst.getString("dSecondName"),rst.getString("dTelephoneNO"),rst.getString("dAddress"),
                    rst.getString("DueDate"),rst.getString("OrderAction")));

        }
        return all;
    }

    @Override
    public int getNoOfDeliveries() throws ClassNotFoundException, SQLException {
        String SQL = "SELECT COUNT(did) FROM deliveryDetails";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        if (rst.next()){
            return rst.getInt(1);
        }
        return -1;

    }
}
