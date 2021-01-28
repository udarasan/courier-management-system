package dto;


public class CustomerDTO {
    private String cid;
    private String firstName;
    private String secondName;
    private String telephoneNo;
    private String address;
    private String email;

    public CustomerDTO() {
    }

    public CustomerDTO(String cid, String firstName, String secondName, String telephoneNo, String address, String email) {
        this.setCid(cid);
        this.setFirstName(firstName);
        this.setSecondName(secondName);
        this.setTelephoneNo(telephoneNo);
        this.setAddress(address);
        this.setEmail(email);
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
