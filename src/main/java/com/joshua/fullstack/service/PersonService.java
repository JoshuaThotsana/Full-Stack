package com.joshua.fullstack.service;

import com.joshua.fullstack.entity.Person;
import com.joshua.fullstack.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person savePerson(Person person) { return  repository.save(person); }

    public List<Person> saveAllPersons(List<Person> person) {
        return repository.saveAll(person);
    }

    public List<Person> getAllPersons() {
        return repository.findAll();
    }
    public Person getPersonById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Person getPersonByName(String name) {
        return repository.findByName(name);
    }

    public String deletePerson(int id) {
        repository.deleteById(id);
        return "Person removed !! " + id;
    }

    public Person updatePerson(Person person) {
        Person existingPerson = repository.findById(person.getId()).orElse(null);
        existingPerson.setName(person.getName());
        existingPerson.setEmail(person.getEmail());
        existingPerson.setExperience(person.getExperience());
        existingPerson.setDomain(person.getDomain());
        return repository.save(existingPerson);
    }

}
