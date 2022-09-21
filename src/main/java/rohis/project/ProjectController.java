package rohis.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping(value = "/all")
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @GetMapping(value = "/{projectId}")
    public Project getProject(@PathVariable Long projectId) {
        return projectService.getById(projectId);
    }

    @PostMapping(value = "/add")
    public void addProject(@RequestBody ProjectDTO projectDTO) {
        Project project = new Project();
        project.setID((long) 1);
        project.setName(projectDTO.getName());
        project.setRohisYear(projectDTO.getRohisYear());
        project.setDate(projectDTO.getDate());
        projectService.addProject(project);
    }

    @GetMapping(value = "/delete/{projectId}")
    public void deleteProject(@PathVariable Long projectId) {
        projectService.removeProject(projectService.getById(projectId));
    }

    @PostMapping(value = "/modify/{projectId}")
    public void modifyProject(@PathVariable Long projectId, @RequestBody Project project) {
        projectService.modifyProject(projectId, project);
    }
}
