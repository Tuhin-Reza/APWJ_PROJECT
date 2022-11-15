package com.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LeaveType {

    @ManyToOne
    private  LeaveApplication leaveApplication;

    @Id
    private int id;



}
