package com.example;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Persona;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/api")
@RestController
public class PersonaController {

    private final PersonaService service;

    public PersonaController(PersonaService service) {
        this.service = service;
    }

    @GetMapping("/personas")
    public List<Persona> findAll(){
        return service.findAll();
    }
    @GetMapping("/personas/{id}")
    public Persona findById(@PathVariable Long id){
        return service.findById(id);
    }
    @PostMapping("/personas")
    public Persona createPersona(@RequestBody Persona persona){
        return service.savePersona(persona);

    }
    @DeleteMapping("/personas/{id}")
    public void deletePersona(Long id){
        service.delete(id);
    }

    @PutMapping("/personas/{id}")
    public Persona updatePersona(@RequestBody Persona persona,Long id){
        return service.update(id, persona);
    }
    
    @PatchMapping
    public Persona partialUpdate(@RequestBody PersonaDTO personaDTO,Long id){
        return service.updatePartial(personaDTO, id);
    }

    
    

}
