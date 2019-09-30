package io.tusted.bestserver.gateways.http.controllers;

import io.tusted.bestserver.domains.Server;
import io.tusted.bestserver.gateways.http.jsons.ServerRequest;
import io.tusted.bestserver.usecases.BestServer;
import io.tusted.bestserver.usecases.UpdateServerLatency;
import io.tusted.bestserver.usecases.CreateServer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/server")
@RequiredArgsConstructor
public class ServerController {

  private final CreateServer createServer;
  private final UpdateServerLatency updateServerLatency;
  private final BestServer bestServer;

  @PostMapping
  public ResponseEntity<Server> create(@RequestBody final ServerRequest serverRequest) {
    return ResponseEntity.ok(createServer.execute(serverRequest.toDomain()));
  }

  @GetMapping
  public ResponseEntity<Server> getUpdateServerLatency() {
    return ResponseEntity.ok(bestServer.execute());
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public void updateServersLatency() {
    updateServerLatency.execute();
  }

}
