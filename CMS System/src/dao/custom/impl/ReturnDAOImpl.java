package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ReturnDAO;
import entity.Customer;
import entity.ReturnDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReturnDAOImpl implements ReturnDAO {
    @Override
    public boolean add(ReturnDetails r) throws ClassNotFoundException, SQLException {
        String sql="Insert Into ReturnDetails Values(?,?,?,?)";
        return CrudUtil.executeUpdate(sql,r.getRID(),r.getBID(),r.getReason(),r.getReturnDate());
    }

    @Override
    public boolean delete(String s) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(ReturnDetails r) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public ReturnDetails search(String s) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ObservableList<ReturnDetails> getAll() throws ClassNotFoundException, SQLException {
        String SQL = "SELECT * FROM Returndetails";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        ObservableList<ReturnDetails>all = FXCollections.observableArrayList();
        while (rst.next()){
            all.add(new ReturnDetails(rst.getString("RID"),rst.getString("BID"),rst.getString("reason"),rst.getString("returnDate")));
        }
        return all;
    }

    @Override
    public int getNoOfReturn() throws ClassNotFoundException, SQLException {
        String SQL = "SELECT COUNT(rid) FROM Returndetails";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        if (rst.next()){
            return rst.getInt(1);
        }
        return -1;
    }

    @Override
    public int getDailyReturnCount(String id) throws ClassNotFoundException, SQLException {
        String sql="SELECT COUNT(RID) FROM ReturnDetails where ReturnDate=?";
        ResultSet rst=CrudUtil.executeQuery(sql,id);
        if (rst.next()){
            return rst.getInt(1);
        }
        return -1;
    }

    @Override
    public int getMonthlyReturnCount() throws ClassNotFoundException, SQLException {
        String sql="SELECT COUNT(RID) FROM Returndetails WHERE returnDate BETWEEN '2020-10-01' AND '2020-10-30';";
        ResultSet rst=CrudUtil.executeQuery(sql);
        if (rst.next()){
            return rst.getInt(1);
        }
        return -1;
    }
}
