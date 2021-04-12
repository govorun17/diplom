package my.diplom.dev.repo;

import my.diplom.dev.dto.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<Group, Long> {

}
