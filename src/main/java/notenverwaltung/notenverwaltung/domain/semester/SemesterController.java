package notenverwaltung.notenverwaltung.domain.semester;

import notenverwaltung.notenverwaltung.domain.semester.mapper.SemesterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/semesters")
public class SemesterController {

    private SemesterService semesterService;
    private SemesterMapper semesterMapper;

    @Autowired
    public SemesterController (SemesterService semesterService, SemesterMapper semesterMapper) {
        this.semesterService = semesterService;
        this.semesterMapper = semesterMapper;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<Collection<SemesterDTO>> getAllSemester() {
        List<Semester> semesters = semesterService.getAllSemester();
        return new ResponseEntity<>(semesterMapper.toDTOs(semesters), HttpStatus.OK);
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<SemesterDTO> getSemesterById(@PathVariable String id) {
        Semester semester = semesterService.getSemesterById(id);
        return new ResponseEntity<>(semesterMapper.toWithSubjectsDTO(semester), HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<SemesterDTO> createSemester(@RequestBody SemesterDTO.WithUser semester) {
        Semester sem = semesterMapper.fromWithUserDTO(semester);
        semesterService.createSemester(sem);
        return new ResponseEntity<>(semesterMapper.toWithSubjectsDTO(sem), HttpStatus.CREATED);
    }

    @PutMapping({"/{id}", "/{id}/"})
    public ResponseEntity<SemesterDTO> updateSemesterById(@PathVariable String id, @RequestBody SemesterDTO semester) {
        Semester newSemester = semesterService.updateSemesterById(id, semesterMapper.fromDTO(semester));
        return new ResponseEntity<>(semesterMapper.toWithSubjectsDTO(newSemester), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public ResponseEntity<String> deleteSemesterById(@PathVariable String id) {
        semesterService.deleteSemesterById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
