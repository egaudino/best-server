package io.tusted.bestserver.usecases;

import io.tusted.bestserver.domains.Server;
import io.tusted.bestserver.gateways.ServerDatabaseGateway;
import java.util.Comparator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BestServer {

  private final PingServer pingServer;
  private final ServerDatabaseGateway serverDatabaseGateway;

  public Server execute() {
    List<Server> servers = serverDatabaseGateway.findAll();

    servers.stream()
        .forEach(server -> {
          String latency = pingServer.execute(server);
          server.setLatency(latency);
          serverDatabaseGateway.update(server);
        });
    return serverDatabaseGateway.findAll()
        .stream()
        .min(Comparator.comparing(Server::getLatency))
        .get();

  }

}
