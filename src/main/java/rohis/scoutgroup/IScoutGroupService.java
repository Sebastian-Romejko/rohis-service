package rohis.scoutgroup;

import java.util.List;

public interface IScoutGroupService {
    List<ScoutGroup> getAll();
    ScoutGroup getById(Long scoutGroupId);
    void addScoutGroup(ScoutGroup scoutGroup);
    void removeScoutGroup(ScoutGroup scoutGroup);
    void modifyScoutGroup(Long scoutGroupId,ScoutGroup scoutGroup);
}
