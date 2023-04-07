package com.adoptioncenter.controller;


import com.adoptioncenter.model.Animal;
import com.adoptioncenter.service.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Animal>> getAllAnimals(){
        List<Animal> animals = animalService.findAnimal();
        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable("id") Long id){
        Animal animal = animalService.findAnimalByID(id);
        return new ResponseEntity<>(animal, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Animal> addAnimal(@RequestBody Animal animal){
        Animal newAnimal = animalService.addAnimal(animal);
        return new ResponseEntity<>(animal, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Animal> updateAnimal(@RequestBody Animal animal){
        Animal updateAnimal = animalService.updateAnimal(animal);
        return new ResponseEntity<>(updateAnimal, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> updateAnimal(@PathVariable("id") Long id){
        animalService.deleteAnimal(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
