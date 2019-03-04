package com.zarzisdev.documentmanagement.model;

import javax.persistence.*;

@Entity
public class Cycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String value;

    public Cycle() {
    }

    public Cycle(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Cycle{" +
                "value='" + value + '\'' +
                '}';
    }
}
