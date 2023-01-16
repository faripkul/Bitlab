package bootcamp.spring.trello.Classes;


import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.config.Task;

import javax.persistence.*;

@Entity
@Table(name = "t_comment")
@Getter
@Setter
public class BitlabComments  extends BaseEntity{


    @Column(name = "comment")
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private BitlabTasks task;

}
