package io.tusted.bestserver.configs;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

  @Override
  public MongoClient mongoClient() {
    return new MongoClient("127.0.0.1", 27017);
  }

  @Override
  protected String getDatabaseName() {
    return "bestserver";
  }

  @Override
  protected String getMappingBasePackage() {
    return "io.tusted";
  }
}
