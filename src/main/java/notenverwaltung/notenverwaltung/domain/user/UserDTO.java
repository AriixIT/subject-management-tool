package notenverwaltung.notenverwaltung.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import notenverwaltung.notenverwaltung.domain.semester.SemesterDTO;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    protected String id;

    protected String username;

    protected String firstname;

    protected String lastname;

    protected String email;

    protected String password;

    protected Set<SemesterDTO> semesters;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<SemesterDTO> getSemesters() {
        return semesters;
    }

    public void setSemesters(Set<SemesterDTO> semesters) {
        this.semesters = semesters;
    }


    public static class Login {

        protected String username;

        protected String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
