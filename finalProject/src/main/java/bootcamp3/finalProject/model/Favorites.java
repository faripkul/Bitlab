package bootcamp3.finalProject.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "p_favorite")
@Getter
@Setter
public class Favorites extends BaseEntity {

    private String name;
    private String description;
    private LocalDateTime localDateTime;
    @ManyToOne
    private User user;

    @ManyToOne
    private Places places;
}
