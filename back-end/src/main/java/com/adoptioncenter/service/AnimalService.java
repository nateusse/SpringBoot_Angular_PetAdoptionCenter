package com.adoptioncenter.service;

import com.adoptioncenter.exceptions.UserNotFoundException;
import com.adoptioncenter.model.Animal;
import com.adoptioncenter.repository.AnimalRepository;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;


    @Autowired
    public AnimalService(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;
    }

    public Animal addAnimal(Animal animal){
        return animalRepository.save(animal);

    }

    public List<Animal> findAnimal(){
        return animalRepository.findAll();
    }

    public Animal updateAnimal(Animal animal){
        return animalRepository.save(animal);
    }

    public Animal findAnimalByID(Long id){
        return animalRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Animal by id" + id + "was not found"));
    }
    public void deleteAnimal(Long id){
        animalRepository.deleteById(id);
    }
}
