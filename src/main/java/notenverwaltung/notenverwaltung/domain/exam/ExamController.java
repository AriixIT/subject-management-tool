package notenverwaltung.notenverwaltung.domain.exam;

import notenverwaltung.notenverwaltung.domain.exam.mapper.ExamMapper;
import notenverwaltung.notenverwaltung.domain.semester.Semester;
import notenverwaltung.notenverwaltung.domain.semester.SemesterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamController {

    private ExamService examService;
    private ExamMapper examMapper;

    @Autowired
    public ExamController (ExamService examService, ExamMapper examMapper) {
        this.examService = examService;
        this.examMapper = examMapper;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<Collection<ExamDTO>> getAllExams() {
        List<Exam> exams = examService.getAllExams();
        return new ResponseEntity<>(examMapper.toDTOs(exams), HttpStatus.OK);
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<ExamDTO> getExamById(@PathVariable String id) {
        Exam exam = examService.getExamById(id);
        return new ResponseEntity<>(examMapper.toDTO(exam), HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<ExamDTO> createExam(@RequestBody ExamDTO.WithSubject examDTO) {
        examService.createExam(examMapper.fromWithSubjectDTO(examDTO));
        return new ResponseEntity<>(examDTO, HttpStatus.CREATED);
    }

    @PutMapping({"/{id}", "/{id}/"})
    public ResponseEntity<ExamDTO> updateExamById(@PathVariable String id, @RequestBody ExamDTO examDTO) {
        Exam newExam = examService.updateExamById(id, examMapper.fromDTO(examDTO));
        return new ResponseEntity<>(examMapper.toDTO(newExam), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public ResponseEntity<String> deleteExamById(@PathVariable String id) {
        examService.deleteExamById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
