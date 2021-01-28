package dto;

public class ReturnDetailsDTO {
    private String RID;
    private String BID;
    private String reason;
    private String returnDate;

    public ReturnDetailsDTO() {
    }

    public ReturnDetailsDTO(String RID, String BID, String reason, String returnDate) {
        this.setRID(RID);
        this.setBID(BID);
        this.setReason(reason);
        this.setReturnDate(returnDate);
    }

    public String getRID() {
        return RID;
    }

    public void setRID(String RID) {
        this.RID = RID;
    }

    public String getBID() {
        return BID;
    }

    public void setBID(String BID) {
        this.BID = BID;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
