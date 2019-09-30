package io.tusted.bestserver.usecases;

import io.tusted.bestserver.domains.Server;
import io.tusted.bestserver.gateways.ServerDatabaseGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateServer {

  private final ServerDatabaseGateway serverDatabaseGateway;
  private final PingServer pingServer;

  public Server execute(final Server server) {
    server.setLatency(pingServer.execute(server));
    return serverDatabaseGateway.save(server);
  }
}
