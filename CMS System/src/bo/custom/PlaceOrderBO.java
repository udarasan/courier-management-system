package bo.custom;

import bo.SuperBO;
import dto.BillDetailsDTO;
import dto.CustomDTO;
import dto.DeliveryDetailsDTO;

import java.sql.SQLException;

public interface PlaceOrderBO extends SuperBO {
    public boolean placeOrder(CustomDTO dto) throws ClassNotFoundException, SQLException, Exception;
    public int getNoOfBills() throws ClassNotFoundException,SQLException;
    public int getNoOfDeliveries()throws ClassNotFoundException,SQLException;
}
