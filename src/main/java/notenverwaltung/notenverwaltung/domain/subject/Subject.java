package notenverwaltung.notenverwaltung.domain.subject;

import com.fasterxml.jackson.annotation.JsonBackReference;
import notenverwaltung.notenverwaltung.domain.exam.Exam;
import notenverwaltung.notenverwaltung.domain.semester.Semester;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Generated(GenerationTime.ALWAYS)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "subject", fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Exam> exams;

    @ManyToOne
    @JoinColumn(name="semester", nullable=false)
    private Semester semester;

    public Subject() {
    }

    public Subject(String name, Set<Exam> exams, Semester semester) {
        this.name = name;
        this.exams = exams;
        this.semester = semester;
    }

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

    public Set<Exam> getExams() {
        return exams;
    }

    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
