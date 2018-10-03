package com.hlvy.springboot.model;


import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -1586123208990352270L;

    private Integer id;//

    private String nick;//昵称

    private String phone;//手机号

    private String address;//地址

    private String email;//邮箱

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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