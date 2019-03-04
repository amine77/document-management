package com.zarzisdev.documentmanagement.model;

import javax.persistence.*;
import java.util.List;

@Entity()
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    private List<Field> fields;

    public Content(List<Field> fields) {
        this.fields = fields;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", fields=" + fields +
                '}';
    }
}
