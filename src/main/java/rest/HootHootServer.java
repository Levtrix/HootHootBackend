package rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "rest")
@EntityScan("models")
public class HootHootServer {
    public static void main(String[] args) {
        SpringApplication.run(HootHootServer.class, args);
    }
}
