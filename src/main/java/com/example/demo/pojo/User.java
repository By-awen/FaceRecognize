package com.example.demo.pojo;

import javax.persistence.*;

@Table(name = "UserFace")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20,unique = true)//一个家庭中每个人的姓名不可能一样的。
    private String name;
    @Column(length = 18)
    private String password;
    @Column(length = 3)
    private int age;
    @Column(length = 11,unique = true)
    private String tel;
    @Column(length = 11,unique = true)
    private String email;
    @Column(unique = true)//用来存储人脸信息
    private String face;
    @Column(unique = true)//权限信息存储
    private String Role;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getFace() {
        return face;
    }

    public String getRole() {
        return Role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public void setRole(String role) {
        Role = role;
    }
}
