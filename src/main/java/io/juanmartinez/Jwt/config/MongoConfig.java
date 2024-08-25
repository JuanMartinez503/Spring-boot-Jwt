package io.juanmartinez.Jwt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "io.juanmartinez.Jwt.repo")
public class MongoConfig
{
}
