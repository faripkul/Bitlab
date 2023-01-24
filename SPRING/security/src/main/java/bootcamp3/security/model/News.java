package bootcamp3.security.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_news")
@Getter
@Setter
public class News extends BaseEntity {
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime postDate;
    @ManyToOne
    private User user;
}
