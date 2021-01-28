package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.BillDetailsDAO;
import entity.BillDetails;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillDetailsDAOImpl implements BillDetailsDAO {
    @Override
    public boolean add(BillDetails b) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO BillDetails VALUES(?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql, b.getBID(), b.getCID(), b.getItemType(), b.getPaymentType(), b.getRates(), b.getTodayDate());
    }

    @Override
    public boolean delete(String s) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(BillDetails b) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public BillDetails search(String s) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ObservableList<BillDetails> getAll() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public int getNoBills() throws ClassNotFoundException, SQLException {
        String SQL = "SELECT COUNT(bid) FROM billDetails";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        if (rst.next()) {
            return rst.getInt(1);
        }
        return -1;
    }

    @Override
    public int getDailyBillCount(String id) throws ClassNotFoundException, SQLException {
        String SQL = "SELECT COUNT(BID) FROM BillDetails where TodayDate=?";
        ResultSet rst = CrudUtil.executeQuery(SQL,id);
        if (rst.next()){
            return rst.getInt(1);
        }
        return -1;
    }

    @Override
    public int getMonthlyBillCount() throws ClassNotFoundException, SQLException {
        String SQL = "SELECT COUNT(Rates) FROM BillDetails WHERE TodayDate BETWEEN '2020-10-01' AND '2020-10-30';";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        if (rst.next()){
            return rst.getInt(1);
        }
        return -1;
    }

    @Override
    public double getDailyIncome(String date) throws ClassNotFoundException, SQLException {
        String sql="SELECT SUM(Rates) FROM BillDetails WHERE TodayDate =?;";
        ResultSet rst=CrudUtil.executeQuery(sql,date);
        if (rst.next()){
            return rst.getDouble(1);
        }
        return -1;
    }

    @Override
    public double getMonthlyIncome() throws ClassNotFoundException, SQLException {
        String sql="SELECT SUM(Rates) FROM BillDetails WHERE MONTH(TodayDate);";
        ResultSet rst=CrudUtil.executeQuery(sql);
        if (rst.next()){
            return rst.getDouble(1);
        }
        return -1;

    }

    @Override
    public double getYearlyIncome(String date) throws ClassNotFoundException, SQLException {
        String sql="SELECT SUM(Rates) FROM BillDetails WHERE YEAR(TodayDate) =?;";
        ResultSet rst=CrudUtil.executeQuery(sql,date);
        if (rst.next()){
            return rst.getDouble(1);
        }
        return -1;
    }

}
