package notenverwaltung.notenverwaltung.domain.semester.mapper;

import notenverwaltung.notenverwaltung.domain.semester.Semester;
import notenverwaltung.notenverwaltung.domain.semester.SemesterDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;

@Mapper(componentModel="spring", unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface SemesterMapper {

    Semester fromWithUserDTO(SemesterDTO.WithUser dto);

    Semester fromDTO(SemesterDTO dto);

    Collection<Semester> fromDTOs(Collection<SemesterDTO> semesterDTOS);

    @Named(value = "toSemesterDTO")
    SemesterDTO toDTO(Semester semester);

    @IterableMapping(qualifiedByName = "toSemesterDTOs")
    Collection<SemesterDTO> toDTOs(Collection<Semester> semesters);
}
