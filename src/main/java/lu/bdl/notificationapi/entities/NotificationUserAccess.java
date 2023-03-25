package lu.bdl.notificationapi.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Notification_user_access")
@Data
public class NotificationUserAccess {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(name = "user_id", columnDefinition = "varchar(7)")
  private String user;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "notification_id", referencedColumnName = "id", columnDefinition = "integer")
  private Notification notification;

  @Column(name = "is_read", columnDefinition = "bit")
  private Boolean read;
}
