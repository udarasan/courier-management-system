package dao.custom;

import dao.CrudDAO;
import entity.ReturnDetails;

import java.sql.SQLException;

public interface ReturnDAO extends CrudDAO<ReturnDetails,String> {
    int getNoOfReturn()throws ClassNotFoundException, SQLException;
    int getDailyReturnCount(String id)throws ClassNotFoundException,SQLException;
    int getMonthlyReturnCount()throws ClassNotFoundException,SQLException;
}
