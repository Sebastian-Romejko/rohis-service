package rohis.scoutgroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScoutGroupService implements IScoutGroupService {
    @Autowired
    private ScoutGroupRepository scoutGroupRepository;

    @Override
    public List<ScoutGroup> getAll() {
        return scoutGroupRepository.findAll();
    }

    @Override
    public ScoutGroup getById(Long scoutGroupId) {
        return scoutGroupRepository.getOne(scoutGroupId);
    }

    @Override
    public void addScoutGroup(ScoutGroup scoutGroup) {
        scoutGroupRepository.save(scoutGroup);
    }

    @Override
    public void removeScoutGroup(ScoutGroup scoutGroup) {
        scoutGroupRepository.delete(scoutGroup);
    }

    @Override
    public void modifyScoutGroup(Long scoutGroupId, ScoutGroup scoutGroup) {
        scoutGroup.setID(scoutGroupId);
        scoutGroupRepository.save(scoutGroup);
    }
}
