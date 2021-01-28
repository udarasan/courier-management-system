package bo;

import bo.custom.impl.*;

public class BOFactory {
    public static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public enum BOTypes {
        CUSTOMER, RETURN, PO, DELIVERY, MESSAGE, EMPLOYEE, BILL

    }

    public SuperBO getBO(BOTypes boTypes) {
        switch (boTypes) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case RETURN:
                return new ReturnBOImpl();
            case PO:
                return new PlaceOrderBOImpl();
            case DELIVERY:
                return new DeliveryDetailsBOImpl();
            case MESSAGE:
                return new MessageBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case BILL:
                return new BillDetailsBOImpl();

            default:
                return null;
        }
    }

}
