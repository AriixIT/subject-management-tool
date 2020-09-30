package notenverwaltung.notenverwaltung.domain.user.mapper;

import notenverwaltung.notenverwaltung.domain.user.User;
import notenverwaltung.notenverwaltung.domain.user.UserDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;

@Mapper(componentModel="spring", unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface UserMapper {

    User fromDTO(UserDTO dto);

    User fromLoginDTO(UserDTO.Login dto);

    @Named(value = "toUserLoginDTO")
    UserDTO.Login toLoginDTO(User user);

    Collection<User> fromDTOs(Collection<UserDTO> users);

    @Named(value = "toUserDTO")
    UserDTO toDTO(User user);

    @IterableMapping(qualifiedByName = "toUserDTO")
    Collection<UserDTO> toDTOs(Collection<User> users);
}
