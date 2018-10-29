package com.example.controller;


import com.example.domain.Animal;
import com.example.repository.AnimalRepository;
import com.example.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private AnimalService animalService;

    @RequestMapping(value = "/votes/s", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Animal> getVotes() {
        return animalRepository.findAll();
    }


    @RequestMapping(value = "/votes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Animal saveVotes(@Validated Animal animal) {
        return animalService.save(animal);
    }
}
