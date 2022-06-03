package rohis.project;

import rohis.scoutgroup.ScoutGroup;
import rohis.user.User;

import java.util.List;

public interface IProjectService {
    List<Project> getAll();
    Project getById(Long projectId);
    List<Project> getByScoutGroup(ScoutGroup scoutGroup);
    List<Project> getByUser(User user);
    void addProject(Project project);
    void removeProject(Project project);
    void removeProject(Long projectId);
    void modifyProject(Long projectId,Project project);
}
