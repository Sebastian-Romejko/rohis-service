package rohis.user;

import rohis.enums.Permissions;
import rohis.project.Project;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    public User(String email, String password, Permissions permissions) {
        this.setEmail(email);
        this.setPassword(password);
        this.setPermissions(permissions);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long ID;

    @Column(name = "email", unique = true)
    @Getter
    @Setter
    private String email;

    @Column(name = "password")
    @Getter
    @Setter
    private String password;

    @Column(name = "permissions")
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Permissions permissions;

    @OneToMany(mappedBy = "user")
    private Set<Project> projects;
}
