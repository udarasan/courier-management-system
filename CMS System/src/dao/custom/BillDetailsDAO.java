package dao.custom;

import dao.CrudDAO;
import entity.BillDetails;

import java.sql.SQLException;

public interface BillDetailsDAO extends CrudDAO<BillDetails,String> {
    int getNoBills ()throws ClassNotFoundException, SQLException;
    int getDailyBillCount(String id)throws  ClassNotFoundException,SQLException;
    int getMonthlyBillCount()throws  ClassNotFoundException,SQLException;
    double getDailyIncome(String date)throws ClassNotFoundException,SQLException;
    double getMonthlyIncome()throws ClassNotFoundException,SQLException;
    double getYearlyIncome(String date)throws ClassNotFoundException,SQLException;
}
