package notenverwaltung.notenverwaltung.domain.subject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import notenverwaltung.notenverwaltung.domain.exam.Exam;
import notenverwaltung.notenverwaltung.domain.exam.ExamDTO;
import notenverwaltung.notenverwaltung.domain.semester.Semester;
import notenverwaltung.notenverwaltung.domain.semester.SemesterDTO;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectDTO {

    protected String id;

    protected String name;

    protected Set<ExamDTO> exams;

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

    public Set<ExamDTO> getExams() {
        return exams;
    }

    public void setExams(Set<ExamDTO> exams) {
        this.exams = exams;
    }


    public static class WithSemester extends SubjectDTO {

        protected Semester semester;

        public Semester getSemester() {
            return semester;
        }

        public void setSemester(Semester semester) {
            this.semester = semester;
        }
    }
}
