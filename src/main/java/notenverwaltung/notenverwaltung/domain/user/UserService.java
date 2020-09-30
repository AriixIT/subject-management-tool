package notenverwaltung.notenverwaltung.domain.user;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(String id);

    User createUser(User user);

    String deleteUserById(String id);


}
