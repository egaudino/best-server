package io.tusted.bestserver.gateways.http;

import io.tusted.bestserver.domains.Server;
import io.tusted.bestserver.gateways.ServerDatabaseGateway;
import io.tusted.bestserver.gateways.http.jsons.ServerRequest;
import io.tusted.bestserver.usecases.CreateServer;
import java.util.Comparator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/server")
@RequiredArgsConstructor
public class ServerController {

  private final CreateServer createServer;
  private final ServerDatabaseGateway serverDatabaseGateway;

  @PostMapping
  public ResponseEntity<Server> create(@RequestBody final ServerRequest serverRequest) {
    return ResponseEntity.ok(createServer.execute(serverRequest.toDomain()));
  }

  @GetMapping
  public ResponseEntity<Server> getBestServer() {
    return ResponseEntity.ok(serverDatabaseGateway.findAll()
        .stream()
        .min(Comparator.comparing(Server::getLatency)).get());
  }

}
