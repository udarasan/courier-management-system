package entity;

public class DeliveryDetails {
    private String DID;
    private String BID;
    private String DFirstName;
    private String DSecondName;
    private String DTelephoneNO;
    private String DAddress;
    private String dueDate;
    private String orderAction;

    public DeliveryDetails(String DID, String BID, String DFirstName, String DSecondName, String DTelephoneNO, String DAddress, String dueDate, String orderAction) {
        this.setDID(DID);
        this.setBID(BID);
        this.setDFirstName(DFirstName);
        this.setDSecondName(DSecondName);
        this.setDTelephoneNO(DTelephoneNO);
        this.setDAddress(DAddress);
        this.setDueDate(dueDate);
        this.setOrderAction(orderAction);
    }

    public DeliveryDetails() {

    }

    public String getDID() {
        return DID;
    }

    public void setDID(String DID) {
        this.DID = DID;
    }

    public String getBID() {
        return BID;
    }

    public void setBID(String BID) {
        this.BID = BID;
    }

    public String getDFirstName() {
        return DFirstName;
    }

    public void setDFirstName(String DFirstName) {
        this.DFirstName = DFirstName;
    }

    public String getDSecondName() {
        return DSecondName;
    }

    public void setDSecondName(String DSecondName) {
        this.DSecondName = DSecondName;
    }

    public String getDTelephoneNO() {
        return DTelephoneNO;
    }

    public void setDTelephoneNO(String DTelephoneNO) {
        this.DTelephoneNO = DTelephoneNO;
    }

    public String getDAddress() {
        return DAddress;
    }

    public void setDAddress(String DAddress) {
        this.DAddress = DAddress;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getOrderAction() {
        return orderAction;
    }

    public void setOrderAction(String orderAction) {
        this.orderAction = orderAction;
    }
}
