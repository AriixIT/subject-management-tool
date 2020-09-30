package notenverwaltung.notenverwaltung.domain.subject.mapper;

import notenverwaltung.notenverwaltung.domain.subject.Subject;
import notenverwaltung.notenverwaltung.domain.subject.SubjectDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;

@Mapper(componentModel="spring", unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface SubjectMapper {

    Subject fromWithSemesterDTO(SubjectDTO.WithSemester dto);

    Subject fromDTO(SubjectDTO dto);

    Collection<Subject> fromDTOs(Collection<SubjectDTO> subjectDTOS);

    @Named(value = "toSubjectDTO")
    SubjectDTO toDTO(Subject user);

    @IterableMapping(qualifiedByName = "toSubjectDTOs")
    Collection<SubjectDTO> toDTOs(Collection<Subject> subjects);
}
