package io.tusted.bestserver.gateways.mongodb;

import com.mongodb.MongoException;
import io.tusted.bestserver.domains.Server;
import io.tusted.bestserver.gateways.ServerDatabaseGateway;
import io.tusted.bestserver.gateways.mongodb.repositories.ServerRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
  public Server update(Server server) {
    Query query = new Query();
    query.addCriteria(Criteria.where("hostname").is(server.getHostname()));
    Update update = new Update();
    update.set("latency", server.getLatency());
    log.info("Updating server: {} - Latency: {} ", server.getHostname(), server.getLatency());

    return mongoTemplate.findAndModify(query, update, Server.class);
  }

  @Override
  public List<Server> findAll() {
    return serverRepository.findAll();
  }
}
