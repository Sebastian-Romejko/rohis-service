package rohis.scoutgroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/scout-groups")
public class ScoutGroupController {
    @Autowired
    private ScoutGroupService scoutGroupService;

    @GetMapping(value = "/all")
    public List<ScoutGroup> GetAll() {
        return scoutGroupService.getAll();
    }

    @GetMapping(value = "/{projectId}")
    public ScoutGroup GetScoutGroup(@PathVariable Long scoutGroupId) {
        return scoutGroupService.getById(scoutGroupId);
    }

    @PostMapping(value = "/add")
    public void AddScoutGroup(@RequestBody ScoutGroup scoutGroup) {
        scoutGroupService.addScoutGroup(scoutGroup);
    }

    @GetMapping(value = "/delete/{projectId}")
    public void DeleteScoutGroup(@PathVariable Long scoutGroupId) {
        scoutGroupService.removeScoutGroup(scoutGroupService.getById(scoutGroupId));
    }

    @PostMapping(value = "/modify/{projectId}")
    public void ModifyScoutGroup(@PathVariable Long scoutGroupId, @RequestBody ScoutGroup scoutGroup) {
        scoutGroupService.modifyScoutGroup(scoutGroupId, scoutGroup);
    }
}
