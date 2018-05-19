package com.hanfak.entrypoints.controllers.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class XmlDto {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
