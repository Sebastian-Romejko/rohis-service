package rohis.scoutgroup;

import rohis.project.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "scout_groups")
@NoArgsConstructor
public class ScoutGroup {
    public ScoutGroup(String name, String leader) {
        this.name = name;
        this.leader = leader;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long ID;

    @Column(name = "name", unique = true)
    @Getter
    @Setter
    private String name;

    @Column(name = "leader")
    @Getter
    @Setter
    private String leader;

    @OneToMany(mappedBy = "scoutGroup")
    @Getter
    @Setter
    private Set<Project> projects;
}
