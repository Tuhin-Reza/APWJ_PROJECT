package com.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user2")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotNull(message = "Required")
    @NotEmpty(message = "Please enter your name.")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Please enter your password.")
    @Size(min = 4, max = 15,message = "Your password must between 6 and 15 characters.")
    @Column(name = "password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
