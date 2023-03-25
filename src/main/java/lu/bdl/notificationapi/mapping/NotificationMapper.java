package lu.bdl.notificationapi.mapping;

import java.util.List;
import lu.bdl.notificationapi.dto.NotificationDTO;
import lu.bdl.notificationapi.dto.NotificationInsertDTO;
import lu.bdl.notificationapi.entities.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface NotificationMapper {
  Notification dtoToEntity(NotificationDTO notificationDTO);

  NotificationDTO entityToDto(Notification notification);

  List<NotificationDTO> entitiesToDtos(List<Notification> notifications);

  List<Notification> dtosToEntities(List<NotificationDTO> notifications);


  @Mapping(source = "destinationUser", target = "userId")
  @Mapping(source = "destinationGroup", target = "userGroup")
  Notification insertDtoToEntity(NotificationInsertDTO notificationDTO);

  @Mapping(target = "destinationUser", source = "userId")
  @Mapping(target = "destinationGroup", source = "userGroup")
  NotificationInsertDTO entityToInsertDto(Notification notification);

}
