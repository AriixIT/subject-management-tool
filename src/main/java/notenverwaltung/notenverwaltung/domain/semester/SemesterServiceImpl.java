package notenverwaltung.notenverwaltung.domain.semester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SemesterServiceImpl implements SemesterService {

    private SemesterRepository semesterRepository;

    @Autowired
    public SemesterServiceImpl(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    public Semester findById(String id) {
        return semesterRepository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("Semester with ID '%s' not found", id)));
    }

    @Override
    public List<Semester> getAllSemester() {
        return semesterRepository.findAll();
    }

    @Override
    public Semester getSemesterById(String id) {
        return findById(id);
    }

    @Override
    public Semester createSemester(Semester semester) {
        semesterRepository.save(semester);
        return semester;
    }

    @Override
    public Semester updateSemesterById(String id, Semester semester) {
        Semester oldSemester = findById(id);

        oldSemester.setName(semester.getName());

        semesterRepository.save(oldSemester);

        return oldSemester;
    }

    @Override
    public String deleteSemesterById(String id) {
        semesterRepository.deleteById(id);
        return id;
    }
}
