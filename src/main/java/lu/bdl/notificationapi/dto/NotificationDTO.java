package lu.bdl.notificationapi.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class NotificationDTO {
  private String message;
  private String eventType;

}
