package com.domain;

import com.constant.PROFESSION;
import com.validator.IsValidPassword;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "*name required")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "*name required")
    @Column(name ="age")
    private String age;

    @NotEmpty(message ="*address required")
    @Column(name = "address")
    private String address;

    @NotNull(message = "*profession required")
    @Column(name = "profession")
    private PROFESSION profession;


    @NotEmpty(message = "*username required")
    //@Size(min = 4,max = 20)
    @Column(name = "username",unique = true)
    private String username;

    @NotEmpty(message = "*password required")
   // @Size(min = 4,max = 20)
    //@IsValidPassword
    @Column(name = "password",unique = true)
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PROFESSION getProfession() {
        return profession;
    }

    public void setProfession(PROFESSION profession) {
        this.profession = profession;
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



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority_map",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private List<Authority> authorities;


    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
