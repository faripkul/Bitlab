package bootcamp3.finalProject.repository;

import bootcamp3.finalProject.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PermissionRepository extends JpaRepository<Permission,Long> {
    Permission findByName(String name);
}
