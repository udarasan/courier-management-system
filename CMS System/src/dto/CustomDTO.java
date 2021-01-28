package dto;

public class CustomDTO {
    private String BID;
    private String CID;
    private String itemType;
    private String paymentType;
    private double rates;
    private String todayDate;
    private String DID;
    private String dFirstName;
    private String dSecondName;
    private String dTelephoneNO;
    private String dAddress;
    private String dueDate;
    private String orderAction;

    public CustomDTO() {
    }

    public CustomDTO(String BID, String CID,String itemType,String paymentType, double rates, String todayDate, String DID, String dFirstName, String dSecondName, String dTelephoneNO, String dAddress, String dueDate, String orderAction) {
        this.setBID(BID);
        this.setCID(CID);
        this.setPaymentType(paymentType);
        this.setRates(rates);
        this.setTodayDate(todayDate);
        this.setItemType(itemType);
        this.setDID(DID);
        this.setdFirstName(dFirstName);
        this.setdSecondName(dSecondName);
        this.setdTelephoneNO(dTelephoneNO);
        this.setdAddress(dAddress);
        this.setDueDate(dueDate);
        this.setOrderAction(orderAction);
    }

    public String getBID() {
        return BID;
    }

    public void setBID(String BID) {
        this.BID = BID;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getRates() {
        return rates;
    }

    public void setRates(double rates) {
        this.rates = rates;
    }

    public String getTodayDate() {
        return todayDate;
    }

    public void setTodayDate(String todayDate) {
        this.todayDate = todayDate;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getDID() {
        return DID;
    }

    public void setDID(String DID) {
        this.DID = DID;
    }

    public String getdFirstName() {
        return dFirstName;
    }

    public void setdFirstName(String dFirstName) {
        this.dFirstName = dFirstName;
    }

    public String getdSecondName() {
        return dSecondName;
    }

    public void setdSecondName(String dSecondName) {
        this.dSecondName = dSecondName;
    }

    public String getdTelephoneNO() {
        return dTelephoneNO;
    }

    public void setdTelephoneNO(String dTelephoneNO) {
        this.dTelephoneNO = dTelephoneNO;
    }

    public String getdAddress() {
        return dAddress;
    }

    public void setdAddress(String dAddress) {
        this.dAddress = dAddress;
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
