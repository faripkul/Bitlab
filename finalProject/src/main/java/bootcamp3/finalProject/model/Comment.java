package bootcamp3.finalProject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="p_comment")
@Getter
@Setter
public class Comment extends BaseEntity {

    @Column(name = "text", columnDefinition = "TEXT")
    private String text;

    private LocalDateTime localDateTime;

    @ManyToOne
    private Places places;
}
