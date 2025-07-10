package com.example;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    private final PersonaRepository repository;

    public PersonaService(PersonaRepository repository) {
        this.repository = repository;
    }

    public List<Persona> findAll(){
        return repository.findAll();
    }
    public Persona savePersona(Persona persona){
        return repository.save(persona);
    }
    public Persona findById(Long id){
        return repository.findById(id).orElse(null);

    }
    public Persona update(Long id,Persona persona){
        return repository.findById(id).map(per ->{
            per.setNombre(persona.getNombre());
            per.setCorreo(persona.getCorreo());
            per.setEdad(persona.getEdad());;
            return repository.save(per);
        }).orElseThrow(()-> new RuntimeException("Persona no encontrada"));
    }
    public void delete(Long id){
        repository.deleteById(id);
    }

    public Persona updatePartial(PersonaDTO personaDTO,Long id){
        return repository.findById(id).map(existingPerson ->{
         personaDTO.getNombre().ifPresent(existingPerson::setNombre);
         personaDTO.getCorreo().ifPresent(existingPerson::setCorreo);
         personaDTO.getEdad().ifPresent(existingPerson::setEdad);
            return repository.save(existingPerson);
        }).orElseThrow(()->new RuntimeException("Persona no encontrada"));
    }
    

}
