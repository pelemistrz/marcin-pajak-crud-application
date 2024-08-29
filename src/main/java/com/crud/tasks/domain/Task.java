package com.crud.tasks.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity(name="tasks")
public class Task {
    @Id
    @NotNull
    @GeneratedValue
    private Long id;

    @Column(name="name")
    private String title;

    @Column(name="description")
    private String content;

}
