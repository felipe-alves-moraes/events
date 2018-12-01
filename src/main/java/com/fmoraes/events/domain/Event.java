package com.fmoraes.events.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Column
    private Category category;
    @NotBlank
    @Column
    private String name;

    protected Event() {}

    public Event(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
