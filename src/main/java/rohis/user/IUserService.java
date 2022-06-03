package rohis.user;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    User getById(Long userId);
    User getByEmail(String userEmail);
    void addUser(User user);
    void removeUser(User user);
    void modifyUser(Long userId, User user);
}
