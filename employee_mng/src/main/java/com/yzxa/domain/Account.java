package com.yzxa.domain;

import java.io.Serializable;

public class Account  implements Serializable {
    private  Integer employee_id;
    private  String username;
    private  String password;
    private  Integer permission;
    private String name;

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "employee_id=" + employee_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", permission=" + permission +
                ", name='" + name + '\'' +
                '}';
    }
}
