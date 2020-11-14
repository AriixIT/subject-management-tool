package notenverwaltung.notenverwaltung.domain.user;

import notenverwaltung.notenverwaltung.domain.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserController (UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<Collection<UserDTO>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(userMapper.toDTOs(users), HttpStatus.OK);
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        userService.createUser(userMapper.fromDTO(user));
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public ResponseEntity<String> deleteUserById(@PathVariable String id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
