package io.tusted.bestserver.gateways.http.jsons;

import io.tusted.bestserver.domains.Server;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerRequest {

  private String hostname;
  private String ipAddress;
  private String region;
  private String latency;

  public Server toDomain() {
    return Server.builder()
        .hostname(this.hostname)
        .ipAddress(this.ipAddress)
        .region(this.region)
        .latency(this.latency)
        .build();
  }

}
