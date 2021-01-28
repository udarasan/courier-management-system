package bo.custom;

import bo.SuperBO;

import java.sql.SQLException;

public interface BillDetailsBO extends SuperBO {
    public int getDailyBillCount(String id)throws ClassNotFoundException, SQLException;
    public double getDailyIncome(String date) throws ClassNotFoundException, SQLException;
    public double getYearlyIncome(String date) throws ClassNotFoundException, SQLException;
    public int getMonthlyBillCount() throws ClassNotFoundException, SQLException;
    public double getMonthlyIncome()throws ClassNotFoundException, SQLException;
}
