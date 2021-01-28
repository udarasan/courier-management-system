package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import dto.ReturnDetailsDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface ReturnBO extends SuperBO {
    boolean addReturn(ReturnDetailsDTO returnDetails) throws ClassNotFoundException, SQLException;
    ObservableList<ReturnDetailsDTO> getAllReturnDetails() throws ClassNotFoundException, SQLException;
    int getNoOfReturn()throws ClassNotFoundException,SQLException;
    int getDailyReturnCount(String id) throws ClassNotFoundException, SQLException;
    int getMonthlyReturnCount()throws ClassNotFoundException,SQLException;
}
