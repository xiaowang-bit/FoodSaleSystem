package com.hubu.model;

/**
 * @author star
 * @date 2020/1/9 16:13
 * @description 用户
 */
public class User {
    private String id;
    private String name;
    private String password;
    private String cellphone;
    private String email;

    public User() {
        super();
    }

    public User(String id, String name, String password, String cellphone, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.cellphone = cellphone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + name + '\'' +
                ", password='" + password + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
