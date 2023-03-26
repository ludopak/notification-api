package lu.bdl.notificationapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity()
@Table(name = "Notifications")
public class Notification {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer id;

  @Column(name = "event_type", columnDefinition = "varchar(10)")
  private String eventType;

  @Column(name = "message", columnDefinition = "TEXT")
  private String message;

  @Column(name = "user_id", columnDefinition = "varchar(7)")
  private String userId;

  @Column(name = "user_group", columnDefinition = "varchar(20)")
  private String userGroup;
}
