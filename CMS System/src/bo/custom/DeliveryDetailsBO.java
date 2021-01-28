package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import dto.DeliveryDetailsDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface DeliveryDetailsBO extends SuperBO {
    ObservableList<DeliveryDetailsDTO> getAllDeliveryDetails() throws ClassNotFoundException, SQLException;

    DeliveryDetailsDTO searchDeliveryDetails(String id) throws ClassNotFoundException, SQLException;

    boolean updateDeliveryDetails(DeliveryDetailsDTO deliveryDetails) throws ClassNotFoundException, SQLException;
}
