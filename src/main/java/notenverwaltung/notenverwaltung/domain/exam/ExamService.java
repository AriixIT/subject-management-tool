package notenverwaltung.notenverwaltung.domain.exam;

import notenverwaltung.notenverwaltung.domain.semester.Semester;

import java.util.List;

public interface ExamService {
    List<Exam> getAllExams();

    Exam getExamById(String id);

    Exam createExam(Exam exam);

    Exam updateExamById(String id, Exam exam);

    String deleteExamById(String id);
}
