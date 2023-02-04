package bootcamp3.finalProject.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "p_permission")
@Getter
@Setter
public class Permission extends BaseEntity implements GrantedAuthority {
    @Column(name = "name")
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
