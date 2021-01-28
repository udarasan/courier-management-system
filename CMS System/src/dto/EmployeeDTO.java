package dto;

public class EmployeeDTO {
    private String eid;
    private String firstName;
    private String secondName;
    private String telephoneNo;
    private String address;
    private String email;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String eid, String firstName, String secondName, String telephoneNo, String address, String email) {
        this.setEid(eid);
        this.setFirstName(firstName);
        this.setSecondName(secondName);
        this.setTelephoneNo(telephoneNo);
        this.setAddress(address);
        this.setEmail(email);
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
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
