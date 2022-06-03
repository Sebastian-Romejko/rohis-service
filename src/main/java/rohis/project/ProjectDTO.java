package rohis.project;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
public class ProjectDTO {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Long scoutGroupId;

    @Getter
    @Setter
    private Long userId;

    @Getter
    @Setter
    private LocalDate date;

    @Getter
    @Setter
    private int rohisYear;

    @Getter
    @Setter
    private String goals;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String materials;

    @Getter
    @Setter
    private String file;
}
