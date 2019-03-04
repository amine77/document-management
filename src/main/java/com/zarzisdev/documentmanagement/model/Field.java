package com.zarzisdev.documentmanagement.model;

import javax.persistence.*;

@Entity
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_value_id")
    private FieldValue fieldValue;

    @ManyToOne
    @JoinColumn(name = "content_fk")
    private Content content;

    public Field() {
    }

    public Field(String label, FieldValue fieldValue) {
        this.label = label;
        this.fieldValue = fieldValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public FieldValue getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(FieldValue fieldValue) {
        this.fieldValue = fieldValue;
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", fieldValue=" + fieldValue +
                '}';
    }
}
