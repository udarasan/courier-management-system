package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.EmployeeDAO;
import entity.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean add(Employee e) throws ClassNotFoundException, SQLException {
        String sql="Insert into Employee Values(?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,e.getEid(),e.getFirstName(),e.getSecondName(),e.getTelephoneNo(),e.getAddress(),e.getEmail());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        String sql="delete from employee where eid=?";
        return CrudUtil.executeUpdate(sql,id);
    }

    @Override
    public boolean update(Employee e) throws ClassNotFoundException, SQLException {
        String sql="update Employee set FirstName=?,SecondName=?,TelephoneNO=?,Address=?,Email=? where EID=?";
        return CrudUtil.executeUpdate(sql,e.getFirstName(),e.getSecondName(),e.getTelephoneNo(),e.getAddress(),e.getEmail(),e.getEid());
    }

    @Override
    public Employee search(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ObservableList<Employee> getAll() throws ClassNotFoundException, SQLException {
        String sql="select * from employee";
        ResultSet rst=CrudUtil.executeQuery(sql);
        ObservableList<Employee>all = FXCollections.observableArrayList();
        while (rst.next()){
            all.add(new Employee(rst.getString("EID"),rst.getString("FirstName"),
                    rst.getString("SecondName"),rst.getString("TelephoneNO"),
                    rst.getString("Address"),rst.getString("Email")));

        }
        return all;
    }
}
