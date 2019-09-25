package io.tusted.bestserver.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "servers")
public class Server {

  private String hostname;
  private String ipAddress;
  private String region;
  private String latency;
}
