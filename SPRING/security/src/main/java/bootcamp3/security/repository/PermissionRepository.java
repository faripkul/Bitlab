package bootcamp3.security.repository;

import bootcamp3.security.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PermissionRepository extends JpaRepository<Permission,Long> {
    Permission findByName(String name);
}
