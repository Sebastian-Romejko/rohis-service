package rohis.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long userId) {
        return userRepository.getOne(userId);
    }

    @Override
    public User getByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public void modifyUser(Long userId, User user) {
        user.setID(userId);
        userRepository.save(user);
    }
}
