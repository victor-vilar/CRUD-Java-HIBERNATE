package com.victorvilar.projetoempresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.victorvilar.projetoempresa.entities.Client;
import com.victorvilar.projetoempresa.exceptions.InvalidCpfOrCnpjException;
import com.victorvilar.projetoempresa.services.ClientService;

@RestController
public class ClientController {

	
	private final ClientService service;
	
	@Autowired
	public ClientController(ClientService service) {
		this.service = service;
	}
	
	/**
	 * get all clients
	 * @param as
	 */
	@GetMapping("/clients")
	public List<Client> getAllClients(){
		return this.service.getAllClients();
	}
	
	@GetMapping("/clients/{id}")
	public Client getClientById(@PathVariable Long id) {
		return this.service.getClientById(id);
	}
	
	/**
	 * Sing in a new Client
	 * @param as
	 */
	@PostMapping("/clients")
	public void addNewClient(@RequestBody Client client) {
		
		try {
			this.service.addNewClient(client);
		}catch(InvalidCpfOrCnpjException e) {
			System.out.println(e.getMessage());
		}
	
	}
}