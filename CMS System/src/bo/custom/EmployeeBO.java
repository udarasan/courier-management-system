package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import dto.EmployeeDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface EmployeeBO extends SuperBO {

    boolean addEmployee(EmployeeDTO employee) throws ClassNotFoundException, SQLException;

    ObservableList<EmployeeDTO> getAllEmployee() throws ClassNotFoundException, SQLException;

    boolean deleteEmployee(String id) throws ClassNotFoundException, SQLException;

    EmployeeDTO searchEmployee(String id) throws ClassNotFoundException, SQLException;

    boolean updateEmployee(EmployeeDTO employee) throws ClassNotFoundException, SQLException;
}
