package com.zarzisdev.documentmanagement.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Implicit extends Schedule{
    @Column
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cycle_id")
    private Cycle cycle;

    public Implicit(String scheduleType) {
        super(scheduleType);
    }

    public Implicit(String scheduleType, Date startDate, Date endDate, Cycle cycle) {
        super(scheduleType);
        this.startDate = startDate;
        this.endDate = endDate;
        this.cycle = cycle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Cycle getCycle() {
        return cycle;
    }

    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }

    @Override
    public String toString() {
        return "Implicit{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", cycle=" + cycle +
                '}';
    }
}
