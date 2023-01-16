package bootcamp.spring.trello.Classes;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_category")
@Getter
@Setter
public class BitlabTaskCategories extends BaseEntity {

    @Column(name = "name")
    private String name;
}
