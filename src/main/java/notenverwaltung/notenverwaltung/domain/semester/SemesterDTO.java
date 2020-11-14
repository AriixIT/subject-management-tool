package notenverwaltung.notenverwaltung.domain.semester;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import notenverwaltung.notenverwaltung.domain.subject.SubjectDTO;
import notenverwaltung.notenverwaltung.domain.user.UserDTO;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SemesterDTO {

    protected String id;

    protected String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static class WithSubjects extends SemesterDTO {

        protected Set<SubjectDTO> subjects;

        public Set<SubjectDTO> getSubjects() {
            return subjects;
        }

        public void setSubjects(Set<SubjectDTO> subjects) {
            this.subjects = subjects;
        }
    }


    public static class WithUser extends SemesterDTO {

        protected UserDTO user;

        public UserDTO getUser() {
            return user;
        }

        public void setUser(UserDTO user) {
            this.user = user;
        }
    }
}
