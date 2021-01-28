package bo.custom.impl;

import bo.custom.PlaceOrderBO;

import dao.DAOFactory;
import dao.custom.BillDetailsDAO;
import dao.custom.CustomerDAO;
import dao.custom.DeliveryDetailsDAO;
import db.DBConnection;
import dto.BillDetailsDTO;
import dto.CustomDTO;
import dto.DeliveryDetailsDTO;
import entity.BillDetails;
import entity.DeliveryDetails;

import java.sql.Connection;
import java.sql.SQLException;


public class PlaceOrderBOImpl implements PlaceOrderBO {


    BillDetailsDAO billDetailsDAO = (BillDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BILL);
    DeliveryDetailsDAO deliveryDetailsDAO = (DeliveryDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DELIVERY);


    @Override
    public boolean placeOrder(CustomDTO dto) throws ClassNotFoundException, SQLException, Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            BillDetails billDetails = new BillDetails(dto.getBID(),dto.getCID(),dto.getItemType(),dto.getPaymentType(),dto.getRates(),dto.getTodayDate());
            boolean add = billDetailsDAO.add(billDetails);

            if (add) {
                DeliveryDetails deliveryDetails = new DeliveryDetails(dto.getDID(), dto.getBID(),
                        dto.getdFirstName(), dto.getdSecondName(), dto.getdTelephoneNO(), dto.getdAddress(),
                        dto.getDueDate(), dto.getOrderAction());
                boolean response = deliveryDetailsDAO.add(deliveryDetails);
                if (response) {
                    connection.setAutoCommit(true);
                    return true;
                } else {
                    connection.rollback();
                    return false;

                }

            } else {
                connection.rollback();
                return false;
            }
        } finally {
            connection.setAutoCommit(true);
        }


    }

    @Override
    public int getNoOfBills() throws ClassNotFoundException, SQLException {
        return billDetailsDAO.getNoBills();
    }

    @Override
    public int getNoOfDeliveries() throws ClassNotFoundException, SQLException {
        return deliveryDetailsDAO.getNoOfDeliveries();
    }
}
