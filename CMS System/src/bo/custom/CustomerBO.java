package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface CustomerBO extends SuperBO {
    boolean addCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException;

    ObservableList<CustomerDTO> getAllCustomers() throws ClassNotFoundException, SQLException;

    boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException;

    CustomerDTO searchCustomer(String id) throws ClassNotFoundException, SQLException;

    boolean updateCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException;
}
