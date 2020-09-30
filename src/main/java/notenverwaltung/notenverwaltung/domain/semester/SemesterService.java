package notenverwaltung.notenverwaltung.domain.semester;

import java.util.List;

public interface SemesterService{

    List<Semester> getAllSemester();

    Semester getSemesterById(String id);

    Semester createSemester(Semester semester);

    Semester updateSemesterById(String id, Semester semester);

    String deleteSemesterById(String id);
}
