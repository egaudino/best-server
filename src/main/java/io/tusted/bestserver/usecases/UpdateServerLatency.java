package io.tusted.bestserver.usecases;

import io.tusted.bestserver.gateways.ServerDatabaseGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateServerLatency {

  private final PingServer pingServer;
  private final ServerDatabaseGateway serverDatabaseGateway;

  public void execute() {
    serverDatabaseGateway.findAll()
        .stream()
        .forEach(server -> {
          String latency = pingServer.execute(server);
          server.setLatency(latency);
          serverDatabaseGateway.update(server);
        });
  }
}
