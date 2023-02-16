package bootcamp3.finalProject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "p_places")
@Getter
@Setter
public class Places extends BaseEntity {
   private String name;
   @Column(name = "description", columnDefinition = "TEXT")
   private String description;

   @Column(name = "history", columnDefinition = "TEXT")
   private String history;


   private LocalDate localDate;

   @Lob
   @Column(columnDefinition = "MEDIUMBLOB")
   private String image;

   @ManyToOne
   private Category categories;

   @ManyToOne
   private Region regions;




}
