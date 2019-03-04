package com.zarzisdev.documentmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public abstract class Schedule extends FieldValue {
    @Column
    private String scheduleType;

    public Schedule() {
    }

    public Schedule(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    public String getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleType='" + scheduleType + '\'' +
                '}';
    }
}
