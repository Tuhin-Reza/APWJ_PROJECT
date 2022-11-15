package com.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
    @ManyToOne
    private   LeaveType leaveType;

    @Id
    private int id;

}
