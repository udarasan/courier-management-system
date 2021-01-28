package bo.custom.impl;

import bo.custom.MessageBO;
import dao.DAOFactory;
import dao.custom.MessageDAO;
import dto.CustomerDTO;
import dto.MessageDTO;
import entity.Customer;
import entity.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class MessageBOImpl implements MessageBO {

    MessageDAO messageDAO= (MessageDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MESSAGE);


    @Override
    public String getMessage() throws ClassNotFoundException, SQLException {
        return messageDAO.getMessage();
    }

    @Override
    public boolean addMessageBox(MessageDTO message) throws ClassNotFoundException, SQLException {
        return messageDAO.add(new Message(message.getMID(),message.getMessage()));
    }

    @Override
    public ObservableList<MessageDTO> getAllMessages() throws ClassNotFoundException, SQLException {
        ObservableList<Message>all=messageDAO.getAll();
        ObservableList<MessageDTO>allMessages=FXCollections.observableArrayList();
        for (Message m : all){
            allMessages.add(new MessageDTO(m.getMID(),m.getMessage()));
        }
        return allMessages;
    }

    @Override
    public int getNoOfMessages() throws ClassNotFoundException, SQLException {
        return messageDAO.getNoMessages();
    }
}
