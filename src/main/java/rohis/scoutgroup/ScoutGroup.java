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
@Getter
@Setter
public class ScoutGroup {
    public ScoutGroup(String name, String leader) {
        this.name = name;
        this.leader = leader;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "leader")
    private String leader;

    @OneToMany(mappedBy = "scoutGroup")
    private Set<Project> projects;
}
