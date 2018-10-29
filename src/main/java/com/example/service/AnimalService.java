package com.example.service;


import com.example.domain.Animal;
import com.example.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public Animal save(Animal model) {
        String name = model.getName();
        Animal animal = animalRepository.findByName(name);
        if (animal != null) {
            Integer votes = animal.getVotes();
            animal.setVotes(votes + 1);
            return animalRepository.save(animal);
        } else {
            return animalRepository.save(model);
        }
    }
}
