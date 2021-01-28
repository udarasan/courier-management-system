package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import entity.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean add(Customer c) throws ClassNotFoundException,SQLException {
        String sql = "INSERT INTO CUSTOMER VALUES(?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql, c.getCid(), c.getFirstName(), c.getSecondName(), c.getTelephoneNo(), c.getAddress(), c.getEmail());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        String sql = "delete from Customer where cid=?";
        return CrudUtil.executeUpdate(sql,id);
    }

    @Override
    public boolean update(Customer c) throws ClassNotFoundException, SQLException {
        String sql = "update Customer set FirstName=?,SecondName=?,TelephoneNO=?,Address=?,Email=? where CID=?";
        return CrudUtil.executeUpdate(sql,c.getFirstName(),c.getSecondName(),c.getTelephoneNo(),c.getAddress(),c.getEmail(),c.getCid());
    }

    @Override
    public Customer search(String id) throws ClassNotFoundException, SQLException {
        String sql = "select * from Customer where cid=?";
        ResultSet rst = CrudUtil.executeQuery(sql, id);
        if (rst.next()) {
            return new Customer(rst.getString(1),rst.getString(2),rst.getString(3),
                    rst.getString(4),rst.getString(5),rst.getString(6));
        }
        return null;
    }

    @Override
    public ObservableList<Customer> getAll() throws ClassNotFoundException,SQLException {
        String SQL = "SELECT * FROM Customer";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        ObservableList<Customer>all = FXCollections.observableArrayList();
        while (rst.next()){
            all.add(new Customer(rst.getString("cid"),rst.getString("firstName"),
                    rst.getString("secondName"),rst.getString("telephoneNo"),
                    rst.getString("address"),rst.getString("email")));
        }
        return all;
    }


    @Override
    public int getNoOfCustomers() throws ClassNotFoundException, SQLException {
        return 0;
    }
}
