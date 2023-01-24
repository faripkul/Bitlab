package bootcamp3.security.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "t_permission")
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
