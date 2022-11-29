package com.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_logIn")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    //@NotNull(message = "Required")
    @NotNull
    @Column(name = "Name")
    private String Name;

    @NotNull
    @Column(name = "Password")
    private String Password;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
//    @OneToOne
//    private StudentGuardian studentGuardian;
//    public StudentGuardian getStudentGuardian() {
//        return studentGuardian;
//    }
//
//    public void setStudentGuardian(StudentGuardian studentGuardian) {
//        this.studentGuardian = studentGuardian;
//    }
}
