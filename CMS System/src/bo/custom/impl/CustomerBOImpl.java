package bo.custom.impl;

import bo.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO= (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO dto) throws ClassNotFoundException,SQLException {
        return customerDAO.add(new Customer(dto.getCid(), dto.getFirstName(), dto.getSecondName(),
                dto.getTelephoneNo(), dto.getAddress(), dto.getEmail()));
    }

    @Override
    public ObservableList<CustomerDTO> getAllCustomers() throws ClassNotFoundException, SQLException {
        ObservableList<Customer>all=customerDAO.getAll();
        ObservableList<CustomerDTO>allCustomers=FXCollections.observableArrayList();
        for (Customer c : all){
            allCustomers.add(new CustomerDTO(c.getCid(),c.getFirstName(),c.getSecondName(),
                    c.getTelephoneNo(),c.getAddress(),c.getEmail()));
        }
        return allCustomers;
    }

    @Override
    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException{
        return customerDAO.delete(id);
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws ClassNotFoundException, SQLException {
        Customer search = customerDAO.search(id);
        return new CustomerDTO(search.getCid(),search.getFirstName(),search.getSecondName(),
                search.getTelephoneNo(),search.getAddress(),search.getEmail());
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws ClassNotFoundException, SQLException {
        return customerDAO.update(new Customer(dto.getCid(),dto.getFirstName(),dto.getSecondName(),
                dto.getTelephoneNo(),dto.getAddress(),dto.getEmail()));
    }


}
