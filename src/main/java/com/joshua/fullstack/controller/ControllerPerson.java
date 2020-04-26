package com.joshua.fullstack.controller;

import com.joshua.fullstack.entity.Person;
import com.joshua.fullstack.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ControllerPerson {

    @Autowired
    private PersonService service;

    @PostMapping("/addPerson")
    public Person addProduct(@RequestBody Person person) {
        return service.savePerson(person);
    }

    @PostMapping("/addAllPersons")
    public List<Person> addAllProducts(@RequestBody List<Person> person) {
        return service.saveAllPersons(person);
    }

    @GetMapping("/Persons")
    public List<Person> findAllProducts() {
        return service.getAllPersons();
    }

    @GetMapping("/PersonById/{id}")
    public Person findProductById(@PathVariable int id) {
        return service.getPersonById(id);
    }

    @GetMapping("/PersonByName/{name}")
    public Person findProductByName(@PathVariable String name) {
        return service.getPersonByName(name);
    }

    @PutMapping("/update")
    public Person updateProduct(@RequestBody Person person) {
        return service.updatePerson(person);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deletePerson(id);
    }

}
