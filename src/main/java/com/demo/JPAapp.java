package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.demo.model.Player;
import com.demo.service.PlayerService;

//@SpringBootApplication
public class JPAapp {
    private static final Logger log = LoggerFactory.getLogger(JPAapp.class);

 // @Bean
  public CommandLineRunner demo(PlayerService service) {
    return (args) -> {
      // addPlayer a few Players
      service.addPlayer(new Player("Damien Cook", 55));
      service.addPlayer(new Player("Cassandra Willis", 66));
      service.addPlayer(new Player("Kris Ortis", 77));
      service.addPlayer(new Player("Steven Reuter", 88));
      service.addPlayer(new Player("Michael Ballack", 45));

      // fetch all Players
      log.info("Players found with findAll():");
      log.info("-------------------------------");
      for (Player player : service.players()) {
        log.info(player.toString());
      }
      log.info("");

      // fetch an individual Player by ID
      Player player = service.player(101);
      log.info("Player found with findById(1L):");
      log.info("--------------------------------");
      log.info(player.toString());
      log.info("");      
    };
  }
}
