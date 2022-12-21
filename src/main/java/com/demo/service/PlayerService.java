package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.*;
import com.demo.repository.PlayerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Transactional
    public List<Player> players() {        
        return repository.findAll();
    }

    @Transactional
    public Player player(int ID) {        
        return repository.findById(ID).get();
    }

    @Transactional
    public void addPlayer(Player player) {
        repository.save(player);
    }

    @Transactional
    public void deletePlayer(int ID) {        
        repository.deleteById(ID);
    }

    @Transactional
    public void updatePlayer(int ID, Player requestBodyPlayer) {
        
        Player player = player(ID);
        player.setName(requestBodyPlayer.getName());
        player.setScore(requestBodyPlayer.getScore());
        repository.save(player);
    }

    @Transactional
    public void updatePlayer(String name, int score, int ID) {
        repository.updatePlayer(name, score, ID);  
    }
    
    public String jsonString(Object object) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();  
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        return writer.writeValueAsString(object);
    }
}
