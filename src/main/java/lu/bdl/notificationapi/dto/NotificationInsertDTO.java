package lu.bdl.notificationapi.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class NotificationInsertDTO {
  private String destinationUser;
  private String destinationGroup;
  private String message;
  private String eventType;

}
