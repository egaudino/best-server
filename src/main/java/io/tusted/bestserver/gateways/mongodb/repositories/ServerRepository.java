package io.tusted.bestserver.gateways.mongodb.repositories;

import io.tusted.bestserver.domains.Server;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServerRepository extends MongoRepository<Server, String> {

}
