package org.ssharaev.tasktracker.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String name;

    private String color;

    @ManyToMany(mappedBy = "tags")
    Set<Task> tasks = new HashSet<>();
}
