package com.steering.assignment.request;

public class EmployeeUpdateRequest {
    private String id;
    private String name;
    private String phoneNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "EmployeeUpdateRequest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phoneNo + '\'' +
                '}';
    }
}
