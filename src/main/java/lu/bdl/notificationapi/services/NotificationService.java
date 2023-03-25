package lu.bdl.notificationapi.services;

import java.time.Duration;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import lu.bdl.notificationapi.dto.NotificationDTO;
import lu.bdl.notificationapi.dto.NotificationInsertDTO;
import lu.bdl.notificationapi.entities.NotificationUserAccess;
import lu.bdl.notificationapi.mapping.NotificationMapper;
import lu.bdl.notificationapi.repository.NotificationRepository;
import lu.bdl.notificationapi.repository.NotificationUserAccessRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@RequiredArgsConstructor
@Service
public class NotificationService {

  FluxSinkService publisher = new FluxSinkService();

  private final NotificationRepository notificationRepository;
  private final NotificationMapper mapper;
  private final NotificationUserAccessRepository notificationUserAccessRepository;

  public void createNotification(NotificationInsertDTO notificationDTO) {
    var notification = mapper.insertDtoToEntity(notificationDTO);
    var saved = notificationRepository.save(notification);
    publisher.publishEvent(mapper.entityToDto(saved));
  }

  // TODO filter by user
  public Flux<NotificationDTO> notifications(String userId) {
    return Flux.fromIterable(mapper.entitiesToDtos(
        StreamSupport.stream(this.notificationRepository.findAll().spliterator(), false).collect(
            Collectors.toList())));
  }

  public void read(Integer notificationId, String user) {
    var notification = this.notificationRepository.findById(notificationId.longValue());
    if (notification.isPresent()) {
      var notificationUserAccess = new NotificationUserAccess();
      notificationUserAccess.setNotification(notification.get());
      notificationUserAccess.setUser(user);
      notificationUserAccess.setRead(true);
      this.notificationUserAccessRepository.save(notificationUserAccess);
    }
  }

  public Flux<NotificationDTO> streamNotifications(String userID) {
    Flux<NotificationDTO> integerFlux = Flux.create(publisher).delayElements(Duration.ofMillis(1))
        .share();
    return Flux.concat(notifications(userID), integerFlux);
  }

}
