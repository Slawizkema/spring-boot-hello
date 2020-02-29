package org.ssharaev.tasktracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String description;

    @NotNull
    private String taskPriority;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "task_list_id")
    private TaskList taskList;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "task_tag",
            joinColumns = { @JoinColumn(name = "task_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") }
    )
    Set<Tag> tags = new HashSet<>();

    @NotNull
    private boolean done;

    @ManyToOne
    @JoinColumn(name = "parent_task_id")
    private Task parentTask;
}
