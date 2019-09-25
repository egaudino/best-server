package io.tusted.bestserver.gateways;

import io.tusted.bestserver.domains.Server;
import java.util.List;

public interface ServerDatabaseGateway {

  Server save(Server server);

  List<Server> findAll();

}
