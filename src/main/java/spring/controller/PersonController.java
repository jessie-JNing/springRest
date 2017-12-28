package spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.dao.PersonRepository;
import spring.model.Person;

import java.io.IOException;
import java.util.List;

@RestController
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(path="/person/all", method = RequestMethod.GET)
    public List<Person> getAllPerson() throws IOException {

        List<Person> persons = personRepository.findAll();
        LOGGER.info("The number of person record in db is {}", persons.size());
        return persons;
    }

    @RequestMapping(path = "/person/add", method = RequestMethod.POST)
    @ResponseBody
    public Person addPerson() {
        Person person = new Person("postFirst", "postLast");
        personRepository.saveAndFlush(person);
        LOGGER.info("Put person={} in to repository.");
        return person;
    }

    // url = /person?id=1
    @RequestMapping(value="/person", params = {"id=1"})
    public Person getPersonByIdParam(@RequestParam("id") long id) {
        Person person = personRepository.findOne(id);
        LOGGER.info("Get person={} with id={} from repository.");
        return person;
    }

    // url = /person/1
    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Person getPersonByIdVariable(@PathVariable("id") long id) {
        Person person = personRepository.findOne(id);
        LOGGER.info("Get person={} with id={} from repository.");
        return person;
    }

}