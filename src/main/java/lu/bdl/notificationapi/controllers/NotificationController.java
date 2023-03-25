package lu.bdl.notificationapi.controllers;
import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lu.bdl.notificationapi.dto.NotificationDTO;
import lu.bdl.notificationapi.dto.NotificationInsertDTO;
import lu.bdl.notificationapi.services.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/notifications")
@AllArgsConstructor
public class NotificationController {

  private final NotificationService notificationService;

  @GetMapping(produces = TEXT_EVENT_STREAM_VALUE)
  public Flux<NotificationDTO> notificationsStream() {
    return notificationService.streamNotifications("LUDPAQ7");
  }

  @PostMapping()
  public ResponseEntity<Empty> createNotifications(NotificationInsertDTO notification) {
    this.notificationService.createNotification(notification);
    return new ResponseEntity(HttpStatus.CREATED);
  }

  @PostMapping("/{id}/read")
  public ResponseEntity<Empty> readNotification(@PathVariable Integer id) {
    this.notificationService.read(id, "LUDPAQ7"); // TODO get user from Token
    return new ResponseEntity(HttpStatus.CREATED);
  }
}

