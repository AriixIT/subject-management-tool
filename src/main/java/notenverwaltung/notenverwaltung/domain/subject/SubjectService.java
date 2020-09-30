package notenverwaltung.notenverwaltung.domain.subject;

import notenverwaltung.notenverwaltung.domain.semester.Semester;
import notenverwaltung.notenverwaltung.domain.semester.SemesterDTO;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubjects();

    Subject getSubjectById(String id);

    Subject createSubject(Subject subject);

    Subject updateSubjectById(String id, Subject subject);

    String deleteSubjectById(String id);
}
