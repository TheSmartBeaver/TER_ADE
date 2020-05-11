package ade.config;

import ade.repository.MetierRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = MetierRepository.class)
@Configuration
public class MongoDBConfig {

	/*Exemple utile ??*/
    @Bean
    CommandLineRunner commandLineRunner(MetierRepository metierRepo) {
        return strings -> {
            //metierRepo.save(new Metier(0, "Blabal", "code"));
        };
    }

}
