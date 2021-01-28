package dao;

import dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes {
        CUSTOMER, RETURN, BILL, DELIVERY, MESSAGE, EMPLOYEE
    }

    public SuperDAO getDAO(DAOTypes daoTypes) {
        switch (daoTypes) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case RETURN:
                return new ReturnDAOImpl();
            case BILL:
                return new BillDetailsDAOImpl();
            case DELIVERY:
                return new DeliveryDetailsDAOImpl();
            case MESSAGE:
                return new MessageDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            default:
                return null;
        }
    }
}
