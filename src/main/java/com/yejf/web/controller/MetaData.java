package com.yejf.web.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MetaData {
    @NotBlank
    private String id;
    @Size(min = 3,max = 5)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
