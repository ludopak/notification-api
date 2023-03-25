package lu.bdl.notificationapi.repository;

import lu.bdl.notificationapi.entities.Notification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository   extends CrudRepository<Notification, Long>,
    JpaSpecificationExecutor<Notification> {

}
