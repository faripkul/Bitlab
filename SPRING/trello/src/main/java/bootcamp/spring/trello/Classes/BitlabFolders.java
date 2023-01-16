package bootcamp.spring.trello.Classes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_folders")
@Getter
@Setter
public class BitlabFolders extends BaseEntity{

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<BitlabTaskCategories> categories;

}
