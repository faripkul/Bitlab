package bootcamp3.finalProject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="p_comment")
@Getter
@Setter
public class Comment extends BaseEntity {

    @Column(name = "text", columnDefinition = "TEXT")
    private String text;

    private LocalDateTime localDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Places places;

    @OneToOne
    private User user;
}
