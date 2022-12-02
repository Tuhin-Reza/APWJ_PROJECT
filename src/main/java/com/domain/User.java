package com.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user2")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    //@NotNull(message = "Required")
    @NotEmpty(message = "Please enter your name.")
    @Size(max = 20, min = 3,message = "Name must be min 3 or max 20 Character")
    @Column(name = "user_name",unique = true)
    private String user_name;

    @NotEmpty(message = "Please enter your password.")
    @Size(min = 4, max = 15,message = "Your password must between 4 and 15 characters.")
    @Column(name = "user_password")
    private String user_password;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
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
