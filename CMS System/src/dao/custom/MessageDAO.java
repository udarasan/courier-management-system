package dao.custom;

import dao.CrudDAO;
import entity.Message;

import java.sql.SQLException;

public interface MessageDAO extends CrudDAO<Message,String> {
    String getMessage()throws ClassNotFoundException, SQLException;
    int getNoMessages ()throws ClassNotFoundException, SQLException;
}
