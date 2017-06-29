package fr.demandeatonton.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.demandeatonton.exceptions.ObjectNotFoundException;
import fr.demandeatonton.model.beans.Programmer;
import fr.demandeatonton.model.repositories.MemoryRepository;

@RestController
@RequestMapping("/programmers")
public class CustomerController {
	private final MemoryRepository repository;

	@Autowired
	public CustomerController(MemoryRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Programmer getProgrammer(@PathVariable("id") Integer id) {
		Programmer programmer = repository.findById(id);
		if (programmer == null) {
			throw new ObjectNotFoundException("Programmeur inconnu - id: " + id);
		}
		return programmer;
	}

}