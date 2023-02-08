package bootcamp3.finalProject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "p_region")
@Getter
@Setter
public class Region extends BaseEntity {

    private String name;
}
