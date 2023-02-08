package bootcamp3.finalProject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "p_category")
@Getter
@Setter
public class Category extends BaseEntity {
    private String name;
    private String description;
}
