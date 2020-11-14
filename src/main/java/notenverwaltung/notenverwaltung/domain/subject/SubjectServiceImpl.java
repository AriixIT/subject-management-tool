package notenverwaltung.notenverwaltung.domain.subject;

import notenverwaltung.notenverwaltung.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject findById(String id) {
        return subjectRepository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("Subject with ID '%s' not found", id)));
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getSubjectById(String id) {
        return findById(id);
    }

    @Override
    public Subject createSubject(Subject subject) {
        subjectRepository.save(subject);
        return subject;
    }

    @Override
    public Subject updateSubjectById(String id, Subject subject) {
        Subject oldSubject = findById(id);

        oldSubject.setName(subject.getName());

        subjectRepository.save(oldSubject);

        return oldSubject;
    }

    @Override
    public String deleteSubjectById(String id) {
        subjectRepository.deleteById(id);
        return id;
    }
}
