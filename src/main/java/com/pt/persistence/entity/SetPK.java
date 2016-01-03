package com.pt.persistence.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *  Composite Primary Key Class for {@link Set}
 */
public class SetPK implements Serializable {

    private Integer SequenceNumber;
    private Date date;
    private User user;
    private ExerciseType exerciseType;

    public SetPK() {
    }

    public SetPK(Integer sequenceNumber, Date date, User user, ExerciseType exerciseType) {
        SequenceNumber = sequenceNumber;
        this.date = date;
        this.user = user;
        this.exerciseType = exerciseType;
    }

    public Integer getSequenceNumber() {
        return SequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        SequenceNumber = sequenceNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SetPK setPK = (SetPK) o;

        if (!SequenceNumber.equals(setPK.SequenceNumber)) return false;
        if (!date.equals(setPK.date)) return false;
        if (!user.equals(setPK.user)) return false;
        return exerciseType.equals(setPK.exerciseType);

    }

    @Override
    public int hashCode() {
        int result = SequenceNumber.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + exerciseType.hashCode();
        return result;
    }
}
