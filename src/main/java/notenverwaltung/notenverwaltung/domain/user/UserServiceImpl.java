package notenverwaltung.notenverwaltung.domain.user;

import notenverwaltung.notenverwaltung.domain.semester.Semester;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("User with ID '%s' not found", id)));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    @Override
    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }
}
