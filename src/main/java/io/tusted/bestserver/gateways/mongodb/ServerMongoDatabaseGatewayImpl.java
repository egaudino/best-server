package io.tusted.bestserver.gateways.mongodb;

import com.mongodb.MongoException;
import io.tusted.bestserver.domains.Server;
import io.tusted.bestserver.gateways.ServerDatabaseGateway;
import io.tusted.bestserver.gateways.mongodb.repositories.ServerRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ServerMongoDatabaseGatewayImpl implements ServerDatabaseGateway {

  private final ServerRepository serverRepository;
  private final MongoTemplate mongoTemplate;

  @Override
  public Server save(final Server server) {
    try {
      log.info("Saving server: {}", server.getHostname());
      return serverRepository.save(server);
    } catch (Exception e) {
      log.error("Error saving server: {}", server.getHostname());
      throw new MongoException(e.getMessage());
    }
  }

  @Override
  public List<Server> findAll() {
    return serverRepository.findAll();
  }
}
