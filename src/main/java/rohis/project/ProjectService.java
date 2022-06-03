package rohis.project;

import rohis.scoutgroup.ScoutGroup;
import rohis.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectService implements IProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project getById(Long projectId) {
        return projectRepository.getOne(projectId);
    }

    @Override
    public List<Project> getByScoutGroup(ScoutGroup scoutGroup) {
        return projectRepository.findByScoutGroup(scoutGroup);
    }

    @Override
    public List<Project> getByUser(User user) {
        return projectRepository.findByUser(user);
    }

    @Override
    public void addProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void removeProject(Project project) {
        projectRepository.delete(project);
    }

    @Override
    public void removeProject(Long projectId) {
        projectRepository.delete(getById(projectId));
    }

    @Override
    public void modifyProject(Long projectId, Project project) {
        project.setID(projectId);
        projectRepository.save(project);
    }
}
