package dao.custom;

import dao.CrudDAO;
import entity.DeliveryDetails;

import java.sql.SQLException;

public interface DeliveryDetailsDAO extends CrudDAO<DeliveryDetails,String> {
    int getNoOfDeliveries() throws ClassNotFoundException, SQLException;
}
