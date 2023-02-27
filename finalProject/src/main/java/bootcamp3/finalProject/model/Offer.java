package bootcamp3.finalProject.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "p_offer")
@Getter
@Setter
public class Offer extends BaseEntity{
    @Column(name = "text")
    private String text;

    private LocalDateTime localDateTime;
}

