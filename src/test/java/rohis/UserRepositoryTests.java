package rohis;

import rohis.enums.Permissions;
import rohis.user.User;
import rohis.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTests {
    @Autowired
    UserRepository userRepository;

    @AfterEach
    void deleteAllData() {
        userRepository.deleteAll();
    }

    @Test
    void shouldReturnEmptyList() {
//        while(true)
        assertThat(userRepository.findAll()).isEqualTo(Collections.emptyList());
    }

    @Test
    void findByEmail() {
        // given
        String email = "alamakota@gmail.com";
        String password = "123";
        User user = new User(
                email,
                password,
                Permissions.USER
        );
        userRepository.save(user);

        // when
        User foundUser = userRepository.findByEmail(email);

        // then
        assertThat(foundUser.getID()).isEqualTo(user.getID());
        assertThat(foundUser.getEmail()).isEqualTo(user.getEmail());
        assertThat(foundUser.getPassword()).isEqualTo(user.getPassword());
    }
}
