package com.example.demo.service.enumType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public enum AuthenticationTypeEnum {
    VISITOR("游客",0),
    AUTHOR("本人",1);

    private String type;
    private Integer index;

    AuthenticationTypeEnum(String type, Integer index) {
        this.type = type;
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public Integer getIndex() {
        return index;
    }
}
