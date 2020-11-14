package notenverwaltung.notenverwaltung.domain.subject;

import notenverwaltung.notenverwaltung.domain.subject.mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/subjects")
public class SubjectController {
    private SubjectService subjectService;
    private SubjectMapper subjectMapper;

    @Autowired
    public SubjectController (SubjectService subjectService, SubjectMapper subjectMapper) {
        this.subjectService = subjectService;
        this.subjectMapper = subjectMapper;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<Collection<SubjectDTO>> getAllSubjects() {
        List<Subject> subjects = subjectService.getAllSubjects();
        return new ResponseEntity<>(subjectMapper.toDTOs(subjects), HttpStatus.OK);
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<SubjectDTO> getSubjectById(@PathVariable String id) {
        Subject subject = subjectService.getSubjectById(id);
        return new ResponseEntity<>(subjectMapper.toWithExamsDTO(subject), HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<SubjectDTO> createSubject(@RequestBody SubjectDTO.WithSemester subjectDTO) {
        Subject sub = subjectMapper.fromWithSemesterDTO(subjectDTO);
        subjectService.createSubject(sub);
        return new ResponseEntity<>(subjectMapper.toWithExamsDTO(sub), HttpStatus.CREATED);
    }

    @PutMapping({"/{id}", "/{id}/"})
    public ResponseEntity<SubjectDTO> updateSubjectById(@PathVariable String id, @RequestBody SubjectDTO subjectDTO) {
        Subject newSubject = subjectService.updateSubjectById(id, subjectMapper.fromDTO(subjectDTO));
        return new ResponseEntity<>(subjectMapper.toWithExamsDTO(newSubject), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public ResponseEntity<String> deleteSubjectById(@PathVariable String id) {
        subjectService.deleteSubjectById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
