package com.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "stoppage_route")
public class Route {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "*required")
    @Column(name ="busName")
    private String busName;

    @NotEmpty(message = "*required")
    @Column(name ="boardingPoint")
    private String boardingPoint;

    @NotEmpty(message = "*required")
    @Column(name ="droppingPoint")
    private String droppingPoint ;

    @NotEmpty(message = "*required")
    @Column(name ="b_busStoppage")
    private String b_busStoppage;

    @NotEmpty(message = "*required")
    @Column(name ="d_busStoppage")
    private String d_busStoppage;

    @NotEmpty(message = "*required")
    @Column(name ="driverName")
    private String driverName;

    @NotEmpty(message = "*required")
    @Column(name ="b_time")
    private String b_time;


    @NotNull(message = "*required")
    @Column(name ="distance")
    private Integer distance;

    @NotNull(message = "*required")
    @Column(name ="fare")
    private Integer fare;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getBoardingPoint() {
        return boardingPoint;
    }

    public void setBoardingPoint(String boardingPoint) {
        this.boardingPoint = boardingPoint;
    }

    public String getDroppingPoint() {
        return droppingPoint;
    }

    public void setDroppingPoint(String droppingPoint) {
        this.droppingPoint = droppingPoint;
    }

    public String getB_busStoppage() {
        return b_busStoppage;
    }

    public void setB_busStoppage(String b_busStoppage) {
        this.b_busStoppage = b_busStoppage;
    }

    public String getD_busStoppage() {
        return d_busStoppage;
    }

    public void setD_busStoppage(String d_busStoppage) {
        this.d_busStoppage = d_busStoppage;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getB_time() {
        return b_time;
    }

    public void setB_time(String b_time) {
        this.b_time = b_time;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getFare() {
        return fare;
    }

    public void setFare(Integer fare) {
        this.fare = fare;
    }
}
