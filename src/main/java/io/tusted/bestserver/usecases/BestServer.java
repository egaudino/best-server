package io.tusted.bestserver.usecases;

import io.tusted.bestserver.domains.Server;
import io.tusted.bestserver.gateways.ServerDatabaseGateway;
import java.util.Comparator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BestServer {

  private final ServerDatabaseGateway serverDatabaseGateway;

  public Server execute() {
    return serverDatabaseGateway.findAll()
        .stream()
        .min(Comparator.comparing(Server::getLatency))
        .get();
  }

}
