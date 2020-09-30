package notenverwaltung.notenverwaltung.domain.exam;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import notenverwaltung.notenverwaltung.domain.subject.Subject;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExamDTO {

    protected String id;

    protected String name;

    protected LocalDate date;

    protected float mark;

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }


    public static class WithSubject extends ExamDTO {

        protected Subject subject;

        public Subject getSubject() {
            return subject;
        }

        public void setSubject(Subject subject) {
            this.subject = subject;
        }
    }
}
