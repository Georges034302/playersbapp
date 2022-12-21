package com.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.*;
import com.demo.service.PlayerService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/api")
public class PlayerController {

	@Autowired
	private PlayerService service;

	@GetMapping("/")
	public String index() {
		String output = "Hello From SpringBoot";
		output += "<br>Spring Version: " + SpringVersion.getVersion();
		output += "<br>Java Version: " + System.getProperty("java.version");
		return output;
	}

	@GetMapping(value = "/players", produces = { MediaType.APPLICATION_JSON_VALUE })
	public String players() throws JsonProcessingException {
		return service.jsonString(service.players());
	}

	@GetMapping(value = "/player/{ID}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public String getPlayer(@PathVariable int ID) throws JsonProcessingException {
		return service.jsonString(service.player(ID));
	}

	@RequestMapping(value = "/add")
	public ResponseEntity<Player> add(@RequestBody Player player) {
		try {
			service.addPlayer(player);
			return new ResponseEntity<>(player, HttpStatus.OK);
		} catch (NoSuchElementException ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// @PutMapping(value = "/update/{ID}")
	// public ResponseEntity<Player> update(@PathVariable("ID") int ID, @RequestParam("name") String name,@RequestParam("score") int score) {
	// 	try {
	// 		service.updatePlayer(name, score, ID);
	// 		return new ResponseEntity<>(HttpStatus.OK);
	// 	} catch (NoSuchElementException ex) {
	// 		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// 	}
	// }

	@PutMapping(value = "/update/{ID}")
	public ResponseEntity<Player> update(@PathVariable("ID") int ID, @RequestBody Player player) {
		try {
			service.updatePlayer(ID, player);
			return new ResponseEntity<>(player, HttpStatus.OK);
		} catch (NoSuchElementException ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		try {
			service.deletePlayer(id);
			return new ResponseEntity<>("Player-" + id + " record is deleted successfully", HttpStatus.OK);
		} catch (NoSuchElementException ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}