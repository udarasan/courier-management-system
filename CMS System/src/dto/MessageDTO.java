package dto;

public class MessageDTO {
    private String MID;
    private String message;

    public MessageDTO() {
    }

    public MessageDTO(String MID, String message) {
        this.setMID(MID);
        this.setMessage(message);
    }

    public String getMID() {
        return MID;
    }

    public void setMID(String MID) {
        this.MID = MID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
