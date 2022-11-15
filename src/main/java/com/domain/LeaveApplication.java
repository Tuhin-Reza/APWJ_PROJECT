package com.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LeaveApplication {
    @ManyToOne
    private Employee employee;

    @Id
    private int id;
}
