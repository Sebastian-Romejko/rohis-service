package rohis.project;

import rohis.scoutgroup.ScoutGroup;
import rohis.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByScoutGroup(ScoutGroup scoutGroup);
    List<Project> findByUser(User user);
}
