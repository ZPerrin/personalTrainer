package com.pt.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *  Represents an workout set - e.g. 3 sets of 10 reps
 */
@Entity
@Table(name = "SET")
@IdClass(SetPK.class)
public class Set implements Serializable {

    @Id
    @Column(name = "SEQUENCE_NUMBER")
    private Integer SequenceNumber;

    @Id
    @Column(name = "DATE")
    private Date date;

    @Column(name = "REPS")
    private Integer Reps;

    @Column(name = "WEIGHT")
    private Double weight;

    @Column(name = "TIME")
    private Integer timeInSeconds;

    @Column(name = "DISTANCE")
    private Integer distanceInMiles;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_ID", referencedColumnName = "ID")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="EX_TYPE")
    private ExerciseType exerciseType;

    public Set() {
    }

    public Integer getSequenceNumber() {
        return SequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        SequenceNumber = sequenceNumber;
    }

    public Integer getReps() {
        return Reps;
    }

    public void setReps(Integer reps) {
        Reps = reps;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTimeInSeconds() {
        return timeInSeconds;
    }

    public void setTimeInSeconds(Integer timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    public Integer getDistanceInMiles() {
        return distanceInMiles;
    }

    public void setDistanceInMiles(Integer distanceInMiles) {
        this.distanceInMiles = distanceInMiles;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }
}
