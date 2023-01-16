package bootcamp.spring.trello.Classes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_tasks")
@Getter
@Setter
public class BitlabTasks extends BaseEntity{

    @Column(name = "title")
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "status")
    private TaskStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private BitlabFolders folder;
}
