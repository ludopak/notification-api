package lu.bdl.notificationapi.repository;

import lu.bdl.notificationapi.entities.Notification;
import lu.bdl.notificationapi.entities.NotificationUserAccess;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationUserAccessRepository extends CrudRepository<NotificationUserAccess, Long>,
    JpaSpecificationExecutor<NotificationUserAccess> {

}
