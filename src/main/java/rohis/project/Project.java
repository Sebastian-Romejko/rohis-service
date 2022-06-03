package rohis.project;

import rohis.enums.Status;
import rohis.scoutgroup.ScoutGroup;
import rohis.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "projects")
@NoArgsConstructor
public class Project {
    public Project(String name, ScoutGroup scoutGroup, User user, int rohisYear, LocalDate date, String goals, String description, String materials, String file) {
        this.name = name;
        this.scoutGroup = scoutGroup;
        this.user = user;
        this.rohisYear = rohisYear;
        this.date = date;
        this.goals = goals;
        this.description = description;
        this.materials = materials;
        this.file = file;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long ID;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @ManyToOne
    @JoinColumn(name = "scout_group_id")
    @Getter
    @Setter
    private ScoutGroup scoutGroup;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private User user;

    @Column(name = "rohis_year")
    @Getter
    @Setter
    private int rohisYear;

    @Column(name = "date")
    @Getter
    @Setter
    private LocalDate date;

    @Column(name = "goals")
    @Getter
    @Setter
    private String goals;

    @Column(name = "description")
    @Getter
    @Setter
    private String description;

    @Column(name = "materials")
    @Getter
    @Setter
    private String materials;

    @Column(name = "file")
    @Getter
    @Setter
    private String file;

    @Column(name = "status")
    @Getter
    @Setter
    private Status status;
}
