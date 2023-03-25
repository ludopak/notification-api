package lu.bdl.notificationapi.services;

import java.util.function.Consumer;
import lu.bdl.notificationapi.dto.NotificationDTO;
import reactor.core.publisher.FluxSink;

public class FluxSinkService implements Consumer<FluxSink<NotificationDTO>> {

  private FluxSink<NotificationDTO> fluxSink;

  @Override
  public void accept(FluxSink<NotificationDTO> integerFluxSink) {
    this.fluxSink = integerFluxSink;
  }

  public void publishEvent(NotificationDTO event){
    this.fluxSink.next(event);
  }

}
