package notenverwaltung.notenverwaltung.domain.semester;

import notenverwaltung.notenverwaltung.domain.user.User;
import notenverwaltung.notenverwaltung.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/semester")
public class SemesterController {

    private SemesterService semesterService;

    @Autowired
    public SemesterController (SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<Collection<Semester>> getAllSemester() {
        List<Semester> semesters = semesterService.getAllSemester();
        return new ResponseEntity<>(semesters, HttpStatus.OK);
    }

    @GetMapping({"/id", "/id/"})
    public ResponseEntity<Semester> getSemesterById(@PathVariable String id) {
        Semester semester = semesterService.getSemesterById(id);
        return new ResponseEntity<>(semester, HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Semester> createSemester(@RequestBody Semester semester) {
        semesterService.createSemester(semester);
        return new ResponseEntity<>(semester, HttpStatus.CREATED);
    }

    @PutMapping({"/id", "/id/"})
    public ResponseEntity<Semester> updateSemesterById(@PathVariable String id, @RequestBody Semester semester) {
        Semester newSemester = semesterService.updateSemesterById(id, semester);
        return new ResponseEntity<>(newSemester, HttpStatus.OK);
    }

    @DeleteMapping({"/id", "/id/"})
    public ResponseEntity<String> deleteSemesterById(@PathVariable String id) {
        semesterService.deleteSemesterById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
