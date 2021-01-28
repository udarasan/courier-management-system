package dto;

public class BillDetailsDTO {
    private String BID;
    private String CID;
    private String itemType;
    private String paymentType;
    private double rates;
    private String todayDate;

    public BillDetailsDTO() {
    }

    public BillDetailsDTO(String BID, String CID, String itemType, String paymentType, double rates, String todayDate) {
        this.setBID(BID);
        this.setCID(CID);
        this.setItemType(itemType);
        this.setPaymentType(paymentType);
        this.setRates(rates);
        this.setTodayDate(todayDate);
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

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
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
}