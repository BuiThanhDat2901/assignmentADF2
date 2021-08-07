package entity;

import java.util.ArrayList;
import java.util.Date;

import model.EmployeeModel;

public class Employee {
    private String name;
    private String address;
    private String email;
    private String userName;
    private String passWord;
    private Date dateCreate;
    private Date dateUpdate;
    private int status;

    public static ArrayList<EmployeeModel> list = new ArrayList();

    @Override
    public String toString() {
        return "User [name=" + name + ", address=" + address + ", email=" + email + ", userName=" + userName
                + ", passWord=" + passWord + ", dateCreate=" + dateCreate + ", dateUpdate=" + dateUpdate + ", status="
                + status + "]";
    }

    public Employee() {
        super();
    }

    public Employee(String name, String address, String email, String userName, String passWord,
                    java.util.Date dateCreate, java.util.Date dateUpdate, int status) {
        super();
        this.name = name;
        this.address = address;
        this.email = email;
        this.userName = userName;
        this.passWord = passWord;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(java.util.Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(java.util.Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
