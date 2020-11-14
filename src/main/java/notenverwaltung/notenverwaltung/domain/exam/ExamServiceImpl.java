package notenverwaltung.notenverwaltung.domain.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ExamServiceImpl implements ExamService {

    private ExamRepository examRepository;

    @Autowired
    public ExamServiceImpl(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public Exam findById(String id) {
        return examRepository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("Exam with ID '%s' not found", id)));
    }

    @Override
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    @Override
    public Exam getExamById(String id) {
        return findById(id);
    }

    @Override
    public Exam createExam(Exam exam) {
        examRepository.save(exam);
        return exam;
    }

    @Override
    public Exam updateExamById(String id, Exam exam) {
        Exam oldExam = findById(id);

        oldExam.setDate(exam.getDate());
        oldExam.setMark(exam.getMark());
        oldExam.setName(exam.getName());

        examRepository.save(oldExam);

        return oldExam;
    }

    @Override
    public String deleteExamById(String id) {
        examRepository.deleteById(id);
        return id;
    }
}
