package rohis;

import rohis.enums.Permissions;
import rohis.project.Project;
import rohis.project.ProjectRepository;
import rohis.scoutgroup.ScoutGroup;
import rohis.scoutgroup.ScoutGroupRepository;
import rohis.user.User;
import rohis.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProjectTests {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ScoutGroupRepository scoutGroupRepository;

    @Autowired
    UserRepository userRepository;

    @AfterEach
    void deleteAllData() {
        projectRepository.deleteAll();
        scoutGroupRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    void findByScoutGroup() throws InterruptedException {
        // given
        ScoutGroup scoutGroup = new ScoutGroup(
                "53 DH Buki",
                "Ala Kot"
        );
        scoutGroupRepository.save(scoutGroup);

        Project project1 = new Project(
                "TEST1",
                scoutGroup,
                null,
                2022,
                LocalDateTime.now().toLocalDate(),
                "cele",
                "opis",
                "materialy",
                "plik"
        );
        Project project2 = new Project(
                "TEST2",
                scoutGroup,
                null,
                2022,
                LocalDateTime.now().toLocalDate(),
                "cele",
                "opis",
                "materialy",
                "plik"
        );
        projectRepository.save(project1);
        projectRepository.save(project2);

        // when
        List<Project> foundProjects = projectRepository.findByScoutGroup(scoutGroup);

        // then
        assertThat(foundProjects.size()).isEqualTo(2);
    }

    @Test
    void findByUser() {
        // given
        User user = new User(
                "test@gmail.com",
                "123",
                Permissions.USER
        );
        userRepository.save(user);

        Project project1 = new Project(
                "TEST1",
                null,
                user,
                2022,
                LocalDateTime.now().toLocalDate(),
                "cele",
                "opis",
                "materialy",
                "plik"
        );
        Project project2 = new Project(
                "TEST2",
                null,
                user,
                2022,
                LocalDateTime.now().toLocalDate(),
                "cele",
                "opis",
                "materialy",
                "plik"
        );
        projectRepository.save(project1);
        projectRepository.save(project2);

        // when
        List<Project> foundProjects = projectRepository.findByUser(user);

        // then
        assertThat(foundProjects.size()).isEqualTo(2);
    }
}
