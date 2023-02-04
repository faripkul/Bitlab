package restApi.practice.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course extends BaseModel{
    private String name;
    private String description;
    private int price;
    private LocalDateTime addedTime;
    private Boolean professional;
}
