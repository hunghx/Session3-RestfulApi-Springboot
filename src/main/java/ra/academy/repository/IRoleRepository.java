package ra.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.academy.entity.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
}
