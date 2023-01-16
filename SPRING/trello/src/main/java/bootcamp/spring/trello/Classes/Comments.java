package bootcamp.spring.trello.Classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.scheduling.config.Task;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comments {
    private Long id;
    private String comment;
    private Task task;
}
