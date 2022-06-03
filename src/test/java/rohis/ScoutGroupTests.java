package rohis;

import rohis.project.ProjectRepository;
import rohis.scoutgroup.ScoutGroupRepository;
import rohis.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ScoutGroupTests {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ScoutGroupRepository scoutGroupRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void findByEmail() {
    }
}
