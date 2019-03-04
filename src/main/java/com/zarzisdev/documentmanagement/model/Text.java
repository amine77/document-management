package com.zarzisdev.documentmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Text extends FieldValue {
    @Column
    private String textContent;

    public Text() {
    }

    public Text(String textContent) {
        this.textContent = textContent;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    @Override
    public String toString() {
        return "Text{" +
                "textContent='" + textContent + '\'' +
                '}';
    }
}
