package com.qa.controllers;

import com.qa.models.Load;
import com.qa.repository.LoadoutsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class LoadController {

    @Autowired
    private LoadoutsRepository repository;

    @RequestMapping(value = "LOs", method = RequestMethod.GET)
    public List<Load> listAllLOs() {
        return repository.findAll();
    }

    @RequestMapping(value = "LOs", method = RequestMethod.POST)
    public Load addLoad(@RequestBody Load note) {
        return repository.saveAndFlush(note);
    }

    @RequestMapping(value = "LOs/{id}", method = RequestMethod.GET)
    public Load getLoad(@PathVariable Long id){
        return repository.findOne(id);
    }

    @RequestMapping(value = "LOs/{id}", method = RequestMethod.DELETE)
    public Load deleteLoad(@PathVariable Long id) {
        Load existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }
}
