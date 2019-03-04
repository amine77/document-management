package com.zarzisdev.documentmanagement.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
public class Explicit extends Schedule{
    @ElementCollection
    @Temporal(TemporalType.DATE)
    private List<Date> dates; // qui seront separées par un point virgule

    public Explicit(String scheduleType, List<Date> dates) {
        super(scheduleType);
        this.dates = dates;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    @Override
    public String toString() {
        return "Explicit{" +
                "dates=" + dates +
                '}';
    }
}
