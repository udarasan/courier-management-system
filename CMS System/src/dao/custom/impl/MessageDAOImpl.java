package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.MessageDAO;
import entity.Customer;
import entity.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageDAOImpl implements MessageDAO {
    @Override
    public boolean add(Message message) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO MessageBOX VALUES(?,?)";
        return CrudUtil.executeUpdate(sql,message.getMID(),message.getMessage());
    }

    @Override
    public boolean delete(String s) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(Message message) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public Message search(String s) throws ClassNotFoundException, SQLException {

        return null;
    }

    @Override
    public ObservableList<Message> getAll() throws ClassNotFoundException, SQLException {
        String SQL = "SELECT * FROM messagebox";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        ObservableList<Message>all = FXCollections.observableArrayList();
        while (rst.next()){
            all.add(new Message(rst.getString("msgId"),rst.getString("message")));
        }
        return all;
    }

    @Override
    public String getMessage() throws ClassNotFoundException, SQLException {
        String sql="SELECT Message FROM MessageBox ORDER BY MSGID DESC LIMIT 1";
        ResultSet rst=CrudUtil.executeQuery(sql);
        if (rst.next()){
            return rst.getString(1);
        }
        return null;
    }

    @Override
    public int getNoMessages() throws ClassNotFoundException, SQLException {
        String SQL = "SELECT COUNT(msgID) FROM messageBox";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        if (rst.next()) {
            return rst.getInt(1);
        }
        return -1;
    }
}
