package bo.custom.impl;

import bo.custom.EmployeeBO;
import dao.DAOFactory;
import dao.custom.EmployeeDAO;
import dto.CustomerDTO;
import dto.EmployeeDTO;
import entity.Customer;
import entity.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO= (EmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public boolean addEmployee(EmployeeDTO e) throws ClassNotFoundException, SQLException {
        return employeeDAO.add(new Employee(e.getEid(),e.getFirstName(),e.getSecondName(),e.getTelephoneNo(),e.getAddress(),e.getEmail()));
    }

    @Override
    public ObservableList<EmployeeDTO> getAllEmployee() throws ClassNotFoundException, SQLException {
        ObservableList<Employee>all=employeeDAO.getAll();
        ObservableList<EmployeeDTO>allEmployee= FXCollections.observableArrayList();
        for (Employee e : all){
            allEmployee.add(new EmployeeDTO(e.getEid(),e.getFirstName(),e.getSecondName(),
                    e.getTelephoneNo(),e.getAddress(),e.getEmail()));
        }
        return allEmployee;
    }

    @Override
    public boolean deleteEmployee(String id) throws ClassNotFoundException, SQLException {
        return employeeDAO.delete(id);
    }

    @Override
    public EmployeeDTO searchEmployee(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public boolean updateEmployee(EmployeeDTO e) throws ClassNotFoundException, SQLException {
        return employeeDAO.update(new Employee(e.getEid(),e.getFirstName(),e.getSecondName(),
                e.getTelephoneNo(),e.getAddress(),e.getEmail()));
    }
}
