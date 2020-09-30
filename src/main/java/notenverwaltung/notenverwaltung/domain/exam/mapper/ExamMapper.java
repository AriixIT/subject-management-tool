package notenverwaltung.notenverwaltung.domain.exam.mapper;

import notenverwaltung.notenverwaltung.domain.exam.Exam;
import notenverwaltung.notenverwaltung.domain.exam.ExamDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;

@Mapper(componentModel="spring", unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface ExamMapper {

    Exam fromWithSubjectDTO(ExamDTO.WithSubject dto);

    Exam fromDTO(ExamDTO dto);

    Collection<Exam> fromDTOs(Collection<ExamDTO> examDTOS);

    @Named(value = "toExamDTO")
    ExamDTO toDTO(Exam exam);

    @IterableMapping(qualifiedByName = "toSemesterDTOs")
    Collection<ExamDTO> toDTOs(Collection<Exam> exams);
}
