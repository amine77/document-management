package com.zarzisdev.documentmanagement.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class FieldValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fieldValueType;

    public FieldValue() {
    }
    public FieldValue(String fieldValueType) {
        this.fieldValueType = fieldValueType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFieldValueType() {
        return fieldValueType;
    }

    public void setFieldValueType(String fieldValueType) {
        this.fieldValueType = fieldValueType;
    }

    @Override
    public String toString() {
        return "FieldValue{" +
                "id=" + id +
                ", fieldValueType='" + fieldValueType + '\'' +
                '}';
    }
}
