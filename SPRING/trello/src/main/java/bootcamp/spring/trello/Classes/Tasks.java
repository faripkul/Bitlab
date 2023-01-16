package bootcamp.spring.trello.Classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tasks {
    private Long id;
    private String title;
    private String description; // TEXT
    private int status; // 0 - todo, 1 - intest, 2 - done, 3 - failed
    private Folders folder; // Many To One
}
