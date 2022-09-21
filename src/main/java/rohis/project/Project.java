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
@Getter
@Setter
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
    private Long ID;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "scout_group_id")
    private ScoutGroup scoutGroup;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "rohis_year")
    private int rohisYear;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "goals")
    private String goals;

    @Column(name = "description")
    private String description;

    @Column(name = "materials")
    private String materials;

    @Column(name = "file")
    private String file;

    @Column(name = "status")
    private Status status;
}
