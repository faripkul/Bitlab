package spring.hibernate.task.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
    private Long id;
    private String name;
    private String description;
    private int price;
}
