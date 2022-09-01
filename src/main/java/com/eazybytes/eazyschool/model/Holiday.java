package com.eazybytes.eazyschool.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "holidays")
public class Holiday {

    @Id
    private final String day;
    private final String reason;
    @Enumerated(EnumType.STRING)
    private final Type type;

    public enum Type {
        FESTIVAL, FEDERAL
    }
}
