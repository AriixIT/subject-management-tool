package notenverwaltung.notenverwaltung.domain.exam;

import notenverwaltung.notenverwaltung.domain.subject.Subject;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Generated(GenerationTime.ALWAYS)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private float mark;

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name="subject", nullable=false)
    private Subject subject;

    public Exam() {
    }

    public Exam(String name, float mark, String date, Subject subject) {
        this.name = name;
        this.mark = mark;
        this.date = date;
        this.subject = subject;
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

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
