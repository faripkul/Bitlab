package bootcamp.spring.trello.Classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Folders {
    private Long id;
    private String name;
    private List<TaskCategories> categories; // Many To Many


}
